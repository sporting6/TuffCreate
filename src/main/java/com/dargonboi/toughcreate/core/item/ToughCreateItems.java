package com.dargonboi.toughcreate.core.item;

import com.dargonboi.toughcreate.ToughCreate;
import com.simibubi.create.Create;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToughCreateItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ToughCreate.MODID);

    public static final RegistryObject TUFF_ALLOY = ITEMS.register("tuff_alloy", ()-> new Item(new Item.Properties().tab(Create.BASE_CREATIVE_TAB)));
    public static final RegistryObject TUFF_CRUSHED = ITEMS.register("tuff_crushed", ()-> new Item(new Item.Properties().tab(Create.BASE_CREATIVE_TAB)));
    public static final RegistryObject TUFF_COMPOUND = ITEMS.register("tuff_compound", ()-> new Item(new Item.Properties().tab(Create.BASE_CREATIVE_TAB)));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
