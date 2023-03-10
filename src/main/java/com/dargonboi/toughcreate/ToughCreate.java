package com.dargonboi.toughcreate;

import com.dargonboi.toughcreate.core.item.ToughCreateItems;
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
    private static final Logger logger = LogManager.getLogger(MODID);
    public static ToughCreate INSTANCE;

    public ToughCreate() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ToughCreateItems.register(bus);
        bus.addListener(this::setup);
    }


    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Tough Create Setup");
    }


    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Tough Create Client Setup");
    }
}
