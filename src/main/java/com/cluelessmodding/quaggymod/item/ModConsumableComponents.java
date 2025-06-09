package com.cluelessmodding.quaggymod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent FOOD = food().build();
    public static final ConsumableComponent DRINK = drink().build();
    public static final ConsumableComponent SUSPICIOUS_MILK;
    public static final ConsumableComponent SPAGHETTI;
    public static final ConsumableComponent RAW_MEATBALL;
    public static final ConsumableComponent COOKED_MEATBALL;

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    public static ConsumableComponent.Builder drink() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.DRINK).sound(SoundEvents.ENTITY_GENERIC_DRINK).consumeParticles(false);
    }
    static {
        SUSPICIOUS_MILK = drink().consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.NAUSEA, -1, 256), new StatusEffectInstance(StatusEffects.SLOWNESS, -1, 5)))).build();
        SPAGHETTI = food().build();
        RAW_MEATBALL = food().build();
        COOKED_MEATBALL = food().build();
    }
}
