package net.prayforwaifu.testmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SunstoneGemItem extends Item {
    public SunstoneGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND){
            // gives nightvision
            // has 2 min cooldown
            PlayerNightvision(player);
            player.getCooldowns().addCooldown(this, 2400);
        }
        return super.use(level, player, hand);
    }

    private void PlayerNightvision (Player player){
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200,1));

    }
}
