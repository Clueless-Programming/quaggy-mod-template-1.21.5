package com.cluelessmodding.quaggymod.mixin;

import com.cluelessmodding.quaggymod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "interact", cancellable = true)
    private void interact(Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        PlayerEntity thisPlayer = (PlayerEntity)(Object)this;
        ItemStack itemStack = thisPlayer.getStackInHand(hand);
        if(itemStack.isOf(Items.BUCKET) && !(entity.getType().equals(EntityType.COW) || entity.getType().equals(EntityType.GOAT))) {
            if(!(entity instanceof MobEntity mob && mob.isBaby())) {
                thisPlayer.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
                ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, thisPlayer, ModItems.SUSPICIOUS_MILK.getDefaultStack());
                thisPlayer.setStackInHand(hand, itemStack2);
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}
