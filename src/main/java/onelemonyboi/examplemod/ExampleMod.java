/*
 * * Copyright 2019 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package onelemonyboi.examplemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import onelemonyboi.examplemod.gui.GUIOpener;
import onelemonyboi.examplemod.proxy.IProxy;
import onelemonyboi.examplemod.utils.GlobalVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * ExampleMod: The mod template used by all of my mods
 */
@Mod(
        modid = GlobalVariables.MOD_ID,
        name = GlobalVariables.NAME,
        version = GlobalVariables.VERSION,
        acceptedMinecraftVersions = GlobalVariables.ACCEPTED_VERSIONS
)
public class ExampleMod {
    public static final ExampleMod INSTANCE = new ExampleMod();
    public static File modConfigFolder = new File(Loader.instance().getConfigDir(), "ExampleMod");
    public static final Logger log = LogManager.getLogger("ExampleMod");



    @SidedProxy(clientSide = GlobalVariables.CLIENT_PROXY)
    private static IProxy PROXY;

    @EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {
        PROXY.preInit(event);
        Config.init();
    }

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        PROXY.init(event);

        MinecraftForge.EVENT_BUS.register(new Config());
        MinecraftForge.EVENT_BUS.register(new GUIOpener());
    }

    @EventHandler
    public void onFMLPostInitialization(FMLPostInitializationEvent event) {
        PROXY.postInit(event);
    }
}
