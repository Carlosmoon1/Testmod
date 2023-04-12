package net.prayforwaifu.testmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.prayforwaifu.testmod.TestMod;
import net.prayforwaifu.testmod.block.ModBlocks;
import net.prayforwaifu.testmod.item.custom.PearItem;
import net.prayforwaifu.testmod.item.custom.SunstoneGemItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> SUNSTONE_INGOT = ITEMS.register("sunstone_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> RAW_SUNSTONE = ITEMS.register("raw_sunstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> SUNSTNONE_DUST = ITEMS.register("sunstone_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> AMP_SUNSTONE_DUST = ITEMS.register("amp_sunstone_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> AMP_SUNSTONE_ÍNGOT = ITEMS.register("amp_sunstone_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    public static final RegistryObject<Item> SUNSTONE_GEM = ITEMS.register("sunstone_gem",
            () -> new SunstoneGemItem(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)
                    .stacksTo(1).durability(25)));

    public static final RegistryObject<Item> SHINING_SUNSTONE_GEM = ITEMS.register("shining_sunstone_gem",
            () -> new SunstoneGemItem(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)
                    .stacksTo(1).durability(25)));

    // "ItemNameBlockItem" makes it the item for the block
    // "ModBlock.----.get()" is how to choose the block the item is representing
    public static final RegistryObject<Item> CROP_SEED = ITEMS.register("crop_seed",
            () -> new ItemNameBlockItem(ModBlocks.CROPBLOCK.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TEST_MOD)));

    // To make a new Food item ".food" has to be used
    // "(new FoodProperties.Builder())" is used to create the properties of the food
    // ".nutrition(x)" x = how many nutrition points it gives
    // ".saturationMod(x)" x = how many saturation points it gives
    // always end the food builder with ".build"
    public static final RegistryObject<Item> CROP_FRUIT = ITEMS.register("crop_fruit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD).food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(2).build())));

    //".effect()" gives the player an effect after eating the food
    //".alwaysEat()" make u able to eat the food with a full bar
    public static final RegistryObject<Item> FRUIT = ITEMS.register("fruit",
            () -> new PearItem(new Item.Properties().tab(ModCreativeModeTab.TEST_MOD).food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(2)
                    .effect( () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200,0),1)
                    .alwaysEat().build())));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
