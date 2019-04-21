package com.cornfieldmedia.epic.reference;

import net.minecraft.item.Item;

public class ReferenceItem extends Item {
    public ReferenceItem(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
