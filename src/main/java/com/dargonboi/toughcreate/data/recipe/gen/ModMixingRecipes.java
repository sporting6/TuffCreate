package com.dargonboi.toughcreate.data.recipe.gen;

import com.dargonboi.toughcreate.ToughCreate;
import com.dargonboi.toughcreate.core.item.ToughCreateItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;

public class ModMixingRecipes extends ProcessingRecipeGen {

    CreateRecipeProvider.GeneratedRecipe TUFF_ALLOY = create(ToughCreate.asResource("tuff_alloy"), b -> b.require(Blocks.ANDESITE)
            .require(ToughCreateItems.TUFF_CRUSHED.get())
            .require(AllItems.ZINC_NUGGET.get())
            .output(ToughCreateItems.TUFF_COMPOUND.get(), 1));

    public ModMixingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
