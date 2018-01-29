package androsa.gaiadimension.biomes;

import androsa.gaiadimension.GaiaDimension;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@SuppressWarnings("all")
@ObjectHolder(GaiaDimension.MODID)
public class GDBiomes {
    @ObjectHolder("pink_agate_forest")
    public static final Biome pinkAgateForest;
    @ObjectHolder("blue_agate_forest")
    public static final Biome blueAgateForest;
    @ObjectHolder("green_agate_forest")
    public static final Biome greenAgateForest;
    @ObjectHolder("purple_agate_forest")
    public static final Biome purpleAgateForest;
    @ObjectHolder("fossil_forest")
    public static final Biome fossilForest;
    @ObjectHolder("volcaniclands")
    public static final Biome volcaniclands;
    @ObjectHolder("crystal_plains")
    public static final Biome crystalPlains;
    @ObjectHolder("mineral_river")
    public static final Biome mineralRiver;

    //Shut it, IntelliJ!
    static {
        pinkAgateForest = null;
        blueAgateForest = null;
        greenAgateForest = null;
        purpleAgateForest = null;
        fossilForest = null;
        volcaniclands = null;
        crystalPlains = null;
        mineralRiver = null;
    }
}