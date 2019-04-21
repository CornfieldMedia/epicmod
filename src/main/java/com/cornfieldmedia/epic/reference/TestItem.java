package com.cornfieldmedia.epic.reference;

import net.minecraft.item.Item;

public class TestItem extends Item {
    public TestItem(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
