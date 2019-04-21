package com.cornfieldmedia.epic.leafdecay;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

public class LeafDecayConfig {
    public static Configuration config;

    public static final String category = "leafdecay";
    public static final int defaultDecayTime = 2;
    public static int decayTime;

    public static void init(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());

        config.setCategoryComment(category, "Default is " + defaultDecayTime + " ticks to drop all the leaves.");
        Property decayTimeProperty = config.get(category, "DecayTime", defaultDecayTime, "Ticks for full leaf decay.");
        decayTime = decayTimeProperty.getInt();

        if (config.hasChanged()){
            config.save();
        }
    }
}
