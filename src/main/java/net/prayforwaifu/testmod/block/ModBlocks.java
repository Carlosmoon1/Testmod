package net.prayforwaifu.testmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.prayforwaifu.testmod.TestMod;
import net.prayforwaifu.testmod.block.custom.Cropblock;
import net.prayforwaifu.testmod.block.custom.SunstoneLampBlock;
import net.prayforwaifu.testmod.block.custom.Sunstoneblock;
import net.prayforwaifu.testmod.item.ModCreativeModeTab;
import net.prayforwaifu.testmod.item.ModItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> SUNSTONE_BLOCK = registryBlock("sunstone_block",
            () -> new Sunstoneblock(BlockBehaviour.Properties.of(Material.STONE).strength(1f,1200f)
                    .requiresCorrectToolForDrops().lightLevel((state) -> 10))
            , ModCreativeModeTab.TEST_MOD);

    public static final RegistryObject<Block> SUNSTONE_ORE = registryBlock("sunstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f,1f)
                    .requiresCorrectToolForDrops().lightLevel((state) -> 4), UniformInt.of(3,7))
            , ModCreativeModeTab.TEST_MOD);

    public static final RegistryObject<Block> DEEPSLATE_SUNSTONE_ORE = registryBlock("deepslate_sunstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f, 1f)
                    .requiresCorrectToolForDrops().lightLevel((state) -> 4), UniformInt.of(3,7))
            , ModCreativeModeTab.TEST_MOD);

    public static final RegistryObject<Block> SUN_FURNACE = registryBlock("sun_furnace",
            () -> new FurnaceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f, 1f)
                    .requiresCorrectToolForDrops().lightLevel((state) -> 4)), ModCreativeModeTab.TEST_MOD);

    public static final RegistryObject<Block> SUNSTONE_LAMP = registryBlock("sunstone_lamp",
            () -> new SunstoneLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f,1200f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(SunstoneLampBlock.LIT) ? 0 : 15))
                            , ModCreativeModeTab.TEST_MOD);

    //BLOCKS.register doesn't regesier a spereat block so ex (the block will be the seed)
    public static final RegistryObject<Block> CROPBLOCK = BLOCKS.register("cropblock",
            () -> new Cropblock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));



    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block,
                                                                             CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
