package com.nyfaria.nyfstech.event;

import com.nyfaria.nyfstech.NyfsTech;
import com.nyfaria.nyfstech.client.screen.GeneratorScreen;
import com.nyfaria.nyfstech.init.MenuTypeInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ContainerScreenEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = NyfsTech.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        MenuScreens.register(MenuTypeInit.GENERATOR.get(), GeneratorScreen::new);
    }
}
