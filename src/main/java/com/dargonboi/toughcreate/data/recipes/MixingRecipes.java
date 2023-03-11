package com.dargonboi.toughcreate.data.recipes;

import com.dargonboi.toughcreate.ToughCreate;
import com.dargonboi.toughcreate.core.item.ToughCreateItems;
import com.dargonboi.toughcreate.data.providers.ModProcessingRecipes;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;


public class MixingRecipes extends ModProcessingRecipes {

    public CreateRecipeProvider.GeneratedRecipe TUFF_ALLOY_IRON = create("tuff_alloy_iron", b -> b
            .require(ToughCreateItems.TUFF_CRUSHED.get())
            .require(ToughCreateItems.TUFF_CRUSHED.get())
            .require(Items.IRON_NUGGET)
            .require(Items.IRON_NUGGET)
            .output(ToughCreateItems.TUFF_COMPOUND.get())
    );

    public CreateRecipeProvider.GeneratedRecipe TUFF_ALLOY_ZINC = create("tuff_alloy_zinc", b -> b
            .require(ToughCreateItems.TUFF_CRUSHED.get())
            .require(ToughCreateItems.TUFF_CRUSHED.get())
            .require(AllItems.ZINC_NUGGET.get())
            .require(AllItems.ZINC_NUGGET.get())
            .output(ToughCreateItems.TUFF_COMPOUND.get())
            .duration(200)
    );

    public MixingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

    @Override
    public @NotNull String getName() {
        return "Tough Create Mixing Recipes";
    }
}
