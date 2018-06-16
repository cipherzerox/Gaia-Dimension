package androsa.gaiadimension.registry;

import androsa.gaiadimension.GaiaDimension;
import androsa.gaiadimension.block.*;
import androsa.gaiadimension.block.blocksgrass.*;
import androsa.gaiadimension.block.blocksore.*;
import androsa.gaiadimension.block.tileentity.TileEntityGaiaStoneFurnace;
import androsa.gaiadimension.block.tileentity.TileEntityGlitterFurnace;
import androsa.gaiadimension.block.tileentity.TileEntityPurifier;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public final class GDBlocksRegister {
    @SubscribeEvent
    @SuppressWarnings("deprecated")
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BlockRegistryHelper blocks = new BlockRegistryHelper(event.getRegistry());

        //Utility Blocks
        blocks.register("gaia_portal", (new GDGaiaPortal()).setUnlocalizedName("gaia_portal"));
        blocks.register("gold_fire", (new GDGoldFire()).setUnlocalizedName("gold_fire"));
        blocks.register("pyrite_torch", (new GDPyriteTorch()).setUnlocalizedName("pyrite_torch"));
        blocks.register("agate_crafting_table", (new GDAgateCraftingTable()).setUnlocalizedName("agate_crafting_table"));
        blocks.register("gaia_stone_furnace_idle", (new GDGaiaStoneFurnace(false)).setUnlocalizedName("gaia_stone_furnace_off"));
        blocks.register("gaia_stone_furnace_lit", (new GDGaiaStoneFurnace(true)).setUnlocalizedName("gaia_stone_furnace_on"));
        blocks.register("glitter_furnace_idle", (new GDGlitterFurnace(false)).setUnlocalizedName("glittering_furnace_off"));
        blocks.register("glitter_furnace_lit", (new GDGlitterFurnace(true)).setUnlocalizedName("glittering_furnace_on"));
        blocks.register("purifier_idle", (new GDPurifier(false)).setUnlocalizedName("purifier_off"));
        blocks.register("purifier_lit", (new GDPurifier(true)).setUnlocalizedName("purifier_on"));

        //Natural Blocks
        blocks.register("heavy_soil", (new GDHeavySoil()).setUnlocalizedName("heavy_soil"));
        blocks.register("corrupt_soil", (new GDCorruptSoil()).setUnlocalizedName("corrupt_soil"));
        blocks.register("glitter_grass", (new GDGrassGlitter()).setUnlocalizedName("glitter_grass"));
        blocks.register("cool_grass", (new GDGrassCool()).setUnlocalizedName("cool_grass"));
        blocks.register("verdant_grass", (new GDGrassVerdant()).setUnlocalizedName("verdant_grass"));
        blocks.register("scented_grass", (new GDGrassScented()).setUnlocalizedName("scented_grass"));
        blocks.register("old_grass", (new GDGrassOld()).setUnlocalizedName("old_grass"));
        blocks.register("corrupt_grass", (new GDCorruptGrass()).setUnlocalizedName("corrupt_grass"));
        blocks.register("singed_grass", (new GDGrassSinged()).setUnlocalizedName("singed_grass"));
        blocks.register("mutated_grass", (new GDGrassMutated()).setUnlocalizedName("mutated_grass"));
        blocks.register("frail_glitter_block", (new GDFrailGlitterBlock()).setUnlocalizedName("frail_glitter_block"));
        blocks.register("thick_glitter_block", (new GDThickGlitterBlock()).setUnlocalizedName("thick_glitter_block"));
        blocks.register("gummy_glitter_block", (new GDGummyGlitterBlock()).setUnlocalizedName("gummy_glitter_block"));
        blocks.register("crystal_growth", (new GDCrystalGrowth()).setUnlocalizedName("crystal_growth"));
        blocks.register("crystal_bloom", (new GDCrystalBloom()).setUnlocalizedName("crystal_bloom"));
        blocks.register("gaia_sapling", (new GDAgateSapling()).setUnlocalizedName("gaia_sapling"));
        blocks.register("gaia_leaves", (new GDAgateLeaves()).setUnlocalizedName("gaia_leaves"));
        blocks.register("special_gaia_leaves", (new GDSpecialLeaves()).setUnlocalizedName("special_gaia_leaves"));
        blocks.register("gaia_log", (new GDAgateLog()).setUnlocalizedName("gaia_log"));
        blocks.register("special_gaia_log", (new GDSpecialLog()).setUnlocalizedName("special_gaia_log"));
        blocks.register("salt", (new GDSaltBlock()).setUnlocalizedName("salt"));
        blocks.register("saltstone", (new GDSaltRock()).setUnlocalizedName("saltstone"));
        blocks.register("gaia_stone", (new GDGaiaStone()).setUnlocalizedName("gaia_stone"));
        blocks.register("gaia_cobblestone", (new GDGaiaStone()).setUnlocalizedName("gaia_cobblestone"));
        blocks.register("wasteland_stone", (new GDWastelandStone()).setUnlocalizedName("wasteland_stone"));
        blocks.register("static_stone", (new GDStaticStone()).setUnlocalizedName("static_stone"));
        blocks.register("volcanic_rock", (new GDVolcanicRock()).setUnlocalizedName("volcanic_rock"));
        blocks.register("searing_rock", (new GDSearingRock()).setUnlocalizedName("searing_rock"));

        //Planks
        blocks.register("pink_agate_planks", (new GDAgatePlanks()).setUnlocalizedName("pink_agate_planks"));
        blocks.register("blue_agate_planks", (new GDAgatePlanks()).setUnlocalizedName("blue_agate_planks"));
        blocks.register("green_agate_planks", (new GDAgatePlanks()).setUnlocalizedName("green_agate_planks"));
        blocks.register("purple_agate_planks", (new GDAgatePlanks()).setUnlocalizedName("purple_agate_planks"));
        blocks.register("fossilized_planks", (new GDAgatePlanks()).setUnlocalizedName("fossilized_planks"));
        blocks.register("corrupted_planks", (new GDAgatePlanks()).setUnlocalizedName("corrupted_planks"));
        blocks.register("crusty_planks", (new GDAgatePlanks()).setUnlocalizedName("crusty_planks"));
        blocks.register("heated_planks", (new GDAgatePlanks()).setLightLevel(5).setUnlocalizedName("heated_planks"));
        blocks.register("pink_agate_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("pink_agate_plank_slab"));
        blocks.register("blue_agate_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("blue_agate_plank_slab"));
        blocks.register("green_agate_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("green_agate_plank_slab"));
        blocks.register("purple_agate_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("purple_agate_plank_slab"));
        blocks.register("fossilized_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("fossilized_plank_slab"));
        blocks.register("corrupted_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("corrupted_plank_slab"));
        blocks.register("crusty_plank_slab", (new GDAgatePlankSlab(false)).setUnlocalizedName("crusty_plank_slab"));
        blocks.register("heated_plank_slab", (new GDAgatePlankSlab(false)).setLightLevel(5).setUnlocalizedName("heated_plank_slab"));
        blocks.register("double_pink_agate_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_pink_agate_plank_slab"));
        blocks.register("double_blue_agate_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_blue_agate_plank_slab"));
        blocks.register("double_green_agate_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_green_agate_plank_slab"));
        blocks.register("double_purple_agate_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_purple_agate_plank_slab"));
        blocks.register("double_fossilized_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_fossilized_plank_slab"));
        blocks.register("double_corrupted_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_corrupted_plank_slab"));
        blocks.register("double_crusty_plank_slab", (new GDAgatePlankSlab(true)).setUnlocalizedName("double_crusty_plank_slab"));
        blocks.register("double_heated_plank_slab", (new GDAgatePlankSlab(true)).setLightLevel(5).setUnlocalizedName("double_heated_plank_slab"));
        Block agatePlanks = new GDAgatePlanks();
        blocks.register("pink_agate_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("pink_agate_plank_stairs"));
        blocks.register("blue_agate_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("blue_agate_plank_stairs"));
        blocks.register("green_agate_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("green_agate_plank_stairs"));
        blocks.register("purple_agate_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("purple_agate_plank_stairs"));
        blocks.register("fossilized_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("fossilized_plank_stairs"));
        blocks.register("corrupted_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("corrupted_plank_stairs"));
        blocks.register("crusty_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("crusty_plank_stairs"));
        blocks.register("heated_plank_stairs", (new GDAgatePlankStairs(agatePlanks.getDefaultState())).setUnlocalizedName("heated_plank_stairs"));

        //Manufactured Blocks
        blocks.register("gaia_stone_bricks", (new GDGaiaStoneBricks()).setUnlocalizedName("gaia_stone_bricks"));
        blocks.register("cracked_gaia_stone_bricks", (new GDGaiaStoneBricks()).setUnlocalizedName("cracked_gaia_stone_bricks"));
        blocks.register("crusted_gaia_stone_bricks", (new GDGaiaStoneBricks()).setUnlocalizedName("crusted_gaia_stone_bricks"));
        blocks.register("reinforced_bricks", (new GDReinforcedBricks()).setUnlocalizedName("reinforced_bricks"));
        blocks.register("malachite_bricks", (new GDMalachiteBricks()).setUnlocalizedName("malachite_bricks"));
        blocks.register("malachite_pulsing_bricks", (new GDMalachitePulseBricks()).setUnlocalizedName("malachite_pulse_bricks"));
        blocks.register("malachite_pulsing_tiles", (new GDMalachitePulseBricks()).setUnlocalizedName("malachite_pulse_tiles"));
        blocks.register("malachite_pulsing_chisel", (new GDMalachitePulseBricks()).setUnlocalizedName("malachite_pulse_chisel"));
        blocks.register("malachite_brick_slab", (new GDMalachiteBrickSlab(false)).setUnlocalizedName("malachite_brick_slab"));
        blocks.register("double_malachite_brick_slab", (new GDMalachiteBrickSlab(true)).setUnlocalizedName("double_malachite_brick_slab"));
        blocks.register("malachite_floor_slab", (new GDMalachiteBrickSlab(false)).setUnlocalizedName("malachite_floor_slab"));
        blocks.register("double_malachite_floor_slab", (new GDMalachiteBrickSlab(true)).setUnlocalizedName("double_malachite_floor_slab"));
        blocks.register("malachite_pillar", new GDMalachiteBrickPillar().setUnlocalizedName("malachite_pillar"));
        Block malachiteBricks = new GDMalachiteBricks();
        blocks.register("malachite_brick_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_brick_stairs"));
        blocks.register("malachite_chisel_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_chisel_brick_stairs"));
        blocks.register("malachite_pulsing_brick_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_pulsing_brick_stairs"));
        blocks.register("malachite_pulsing_chisel_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_pulsing_chisel_stairs"));
        Block malachitePillar = new GDMalachiteBrickPillar();
        blocks.register("malachite_pillar_stairs", (new GDMalachiteStairs(malachitePillar.getDefaultState())).setUnlocalizedName("malachite_pillar_stairs"));
        blocks.register("malachite_floor_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_floor_stairs"));
        blocks.register("malachite_pulsing_floor_stairs", (new GDMalachiteStairs(malachiteBricks.getDefaultState())).setUnlocalizedName("malachite_pulsing_floor_stairs"));
        blocks.register("bolstered_bricks", (new GDBolsteredBricks()).setUnlocalizedName("bolstered_bricks"));

        //Storage Blocks
        blocks.register("sugilite_block", (new GDBlockStorage()).setUnlocalizedName("sugilite_block"));
        blocks.register("hematite_block", (new GDBlockStorage()).setUnlocalizedName("hematite_block"));
        blocks.register("labradorite_block", (new GDBlockStorage()).setUnlocalizedName("laboradorite_block"));
        blocks.register("opal_block_red", (new GDBlockStorage()).setUnlocalizedName("opal_block_red"));
        blocks.register("opal_block_blue", (new GDBlockStorage()).setUnlocalizedName("opal_block_blue"));
        blocks.register("opal_block_green", (new GDBlockStorage()).setUnlocalizedName("opal_block_green"));
        blocks.register("opal_block_white", (new GDBlockStorage()).setUnlocalizedName("opal_block_white"));
        blocks.register("pyrite_block", (new GDBlockStorage()).setUnlocalizedName("pyrite_block").setLightLevel(1.0F));
        blocks.register("moonstone_block", (new GDBlockStorage()).setUnlocalizedName("moonstone_block"));
        blocks.register("cinnabar_block", (new GDBlockStorage()).setUnlocalizedName("cinnabar_block"));
        blocks.register("tektite_block", (new GDBlockStorage()).setUnlocalizedName("tektite_block"));
        blocks.register("goldstone_block", (new GDBlockStorage()).setUnlocalizedName("goldstone_block"));
        blocks.register("ixiolite_block", (new GDBlockStorage()).setUnlocalizedName("ixiolite_block"));
        blocks.register("proustite_block", (new GDBlockStorage()).setUnlocalizedName("proustite_block"));
        blocks.register("euclase_block", (new GDBlockStorage()).setUnlocalizedName("euclase_block"));
        blocks.register("leucite_block", (new GDBlockStorage()).setUnlocalizedName("leucite_block"));
        blocks.register("carnelian_block", (new GDBlockStorage()).setUnlocalizedName("carnelian_block"));
        blocks.register("benitoite_block", (new GDBlockStorage()).setUnlocalizedName("benitoite_block"));
        blocks.register("diopside_block", (new GDBlockStorage()).setUnlocalizedName("diopside_block"));
        blocks.register("chalcedony_block", (new GDBlockStorage()).setUnlocalizedName("chalcedony_block"));

        //Ores
        blocks.register("sugilite_ore", (new GDOreSugilite()).setUnlocalizedName("sugilite_ore"));
        blocks.register("hematite_ore", (new GDOreHematite()).setUnlocalizedName("hematite_ore"));
        blocks.register("pyrite_ore", (new GDOrePyrite()).setUnlocalizedName("pyrite_ore"));
        blocks.register("opal_ore", (new GDOreOpal()).setUnlocalizedName("opal_ore"));
        blocks.register("labradorite_ore", (new GDOreLabradorite()).setUnlocalizedName("labradorite_ore"));
        blocks.register("moonstone_ore", (new GDOreMoonstone()).setUnlocalizedName("moonstone_ore"));
        blocks.register("cinnabar_ore", (new GDOreCinnabar()).setUnlocalizedName("cinnabar_ore"));

        GameRegistry.registerTileEntity(TileEntityGaiaStoneFurnace.class, "gaiadimension:tileEntityGaiaStoneFurnace");
        GameRegistry.registerTileEntity(TileEntityGlitterFurnace.class, "gaiadimension:tileEntityGlitterFurnace");
        GameRegistry.registerTileEntity(TileEntityPurifier.class, "gaiadimension:tileEntityPurifier");
    }

    private static class BlockRegistryHelper {
        private final IForgeRegistry<Block> registry;

        BlockRegistryHelper(IForgeRegistry<Block> registry) {
            this.registry = registry;
        }

        private void register(String registryName, Block block) {
            block.setRegistryName(GaiaDimension.MODID, registryName);
            registry.register(block);
        }
    }
}
