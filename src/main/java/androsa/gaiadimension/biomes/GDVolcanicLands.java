package androsa.gaiadimension.biomes;

import androsa.gaiadimension.block.GDCrystalGrowth;
import androsa.gaiadimension.registry.GDBlocks;
import androsa.gaiadimension.world.gen.GDGenBurntAgateTree;
import androsa.gaiadimension.world.gen.GDGenCrystalGrowth;
import androsa.gaiadimension.world.gen.GDGenFieryAgateTree;
import androsa.gaiadimension.world.gen.GDGenNoTrees;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class GDVolcanicLands extends GDBiomeBase {

    private WorldGenTrees GaiaGenBurntTrees = new GDGenBurntAgateTree(false);
    private WorldGenTrees GaiaGenFireTrees = new GDGenFieryAgateTree(false);
    private short[] skyColorRGB = new short[] { 75, 30, 25 };

    public GDVolcanicLands(Biome.BiomeProperties props) {
        super(props);

        topBlock = GDBlocks.singedGrass.getDefaultState();
        fillerBlock = GDBlocks.heavySoil.getDefaultState();

        getGDBiomeDecorator().lavaPoolChance = 0.25F;
        getGDBiomeDecorator().grassPerChunk = 1;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random par1Random) {
        if (par1Random.nextInt(16) == 0) {
            if (par1Random.nextInt(5) == 0) {
                return GaiaGenFireTrees;
            } else {
                return GaiaGenBurntTrees;
            }
        } else {
            return new GDGenNoTrees();
        }
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return new GDGenCrystalGrowth(GDCrystalGrowth.CrystalGrowthVariant.SEARED);
    }

    @SideOnly(Side.CLIENT)
    public final short[] getSkyRGB() {
        return skyColorRGB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x131023;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x131023;
    }
}
