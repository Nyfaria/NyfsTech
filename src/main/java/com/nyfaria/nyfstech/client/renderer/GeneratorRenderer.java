package com.nyfaria.nyfstech.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.nyfstech.block.entity.GeneratorBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class GeneratorRenderer implements BlockEntityRenderer<GeneratorBlockEntity> {
    public GeneratorRenderer(BlockEntityRendererProvider.Context pContext) {
    }
    @Override
    public void render(GeneratorBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

    }
}
