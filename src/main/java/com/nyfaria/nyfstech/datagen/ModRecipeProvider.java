package com.nyfaria.nyfstech.datagen;

import com.nyfaria.nyfstech.init.BlockInit;
import com.nyfaria.nyfstech.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {
        ShapelessRecipeBuilder.shapeless(ItemInit.ENERGY_PICKAXE.get())
                .requires(Items.IRON_PICKAXE)
                .requires(Items.REDSTONE)
                .unlockedBy("has_item", has(Items.IRON_PICKAXE))
                .save(recipeSaver);
        ShapedRecipeBuilder.shaped(BlockInit.GENERATOR.get())
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_BLOCK)
                .define('F', Items.FURNACE)
                .pattern("RIR")
                .pattern("IFI")
                .pattern("RIR")
                .unlockedBy("has_item", has(Items.FURNACE))
                .save(recipeSaver);
    }

}
