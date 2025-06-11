package com.cluelessmodding.quaggymod.item;

import com.cluelessmodding.quaggymod.QuaggyMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.minecraft.block.Block;
//import net.minecraft.component.DataComponentTypes;
//import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
//import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

//import java.util.function.BiFunction;
import java.util.function.Function;
//import java.util.function.UnaryOperator;

import static net.minecraft.item.Items.BOWL;
import static net.minecraft.item.Items.BUCKET;
public class ModItems {
    public static Item SUSPICIOUS_MILK;
    public static Item SPAGHETTI;
    public static Item RAW_MEATBALL;
    public static Item COOKED_MEATBALL;
    public static Item SPAGHETTI_AND_MEATBALLS;

        public ModItems() {
        }

        private static RegistryKey<Item> keyOf(String id) {
            return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(QuaggyMod.MOD_ID, id));
        }

        public static Item register(String id, Item.Settings settings) {
            return register(keyOf(id), Item::new, settings);
        }

        public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
            settings = settings.registryKey(key).translationKey("item." + key.getValue().getNamespace() + "." + key.getValue().getPath());

            Item item = (Item) factory.apply(settings);
            if (item instanceof BlockItem blockItem) {
                blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
            }
            return (Item) Registry.register(Registries.ITEM, key, item);
        }
        /*private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
            return (settings) -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
        }

        private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
            return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
        }

        public static Item register(Block block) {
            return register(block, BlockItem::new);
        }

        public static Item register(Block block, Item.Settings settings) {
            return register(block, BlockItem::new, settings);
        }

        public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
            return register(block, ((blockx, settings) -> new BlockItem(blockx, settingsOperator.apply(settings))));
        }

        public static Item register(Block block, Block... blocks) {
            Item item = register(block);

            for (Block block2 : blocks) {
                Item.BLOCK_ITEMS.put(block2, item);
            }

            return item;
        }

        public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
            return register(block, factory, new Item.Settings());
        }

        public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
            return register(keyOf(block.getRegistryEntry().registryKey()), ((itemSettings) -> factory.apply(block, itemSettings)), settings.useBlockPrefixedTranslationKey());
        }

        public static Item register(String id, Function<Item.Settings, Item> factory) {
            return register(keyOf(id), factory, new Item.Settings());
        }

        public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
            return register(keyOf(id), factory, settings);
        }

        public static Item register(String id) {
            return register(keyOf(id), Item::new, new Item.Settings());
        }

        public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory) {
            return register(key, factory, new Item.Settings());
        }*/

        private static Item register(String name, Item item) {
            return Registry.register(Registries.ITEM, Identifier.of(QuaggyMod.MOD_ID, name), item);
        }

    public static void registerModItems() {
        QuaggyMod.LOGGER.info("Registering Mod Items for " + QuaggyMod.MOD_ID);
        SUSPICIOUS_MILK = register("suspicious_milk", (new Item.Settings()).rarity(Rarity.EPIC).recipeRemainder(BUCKET).food(ModFoodComponents.SUSPICIOUS_MILK, ModConsumableComponents.SUSPICIOUS_MILK).useRemainder(BUCKET).maxCount(1));
        SPAGHETTI = register("spaghetti", (new Item.Settings()).food(ModFoodComponents.SPAGHETTI, ModConsumableComponents.SPAGHETTI));
        RAW_MEATBALL = register("raw_meatball", (new Item.Settings()).food(ModFoodComponents.RAW_MEATBALL, ModConsumableComponents.RAW_MEATBALL));
        COOKED_MEATBALL = register("cooked_meatball", (new Item.Settings()).food(ModFoodComponents.COOKED_MEATBALL, ModConsumableComponents.COOKED_MEATBALL));
        SPAGHETTI_AND_MEATBALLS = register("spaghetti_and_meatballs", (new Item.Settings()).food(ModFoodComponents.SPAGHETTI_AND_MEATBALLS, ModConsumableComponents.SPAGHETTI_AND_MEATBALLS).useRemainder(BOWL));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.SUSPICIOUS_MILK);
            entries.add(ModItems.SPAGHETTI);
            entries.add(ModItems.RAW_MEATBALL);
            entries.add(ModItems.COOKED_MEATBALL);
            entries.add(ModItems.SPAGHETTI_AND_MEATBALLS);
        });
    }
}
