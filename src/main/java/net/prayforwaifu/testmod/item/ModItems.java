package net.prayforwaifu.testmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.prayforwaifu.testmod.TestMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> SUNSTONE = ITEMS.register("sunstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> MOONSTONE = ITEMS.register("moonstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
