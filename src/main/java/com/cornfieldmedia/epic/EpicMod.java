package com.cornfieldmedia.epic;

import com.cornfieldmedia.epic.reference.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION, acceptedMinecraftVersions = Constants.ACCEPTED_MINECRAFT_VERSIONS)
public class EpicMod
{
    private static Logger logger;

    @Instance
    public static EpicMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
//        logger.debug(Constants.MODID + ":preInit");
        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
//        logger.debug(Constants.MODID + ":init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
//        logger.debug(Constants.MODID + ":postInit");
    }
}
