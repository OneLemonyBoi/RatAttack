package onelemonyboi.examplemod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import onelemonyboi.examplemod.utils.GlobalVariables;

import java.io.File;

public class Config {
    public static Configuration config = new Configuration(new File(ExampleMod.modConfigFolder, "examplemod.cfg"));

    public static void init() {
        config.load();
        updateConfigValues();
        if (config.hasChanged()) {
            config.save();
        }
    }

    public static void updateConfigValues() {

    }

    @SubscribeEvent
    public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent evt) {
        if (GlobalVariables.MOD_ID.equals(evt.modID)) {
            refreshConfig();
        }
    }

    public static void refreshConfig() {
        Config.config.save();
        updateConfigValues();
    }
}
