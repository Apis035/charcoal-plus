package net.apis035.charcoalplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharcoalPlus implements ModInitializer {
	public static final String MOD_ID = "charcoalplus";

	public static Item COAL_PIECE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
	public static Item CHARCOAL_PIECE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
	public static Block CHARCOAL_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "coal_piece"), COAL_PIECE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "charcoal_piece"), CHARCOAL_PIECE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "charcoal_block"), CHARCOAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "charcoal_block"), new BlockItem(CHARCOAL_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		FuelRegistry registry = FuelRegistry.INSTANCE;
		registry.add(CHARCOAL_BLOCK, 16000);
		registry.add(CHARCOAL_PIECE, 200);
		registry.add(COAL_PIECE, 200);
	}
}
