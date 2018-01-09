package androsa.gaiadimension.registry;

import androsa.gaiadimension.GaiaDimension;
import androsa.gaiadimension.block.*;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public final class GDBlocksRegister {
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BlockRegistryHelper blocks = new BlockRegistryHelper(event.getRegistry());

        blocks.register("heavy_soil", (new GDHeavySoil()).setUnlocalizedName("heavy_soil"));
        blocks.register("glitter_grass", (new GDGlitterGrass()).setUnlocalizedName("glitter_grass"));
        blocks.register("gaia_leaves", (new GDGaiaLeaves()).setUnlocalizedName("gaia_leaves"));
        blocks.register("special_gaia_leaves", (new GDSpecialLeaves()).setUnlocalizedName("special_gaia_leaves"));
        blocks.register("gaia_log", (new GDGaiaLog()).setUnlocalizedName("gaia_log"));
        blocks.register("special_gaia_log", (new GDSpecialLog()).setUnlocalizedName("special_gaia_log"));
        blocks.register("gaia_stone", (new GDGaiaStone()).setUnlocalizedName("gaia_stone"));
        blocks.register("gaia_stone_bricks", (new GDGaiaStoneBricks()).setUnlocalizedName("gaia_stone_bricks"));

        blocks.register("hematite_block", (new GDHematiteBlock()).setUnlocalizedName("hematite_block"));
        blocks.register("labradorite_block", (new GDLabradoriteBlock()).setUnlocalizedName("laboradorite_block"));
        blocks.register("opal_block", (new GDOpalBlock()).setUnlocalizedName("opal_block"));
        blocks.register("pyrite_block", (new GDPyriteBlock()).setUnlocalizedName("pyrite_block"));
        blocks.register("moonstone_block", (new GDMoonstoneBlock()).setUnlocalizedName("moonstone_block"));

        blocks.register("hematite_ore", (new GDHematiteOre()).setUnlocalizedName("hematite_ore"));
        blocks.register("pyrite_ore", (new GDPyriteOre()).setUnlocalizedName("pyrite_ore"));
        blocks.register("opal_ore", (new GDOpalOre()).setUnlocalizedName("opal_ore"));
        blocks.register("labradorite_ore", (new GDLabradoriteOre()).setUnlocalizedName("labradorite_ore"));
        blocks.register("moonstone_ore", (new GDMoonstoneOre()).setUnlocalizedName("moonstone_ore"));
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