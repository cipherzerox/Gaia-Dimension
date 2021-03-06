package androsa.gaiadimension.block;

import androsa.gaiadimension.registry.GDBlocks;
import androsa.gaiadimension.registry.GDConfig;
import androsa.gaiadimension.registry.GDTabs;
import androsa.gaiadimension.registry.ModelRegisterCallback;
import androsa.gaiadimension.world.TeleporterGaia;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

@MethodsReturnNonnullByDefault
public class GDGaiaPortal extends BlockPortal implements ModelRegisterCallback {

    public GDGaiaPortal() {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.X));
        this.setTickRandomly(true);
        this.setCreativeTab(GDTabs.tabBlock);
        this.setLightLevel(1.0F);
    }

    public static int getMetaForAxis(EnumFacing.Axis axis) {
        if (axis == EnumFacing.Axis.X) {
            return 1;
        } else {
            return axis == EnumFacing.Axis.Z ? 2 : 0;
        }
    }

    public boolean tryToCreatePortal(World worldIn, BlockPos pos) {
        GDGaiaPortal.Size blockportal$size = new GDGaiaPortal.Size(worldIn, pos, EnumFacing.Axis.X);

        if (blockportal$size.isValid() && blockportal$size.portalBlockCount == 0 && canCreatePortalByWorld(worldIn, pos)) {
            blockportal$size.placePortalBlocks();
            return true;
        } else {
            GDGaiaPortal.Size blockportal$size1 = new GDGaiaPortal.Size(worldIn, pos, EnumFacing.Axis.Z);

            if (blockportal$size1.isValid() && blockportal$size1.portalBlockCount == 0 && canCreatePortalByWorld(worldIn, pos)) {
                blockportal$size1.placePortalBlocks();
                return true;
            } else {
                return false;
            }
        }
    }

    // This will check for creation conditions in the Overworld or Gaia
    private boolean canCreatePortalByWorld(World world, BlockPos pos) {
        Biome biome = world.getBiome(pos);

        if (world.provider.getDimension() == 0)
            return BiomeDictionary.hasType(biome, Type.HOT) || BiomeDictionary.hasType(biome, Type.MOUNTAIN) || BiomeDictionary.hasType(biome, Type.DRY);
        else
            return world.provider.getDimension() == GDConfig.dimension.dimensionID;
    }

    @Override
    public void neighborChanged(IBlockState state, @Nullable World worldIn, @Nullable BlockPos pos, Block blockIn, BlockPos fromPos) {
        EnumFacing.Axis enumfacing$axis = state.getValue(AXIS);

        if (enumfacing$axis == EnumFacing.Axis.X) {
            GDGaiaPortal.Size blockportal$size = new GDGaiaPortal.Size(worldIn, pos, EnumFacing.Axis.X);

            if (!blockportal$size.isValid() || blockportal$size.portalBlockCount < blockportal$size.width * blockportal$size.height) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
        else if (enumfacing$axis == EnumFacing.Axis.Z) {
            GDGaiaPortal.Size blockportal$size1 = new GDGaiaPortal.Size(worldIn, pos, EnumFacing.Axis.Z);

            if (!blockportal$size1.isValid() || blockportal$size1.portalBlockCount < blockportal$size1.width * blockportal$size1.height) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing side) {
        EnumFacing.Axis enumfacing$axis = null;

        if (blockState.getBlock() == this) {
            enumfacing$axis = state.getValue(AXIS);

            if (enumfacing$axis == null) {
                return false;
            }

            if (enumfacing$axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {
                return false;
            }

            if (enumfacing$axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {
                return false;
            }
        }

        boolean flag = access.getBlockState(pos.west()).getBlock() == this && access.getBlockState(pos.west(2)).getBlock() != this;
        boolean flag1 = access.getBlockState(pos.east()).getBlock() == this && access.getBlockState(pos.east(2)).getBlock() != this;
        boolean flag2 = access.getBlockState(pos.north()).getBlock() == this && access.getBlockState(pos.north(2)).getBlock() != this;
        boolean flag3 = access.getBlockState(pos.south()).getBlock() == this && access.getBlockState(pos.south(2)).getBlock() != this;
        boolean flag4 = flag || flag1 || enumfacing$axis == EnumFacing.Axis.X;
        boolean flag5 = flag2 || flag3 || enumfacing$axis == EnumFacing.Axis.Z;

        return flag4 && side == EnumFacing.WEST || (flag4 && side == EnumFacing.EAST || (flag5 && side == EnumFacing.NORTH || flag5 && side == EnumFacing.SOUTH));
    }

    @Override
    public void onEntityCollision(World worldIn, @Nullable BlockPos pos, IBlockState state, Entity entityIn) {

        if (!entityIn.isRiding() && !entityIn.isBeingRidden() && !worldIn.isRemote)
            if (entityIn.timeUntilPortal <= 0) {
                if (entityIn instanceof EntityPlayerMP) {
                    EntityPlayerMP thePlayer = (EntityPlayerMP)entityIn;

                    thePlayer.timeUntilPortal = entityIn.getPortalCooldown();
                    if (thePlayer.dimension != GDConfig.dimension.dimensionID) {
                        if(!ForgeHooks.onTravelToDimension(thePlayer, GDConfig.dimension.dimensionID)) return;
                        thePlayer.server.getPlayerList().transferPlayerToDimension(thePlayer, GDConfig.dimension.dimensionID, new TeleporterGaia(thePlayer.server.getWorld(GDConfig.dimension.dimensionID), this, GDBlocks.keystone_block.getDefaultState()));
                    } else {
                        if(!ForgeHooks.onTravelToDimension(thePlayer, 0)) return;
                        thePlayer.server.getPlayerList().transferPlayerToDimension(thePlayer, 0, new TeleporterGaia(thePlayer.server.getWorld(0), this, GDBlocks.keystone_block.getDefaultState()));
                    }
                } else {
                    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                    entityIn.timeUntilPortal = entityIn.getPortalCooldown();

                    if(entityIn.dimension != GDConfig.dimension.dimensionID){
                        if(!ForgeHooks.onTravelToDimension(entityIn, GDConfig.dimension.dimensionID)) return;

                        int i = entityIn.dimension;
                        entityIn.dimension = GDConfig.dimension.dimensionID;
                        worldIn.removeEntityDangerously(entityIn);
                        entityIn.isDead = false;
                        server.getPlayerList().transferEntityToWorld(entityIn, i, server.getWorld(i), server.getWorld(GDConfig.dimension.dimensionID), new TeleporterGaia(server.getWorld(GDConfig.dimension.dimensionID), this, GDBlocks.keystone_block.getDefaultState()));
                    } else {
                        if(!ForgeHooks.onTravelToDimension(entityIn, 0)) return;

                        entityIn.dimension = 0;
                        worldIn.removeEntityDangerously(entityIn);
                        entityIn.isDead = false;
                        server.getPlayerList().transferEntityToWorld(entityIn, GDConfig.dimension.dimensionID, server.getWorld(GDConfig.dimension.dimensionID), server.getWorld(0), new TeleporterGaia(server.getWorld(0), this, GDBlocks.keystone_block.getDefaultState()));
                    }
                }
            } else entityIn.timeUntilPortal = entityIn.getPortalCooldown();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, @Nullable World worldIn, @Nullable BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)((float)pos.getY() + rand.nextFloat());
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;

            if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
                d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
            } else {
                d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }

            worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return getMetaForAxis(state.getValue(AXIS));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AXIS);
    }

    public static class Size {
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing rightDir;
        private final EnumFacing leftDir;
        private int portalBlockCount = 0;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(World worldIn, BlockPos pos, EnumFacing.Axis facing) {
            world = worldIn;
            axis = facing;

            if (facing == EnumFacing.Axis.X) {
                leftDir = EnumFacing.EAST;
                rightDir = EnumFacing.WEST;
            } else {
                leftDir = EnumFacing.NORTH;
                rightDir = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && isEmptyBlock(worldIn.getBlockState(pos.down()).getBlock()); pos = pos.down()) { }

            int i = getDistanceUntilEdge(pos, leftDir) - 1;

            if (i >= 0) {
                bottomLeft = pos.offset(leftDir, i);
                width = this.getDistanceUntilEdge(bottomLeft, rightDir);

                if (width < 2 || width > 21) {
                    bottomLeft = null;
                    width = 0;
                }
            }

            if (this.bottomLeft != null) {
                height = calculatePortalHeight();
            }
        }

        int getDistanceUntilEdge(BlockPos pos, EnumFacing facing) {
            int i;

            for (i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.offset(facing, i);

                if (!isEmptyBlock(world.getBlockState(blockpos).getBlock()) || world.getBlockState(blockpos.down()) != GDBlocks.keystone_block.getDefaultState()) {
                    break;
                }
            }

            IBlockState block = world.getBlockState(pos.offset(facing, i));
            return block == GDBlocks.keystone_block.getDefaultState() ? i : 0;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        int calculatePortalHeight() {
            label56:

            for (height = 0; height < 21; ++height) {
                for (int i = 0; i < width; ++i) {
                    BlockPos blockpos = bottomLeft.offset(rightDir, i).up(height);
                    IBlockState block = world.getBlockState(blockpos);

                    if (!isEmptyBlock(block.getBlock())) {
                        break label56;
                    }

                    if (block.getBlock() == GDBlocks.gaia_portal) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        block = world.getBlockState(blockpos.offset(leftDir));

                        if (block != GDBlocks.keystone_block.getDefaultState()) {
                            break label56;
                        }
                    } else if (i == this.width) {
                        block = world.getBlockState(blockpos.offset(rightDir));

                        if (block != GDBlocks.keystone_block.getDefaultState()) {
                            break label56;
                        }
                    }
                }
            }

            for (int j = 0; j < width; ++j) {
                if (world.getBlockState(bottomLeft.offset(rightDir, j).up(height)) != GDBlocks.keystone_block.getDefaultState()) {
                    height = 0;
                    break;
                }
            }

            if (height <= 21 && height >= 3) {
                return height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        boolean isEmptyBlock(Block blockIn) {
            IBlockState state = blockIn.getDefaultState();

            return state.getMaterial() == Material.AIR || blockIn == GDBlocks.gold_fire || blockIn == GDBlocks.gaia_portal;
        }

        public boolean isValid() {
            return bottomLeft != null && width >= 2 && width <= 21 && height >= 3 && this.height <= 21;
        }

        void placePortalBlocks() {
            for (int i = 0; i < this.width; ++i) {
                BlockPos blockpos = bottomLeft.offset(rightDir, i);

                for (int j = 0; j < height; ++j) {
                    world.setBlockState(blockpos.up(j), GDBlocks.gaia_portal.getDefaultState().withProperty(BlockPortal.AXIS, axis), 2);
                }
            }
        }
    }
}