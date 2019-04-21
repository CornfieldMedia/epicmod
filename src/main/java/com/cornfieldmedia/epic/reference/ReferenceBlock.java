package com.cornfieldmedia.epic.reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ReferenceBlock extends Block {
    public static final String NAME = "reference_block";
    public ReferenceBlock(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
