package com.cornfieldmedia.epic.reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class ReferenceBlock extends Block {
    private Item toDrop;
    private int minDropAmount = 1;
    private int maxDropAmount = 0;

    public static final String NAME = "reference_block";

    public ReferenceBlock(Material material) {
        this(material, null, 1, 1);
    }

    public ReferenceBlock(Material material, Item toDrop) {
        this(material, toDrop, 1, 1);
    }

    public ReferenceBlock(Material material, Item toDrop, int dropAmount) {
        this(material, toDrop, dropAmount, dropAmount);
    }

    public ReferenceBlock(Material material, Item toDrop, int minDropAmount, int maxDropAmount) {
        super(material);
        this.toDrop = toDrop;
        this.minDropAmount = minDropAmount;
        this.maxDropAmount = maxDropAmount;

        setUnlocalizedName(NAME);
        setRegistryName(NAME);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return toDrop==null?Item.getItemFromBlock(this):toDrop;
    }

    @Override
    public int quantityDropped(Random random) {
        if(this.minDropAmount>this.maxDropAmount) {
            int i = this.minDropAmount;
            this.minDropAmount=this.maxDropAmount;
            this.maxDropAmount=i;
        }
        return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0)
            {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
