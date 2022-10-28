package com.nyfaria.nyfstech.item.iface;

import net.minecraft.world.item.ItemStack;

public interface IEnergizedItem {
    static int getEnergy(ItemStack stack) {
        return stack.getMaxDamage() - stack.getDamageValue();
    }

    static void setEnergy(ItemStack stack, int energy) {
        stack.setDamageValue(stack.getMaxDamage() - energy);
    }

    static void addEnergy(ItemStack stack, int energy) {
        stack.setDamageValue(stack.getDamageValue() - energy);
    }

    static void removeEnergy(ItemStack stack,int energy){
        stack.setDamageValue(stack.getDamageValue() + energy);
    };

    static boolean canAddEnergy(ItemStack stack, int energy) {
        return stack.getDamageValue() - energy >= 0;
    }

    static boolean canRemoveEnergy(ItemStack stack,int energy){
        return stack.getDamageValue() - energy >= 0;
    }
}
