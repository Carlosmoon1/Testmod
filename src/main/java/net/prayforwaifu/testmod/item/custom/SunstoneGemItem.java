package net.prayforwaifu.testmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SunstoneGemItem extends Item {
    public SunstoneGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND){
            // Gives nightvision
            // Has 2 min cooldown
            // durability -1
            PlayerNightvision(player);
            player.getCooldowns().addCooldown(this, 2400);
            ItemStack stack = player.getItemInHand(hand);
            stack.setDamageValue(stack.getDamageValue() + 1);
            if (stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
       if (Screen.hasShiftDown()){
           Component.literal("Gives nightvision").withStyle(ChatFormatting.BLUE);

       } else {
           Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW);
       }


        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }

    private void PlayerNightvision (Player player){
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200,1));

    }
}
