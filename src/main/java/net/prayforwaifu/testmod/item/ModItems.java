package net.prayforwaifu.testmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.prayforwaifu.testmod.TestMod;
import net.prayforwaifu.testmod.item.custom.SunstoneGemItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> SUNSTONE_INGOT = ITEMS.register("sunstone_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> RAW_SUNSTONE = ITEMS.register("raw_sunstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> SUNSTONE_GEM = ITEMS.register("sunstone_gem",
            () -> new SunstoneGemItem(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
