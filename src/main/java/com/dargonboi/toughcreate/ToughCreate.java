package com.dargonboi.toughcreate;

import com.dargonboi.toughcreate.core.item.ToughCreateItems;
import com.dargonboi.toughcreate.data.recipe.gen.ModProcessingRecipes;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.advancement.AllAdvancements;
import com.simibubi.create.foundation.data.AllLangPartials;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.LangMerger;
import com.simibubi.create.foundation.data.TagGen;
import com.simibubi.create.foundation.data.recipe.MechanicalCraftingRecipeGen;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.foundation.data.recipe.StandardRecipeGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ToughCreate.MODID)
public class ToughCreate {
    public static final String MODID = "toughcreate";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ToughCreate INSTANCE;

    public ToughCreate() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(bus);

        ToughCreateItems.register(bus);
        bus.addListener(EventPriority.LOWEST, ToughCreate::gatherData);
        bus.addListener(this::setup);
    }

    public static void gatherData(GatherDataEvent event) {
        TagGen.datagen();
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            gen.addProvider(true, new LangMerger(gen, MODID, "Tough Create", AllLangPartials.values()));
//            gen.addProvider(true, AllSoundEvents.provider(gen));
        }
        if (event.includeServer()) {
//            gen.addProvider(true, new AllAdvancements(gen));
//            gen.addProvider(true, new StandardRecipeGen(gen));
//            gen.addProvider(true, new MechanicalCraftingRecipeGen(gen));
//            gen.addProvider(true, new SequencedAssemblyRecipeGen(gen));
            ModProcessingRecipes.registerAll(gen);
//			AllOreFeatureConfigEntries.gatherData(event);
        }
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Tough Create Setup");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        LOGGER.info("Tough Create Client Setup");
    }
}
