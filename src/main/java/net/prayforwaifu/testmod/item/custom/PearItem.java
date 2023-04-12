package net.prayforwaifu.testmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PearItem extends Item {
    public PearItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()){
            Component.literal("This gives fire-resistant").withStyle(ChatFormatting.BLUE);
        } else {
            Component.literal("Hold SHIFT for more info").withStyle(ChatFormatting.YELLOW);
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
