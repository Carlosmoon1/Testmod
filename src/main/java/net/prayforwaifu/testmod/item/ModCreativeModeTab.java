package net.prayforwaifu.testmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TEST_MOD = new CreativeModeTab("testmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAW_SUNSTONE.get());
        };
    };
}
