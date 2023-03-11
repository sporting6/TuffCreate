package com.dargonboi.toughcreate.core.item;

import com.dargonboi.toughcreate.ToughCreate;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;

public class ToughCreateItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ToughCreate.MODID);
    public static final RegistryObject<Item> TUFF_CRUSHED = ITEMS.register("tuff_crushed", () -> new Item(new Item.Properties().tab(Create.BASE_CREATIVE_TAB)));
    public static final RegistryObject<Item> TUFF_COMPOUND = ITEMS.register("tuff_compound", () -> new Item(new Item.Properties().tab(Create.BASE_CREATIVE_TAB)));
    private static final CreateRegistrate REGISTRATE = ToughCreate.REGISTRATE.creativeModeTab(() -> Create.BASE_CREATIVE_TAB);
    public static final ItemEntry<Item> TUFF_ALLOY = taggedIngredient("tuff_alloy", CREATE_INGOTS.tag);

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, NonNullBiConsumer<DataGenContext<Item, Item>, RegistrateRecipeProvider> recipe, TagKey<Item>... tags) {
        return REGISTRATE
                .item(name, Item::new)
                .tag(tags)
                .recipe(recipe)
                .register();
    }

    public static void register(IEventBus bus) {
        REGISTRATE.addToSection(TUFF_ALLOY, AllSections.MATERIALS);

        ITEMS.register(bus);
        ToughCreate.LOGGER.debug("Registering ModItems!");
    }
}
