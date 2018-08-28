package androsa.gaiadimension.biomes;

import androsa.gaiadimension.registry.GDBlocks;
import androsa.gaiadimension.world.gen.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class GDMutantAgateWildwood extends GDBiomeBase {

    private static final GDGenPinkAgateTree GaiaGenPinkTrees = new GDGenPinkAgateTree(false);           //30% chance
    private static final GDGenBlueAgateTreeSmall GaiaGenBlueTrees = new GDGenBlueAgateTreeSmall(false); //30% chance
    private static final GDGenGreenAgateTree GaiaGenGreenTrees = new GDGenGreenAgateTree(false);        //30% chance
    private static final GDGenPurpleAgateTree GaiaGenPurpleTrees = new GDGenPurpleAgateTree(false);     //10% chance
    private short[] skyColorRGB = new short[] { 241, 154, 193 };

    public GDMutantAgateWildwood(BiomeProperties props) {
        super(props);

        spawnableCreatureList.add(new SpawnListEntry(androsa.gaiadimension.entity.GDCommonGrowthSapper.class, 10, 3, 5));
        spawnableCreatureList.add(new SpawnListEntry(androsa.gaiadimension.entity.GDChilledGrowthSapper.class, 10, 3, 5));
        spawnableCreatureList.add(new SpawnListEntry(androsa.gaiadimension.entity.GDNutrientGrowthSapper.class, 10, 3, 5));
        spawnableCreatureList.add(new SpawnListEntry(androsa.gaiadimension.entity.GDMystifiedGrowthSapper.class, 10, 3, 5));
        spawnableCreatureList.add(new SpawnListEntry(androsa.gaiadimension.entity.GDMutantGrowthExtractor.class, 5, 2, 4));

        topBlock = GDBlocks.mutated_grass.getDefaultState();
        fillerBlock = GDBlocks.heavy_soil.getDefaultState();
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {

        super.decorate(world, rand, pos);

        for (int i = 0; i < 4; i++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(40);
            new WorldGenMinable(GDBlocks.opal_ore.getStateFromMeta(0), 8, input -> input == GDBlocks.gaia_stone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }

        for (int i = 0; i < 4; i++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(40);
            new WorldGenMinable(GDBlocks.opal_ore.getStateFromMeta(1), 8, input -> input == GDBlocks.gaia_stone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }

        for (int i = 0; i < 4; i++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(40);
            new WorldGenMinable(GDBlocks.opal_ore.getStateFromMeta(2), 8, input -> input == GDBlocks.gaia_stone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random par1Random) {

        if (par1Random.nextInt(8) == 0) {
            if (par1Random.nextInt(7) == 0) {
                return GaiaGenPurpleTrees;
            } else if (par1Random.nextInt(3) == 0) {
                return GaiaGenGreenTrees;
            } else if (par1Random.nextInt(3) == 0) {
                return GaiaGenBlueTrees;
            } else {
                return GaiaGenPinkTrees;
            }
        } else {
                return new GDGenNoTrees();
        }
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {

        if (rand.nextInt(32) == 0) {
            return new GDGenCrystalPlants(GDBlocks.mystical_murgni);
        } else if (rand.nextInt(16) == 0) {
            if (rand.nextInt(4) == 0) {
                return new GDGenCrystalPlants(GDBlocks.agathum);
            } else {
                return new GDGenCrystalPlants(GDBlocks.ouzium);
            }
        } else {
            return new GDGenCrystalPlants(GDBlocks.crystal_growth_mutant);
        }
    }

    @SideOnly(Side.CLIENT)
    public final short[] getSkyRGB() {
        return skyColorRGB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xE0EDCB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xE0EDCB;
    }
}
