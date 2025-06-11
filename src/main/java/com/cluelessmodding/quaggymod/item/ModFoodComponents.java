package com.cluelessmodding.quaggymod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent SUSPICIOUS_MILK = new FoodComponent.Builder().nutrition(20).saturationModifier(20f).build();
    public static final FoodComponent SPAGHETTI = new FoodComponent.Builder().nutrition(1).saturationModifier(0.75f).build();
    public static final FoodComponent RAW_MEATBALL = new FoodComponent.Builder().nutrition(1).saturationModifier(1).build();
    public static final FoodComponent COOKED_MEATBALL = new FoodComponent.Builder().nutrition(4).saturationModifier(3f).build();
    public static final FoodComponent SPAGHETTI_AND_MEATBALLS = new FoodComponent.Builder().nutrition(10).saturationModifier(5f).build();
}
