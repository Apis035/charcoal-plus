package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.function.Consumer;

public class CharcoalPlusRecipeProvider extends FabricRecipeProvider {
    public CharcoalPlusRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        /*
         * Compacting recipes
         */

        // Compact charcoal piece to charcoal, and reverse
        new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, Items.CHARCOAL, 1)
                .input(Ingredient.ofItems(CharcoalPlus.CHARCOAL_PIECE), 8)
                .criterion("has_charcoal_piece", InventoryChangedCriterion.Conditions.items(CharcoalPlus.CHARCOAL_PIECE))
                .offerTo(exporter, "charcoal_from_charcoal_piece");

        new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, CharcoalPlus.CHARCOAL_PIECE, 8)
                .input(Items.CHARCOAL)
                .criterion("has_charcoal", InventoryChangedCriterion.Conditions.items(Items.CHARCOAL))
                .offerTo(exporter, "charcoal_piece_from_charcoal");

        // Compact charcoal to charcoal block, and reverse
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, Items.CHARCOAL,
                RecipeCategory.BUILDING_BLOCKS, CharcoalPlus.CHARCOAL_BLOCK_ITEM);

        // Compact coal piece to coal, and reverse
        new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, Items.COAL, 1)
                .input(Ingredient.ofItems(CharcoalPlus.COAL_PIECE), 8)
                .criterion("has_coal_piece", InventoryChangedCriterion.Conditions.items(CharcoalPlus.COAL_PIECE))
                .offerTo(exporter, "coal_from_coal_piece");

        new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, CharcoalPlus.COAL_PIECE, 8)
                .input(Items.COAL)
                .criterion("has_coal", InventoryChangedCriterion.Conditions.items(Items.COAL))
                .offerTo(exporter, "coal_piece_from_coal");

        /*
         * Smelting recipes
         */

        // Smelt bamboo to charcoal piece
        offerSmelting(exporter,
                Collections.singletonList(Items.BAMBOO),
                RecipeCategory.MISC,
                CharcoalPlus.CHARCOAL_PIECE,
                0.1f, 150, "smelting");

        // Smelt sticks to charcoal piece
        offerSmelting(exporter,
                Collections.singletonList(Items.STICK),
                RecipeCategory.MISC,
                CharcoalPlus.CHARCOAL_PIECE,
                0.05f, 25, "smelting");
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.of(CharcoalPlus.MOD_ID, identifier.getPath());
    }
}
