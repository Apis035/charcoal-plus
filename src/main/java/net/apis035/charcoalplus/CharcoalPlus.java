package net.apis035.charcoalplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

public class CharcoalPlus implements ModInitializer {
	public static final String MOD_ID = "charcoalplus";

	public static final Identifier COAL_PIECE_ID = Identifier.fromNamespaceAndPath(MOD_ID, "coal_piece");
	public static final Identifier CHARCOAL_PIECE_ID = Identifier.fromNamespaceAndPath(MOD_ID, "charcoal_piece");
	public static final Identifier CHARCOAL_BLOCK_ID = Identifier.fromNamespaceAndPath(MOD_ID, "charcoal_block");

	public static final Item COAL_PIECE = Registry.register(BuiltInRegistries.ITEM, COAL_PIECE_ID, new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, COAL_PIECE_ID))));
	public static final Item CHARCOAL_PIECE = Registry.register(BuiltInRegistries.ITEM, CHARCOAL_PIECE_ID, new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, CHARCOAL_PIECE_ID))));
	public static final Block CHARCOAL_BLOCK = Registry.register(BuiltInRegistries.BLOCK, CHARCOAL_BLOCK_ID, new Block(net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).setId(ResourceKey.create(Registries.BLOCK, CHARCOAL_BLOCK_ID))));
	public static final BlockItem CHARCOAL_BLOCK_ITEM = Registry.register(BuiltInRegistries.ITEM, CHARCOAL_BLOCK_ID, new BlockItem(CHARCOAL_BLOCK, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, CHARCOAL_BLOCK_ID)).useBlockDescriptionPrefix()));

	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((content) -> {
			content.addAfter(Items.COAL_BLOCK, CHARCOAL_BLOCK_ITEM);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register((content) -> {
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
