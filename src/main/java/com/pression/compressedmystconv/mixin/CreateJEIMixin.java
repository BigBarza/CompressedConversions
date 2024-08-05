package com.pression.compressedmystconv.mixin;

import com.pression.compressedmystconv.recipe.CompressionRecipeTypes;
import com.simibubi.create.compat.jei.ConversionRecipe;
import com.simibubi.create.compat.jei.category.MysteriousItemConversionCategory;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MysteriousItemConversionCategory.class)
public class CreateJEIMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectRecipes(CallbackInfo ci){
        Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(CompressionRecipeTypes.VOID_CONVERSION_RECIPE_TYPE.get()).forEach(recipe -> {
            MysteriousItemConversionCategory.RECIPES.add(ConversionRecipe.create(recipe.getInput(), recipe.getOutput()));
        });
    }
}
