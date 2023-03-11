package com.dargonboi.toughcreate;

import com.dargonboi.toughcreate.core.item.ToughCreateItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
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
        REGISTRATE.registerEventListeners(bus);
        MinecraftForge.EVENT_BUS.register(this);

        ToughCreateItems.register(bus);
        bus.addListener(this::setup);
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
