package com.nyfaria.nyfstech.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.nyfstech.NyfsTech;
import com.nyfaria.nyfstech.menutypes.GeneratorMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class GeneratorScreen extends AbstractContainerScreen<GeneratorMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(NyfsTech.MODID, "textures/gui/generator.png");
    private static final ResourceLocation ENERGY = new ResourceLocation(NyfsTech.MODID, "textures/gui/energy_bar.png");
    private boolean widthTooNarrow;
    private final ResourceLocation texture;

    public GeneratorScreen(GeneratorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.texture = TEXTURE;
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pX, int pY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(pPoseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            this.blit(pPoseStack, i + 80, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getBurnProgress();
        this.blit(pPoseStack, i + 79, j + 34, 176, 14, l + 1, 16);
        RenderSystem.setShaderTexture(0, ENERGY);
        int energy = this.menu.getEnergy();
        int max = this.menu.getMaxEnergy();
        float percent = (float) energy / (float) max;
        int height =  Mth.ceil(percent * 52);
        int y = 52 - height;
        this.blit(pPoseStack, i + 8, j + 17 + y, 16, 0, 16, height, 32, 52);
        this.blit(pPoseStack, i + 8, j + 17, 0, 0, 16, 52, 32, 52);

    }


    /**
     * Called when the mouse is clicked over a slot or outside the gui.
     */
    protected void slotClicked(Slot pSlot, int pSlotId, int pMouseButton, ClickType pType) {
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
    }

    @Override
    protected void renderTooltip(PoseStack pPoseStack, int pX, int pY) {
        if(160 < pX && pX < 175 && 61 < pY && pY < 112){
            renderTooltip(pPoseStack, List.of(Component.literal("FE: " + this.menu.getEnergy() + "/" + this.menu.getMaxEnergy())), Optional.empty(),pX,pY);
        }
        super.renderTooltip(pPoseStack, pX, pY);
    }

    protected boolean hasClickedOutside(double pMouseX, double pMouseY, int pGuiLeft, int pGuiTop, int pMouseButton) {
        boolean flag = pMouseX < (double) pGuiLeft || pMouseY < (double) pGuiTop || pMouseX >= (double) (pGuiLeft + this.imageWidth) || pMouseY >= (double) (pGuiTop + this.imageHeight);
        return flag;
    }
}