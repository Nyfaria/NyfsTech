package com.nyfaria.nyfstech.menutypes.slot;

import com.nyfaria.nyfstech.menutypes.GeneratorMenu;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;

public class GeneratorSlot extends Slot {
    private final GeneratorMenu parent;
    public GeneratorSlot(GeneratorMenu parent,Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
        this.parent = parent;
    }

}
