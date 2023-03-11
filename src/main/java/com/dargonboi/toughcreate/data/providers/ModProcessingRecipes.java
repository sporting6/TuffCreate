package com.dargonboi.toughcreate.data.providers;

import com.dargonboi.toughcreate.ToughCreate;
import com.dargonboi.toughcreate.data.recipes.MixingRecipes;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class ModProcessingRecipes extends CreateRecipeProvider{
    protected static final List<ModProcessingRecipes> PROVIDERS = new ArrayList<>();

    public ModProcessingRecipes(DataGenerator generator) {
        super(generator);
    }

    public static void registerAllProcessingProviders(DataGenerator generator) {
        PROVIDERS.add(new MixingRecipes(generator));

        generator.addProvider(true, new DataProvider() {
            @Override
            public void run(@NotNull CachedOutput pCache) {
                PROVIDERS.forEach(generator -> {
                    try {
                        generator.run(pCache);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public @NotNull String getName() {
                return "Create: ToughCreate's Processing Recipes";
            }
        });
    }


    /* Functions from Create's ProcessingRecipeGen.java */

    protected <T extends ProcessingRecipe<?>> CreateRecipeProvider.GeneratedRecipe create(String name,
                                                                                          UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(ToughCreate.asResource(name), transform);
    }

    protected <T extends ProcessingRecipe<?>> CreateRecipeProvider.GeneratedRecipe create(ResourceLocation name,
                                                                                          UnaryOperator<ProcessingRecipeBuilder<T>> transform) {

        return createWithDeferredId(() -> name, transform);
    }

    protected <T extends ProcessingRecipe<?>> CreateRecipeProvider.GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                                                        UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        CreateRecipeProvider.GeneratedRecipe generatedRecipe =
                c -> transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }

    protected abstract IRecipeTypeInfo getRecipeType();
}
