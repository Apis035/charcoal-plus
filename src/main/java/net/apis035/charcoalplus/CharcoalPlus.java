package net.apis035.charcoalplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CharcoalPlus implements ModInitializer {
	public static final String MOD_ID = "charcoalplus";

	public static final Identifier COAL_PIECE_ID = Identifier.of(MOD_ID, "coal_piece");
	public static final Identifier CHARCOAL_PIECE_ID = Identifier.of(MOD_ID, "charcoal_piece");
	public static final Identifier CHARCOAL_BLOCK_ID = Identifier.of(MOD_ID, "charcoal_block");

	public static final Item COAL_PIECE = Registry.register(Registries.ITEM, COAL_PIECE_ID, new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, COAL_PIECE_ID))));
	public static final Item CHARCOAL_PIECE = Registry.register(Registries.ITEM, CHARCOAL_PIECE_ID, new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, CHARCOAL_PIECE_ID))));
	public static final Block CHARCOAL_BLOCK = Registry.register(Registries.BLOCK, CHARCOAL_BLOCK_ID, new Block(AbstractBlock.Settings.copy(Blocks.COAL_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, CHARCOAL_BLOCK_ID))));
	public static final BlockItem CHARCOAL_BLOCK_ITEM = Registry.register(Registries.ITEM, CHARCOAL_BLOCK_ID, new BlockItem(CHARCOAL_BLOCK, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, CHARCOAL_BLOCK_ID)).useBlockPrefixedTranslationKey()));

	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((content) -> {
			content.addAfter(Items.COAL_BLOCK, CHARCOAL_BLOCK_ITEM);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((content) -> {
			content.addAfter(Items.CHARCOAL, COAL_PIECE, CHARCOAL_PIECE);
		});

		FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableRegistry.add(CHARCOAL_BLOCK, 5, 5);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(CHARCOAL_BLOCK, 16000);
			builder.add(CHARCOAL_PIECE, 200);
			builder.add(COAL_PIECE, 200);
		});
		}
}
