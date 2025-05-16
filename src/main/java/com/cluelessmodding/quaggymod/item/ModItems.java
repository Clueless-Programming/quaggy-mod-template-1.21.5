package com.cluelessmodding.quaggymod.item;

import com.cluelessmodding.quaggymod.QuaggyMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUSPICIOUS_MILK = registerItem("suspicious_milk", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(QuaggyMod.MOD_ID,"suspicious_milk")))));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(QuaggyMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        QuaggyMod.LOGGER.info("Registering Mod Items for " + QuaggyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(SUSPICIOUS_MILK);
        });
    }
}
