package com.cornfieldmedia.epic.reference;

import net.minecraft.item.Item;

public class ReferenceItem extends Item {
    public static final String NAME = "reference_item";
    public ReferenceItem() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
    }
}
