package com.cornfieldmedia.epic.reference;

import com.cornfieldmedia.epic.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= Constants.MODID)
public class ReferenceLoader {
    private static final String NAME = "reference_item";
    private static Item referenceItem;

    public static void init() {
        referenceItem = new ReferenceItem(NAME).setCreativeTab(CreativeTabs.MISC).setMaxStackSize(4);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(referenceItem);
    }

    private static void registerRender(Item item) {
        if (item != null) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), Constants.INVENTORY));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(referenceItem);
    }
}
