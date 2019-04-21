package com.cornfieldmedia.epic.reference;

import com.cornfieldmedia.epic.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid= Constants.MODID)
public class ReferenceLoader {
    private static Item referenceItem;
    private static Block referenceBlock;

    public static void init() {
        referenceItem = new ReferenceItem(ReferenceItem.NAME).setCreativeTab(CreativeTabs.MISC).setMaxStackSize(4);
        referenceBlock = new ReferenceBlock(ReferenceBlock.NAME, Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(1.0f);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(referenceItem);
        registerRender(Item.getItemFromBlock(referenceBlock));
    }

    private static void registerRender(Item item) {
        if (item != null) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), Constants.INVENTORY));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(referenceItem);
        if (referenceBlock != null) {
            registry.registerAll(new ItemBlock(referenceBlock).setRegistryName(referenceBlock.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(referenceBlock);
    }

}
