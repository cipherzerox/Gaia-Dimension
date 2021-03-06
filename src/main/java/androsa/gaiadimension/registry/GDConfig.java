package androsa.gaiadimension.registry;

import androsa.gaiadimension.GaiaDimension;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = GaiaDimension.MODID)
@Mod.EventBusSubscriber(modid = GaiaDimension.MODID)
public class GDConfig {
    private final static String config = GaiaDimension.MODID + ".config.";

    @Config.LangKey(config + "dimension")
    @Config.Comment("A restart is required if changes are made here.")
    public static Dimension dimension = new Dimension();

    public static class Dimension {
        @Config.LangKey(config + "dimension_id")
        @Config.RequiresMcRestart
        @Config.Comment("The ID of the Gaia dimension. This setting should only be changed if mod conflicts are present.")
        public int dimensionID = -30;

        @Config.LangKey(config + "dimension_seed")
        @Config.RequiresMcRestart
        @Config.Comment("Overrides the seed of the dimension. Changing this setting will always generate the Gaia dimension to the specified seed.")
        public String gaiaSeed = "";

    }

    @Config.LangKey(config + "sky_and_fog")
    @Config.Comment("Changes that will affect the sky, fog and clouds in Gaia. A restart is advised here.")
    public static SkyAndFog skyAndFog = new SkyAndFog();

    public static class SkyAndFog {
        @Config.LangKey(config + "enable_sky_fog")
        @Config.RequiresMcRestart
        @Config.Comment("For those bothered by the sky transtions or using shaders. Disables the differing sky and fog colour to the default preset.")
        public boolean enableSkyFog = true;
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GaiaDimension.MODID));
        ConfigManager.sync(GaiaDimension.MODID, Config.Type.INSTANCE);
    }
}
