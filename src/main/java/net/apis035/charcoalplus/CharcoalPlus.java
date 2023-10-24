package net.apis035.charcoalplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CharcoalPlus implements ModInitializer {
	public static final String MOD_ID = "charcoalplus";

	public static Item COAL_PIECE = new Item(new FabricItemSettings());
	public static Item CHARCOAL_PIECE = new Item(new FabricItemSettings());
	public static Block CHARCOAL_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK));
	public static BlockItem CHARCOAL_BLOCK_ITEM = new BlockItem(CHARCOAL_BLOCK, new FabricItemSettings());

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "coal_piece"), COAL_PIECE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "charcoal_piece"), CHARCOAL_PIECE);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "charcoal_block"), CHARCOAL_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "charcoal_block"), CHARCOAL_BLOCK_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((content) -> {
			content.add(CHARCOAL_BLOCK_ITEM);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((content) -> {
			content.add(COAL_PIECE);
			content.add(CHARCOAL_PIECE);
		});

		FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableRegistry.add(CHARCOAL_BLOCK, 5, 5);

		FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
		fuelRegistry.add(CHARCOAL_BLOCK, 16000);
		fuelRegistry.add(CHARCOAL_PIECE, 200);
		fuelRegistry.add(COAL_PIECE, 200);
	}
}
