package com.nyfaria.nyfstech.init;

import com.nyfaria.nyfstech.NyfsTech;
import com.nyfaria.nyfstech.item.EnergyPickaxe;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsTech.MODID);

    public static final RegistryObject<Item> ENERGY_PICKAXE = ITEMS.register("energy_pickaxe", () -> new EnergyPickaxe(Tiers.NETHERITE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));


    public static Item.Properties getItemProperties() {
        return new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    }
}
