package com.nyfaria.nyfstech.init;

import com.nyfaria.nyfstech.NyfsTech;
import com.nyfaria.nyfstech.menutypes.GeneratorMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NyfsTech.MODID);

    public static final RegistryObject<MenuType<GeneratorMenu>> GENERATOR = MENU_TYPES.register("generator", ()-> IForgeMenuType.create(GeneratorMenu::new));
}
