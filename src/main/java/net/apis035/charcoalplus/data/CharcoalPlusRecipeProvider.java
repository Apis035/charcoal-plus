package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NullMarked;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@NullMarked
public class CharcoalPlusRecipeProvider extends FabricRecipeProvider {
    public CharcoalPlusRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                /*
                 * Compacting recipes
                 */

                // Compact charcoal piece to charcoal, and reverse
                shapeless(RecipeCategory.MISC, Items.CHARCOAL, 1)
                        .requires(Ingredient.of(CharcoalPlus.CHARCOAL_PIECE), 8)
                        .unlockedBy("has_charcoal_piece", InventoryChangeTrigger.TriggerInstance.hasItems(CharcoalPlus.CHARCOAL_PIECE))
                        .save(output, "charcoal_from_charcoal_piece");

                shapeless(RecipeCategory.MISC, CharcoalPlus.CHARCOAL_PIECE, 8)
                        .requires(Items.CHARCOAL)
                        .unlockedBy("has_charcoal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CHARCOAL))
                        .save(output, "charcoal_piece_from_charcoal");

                // Compact charcoal to charcoal block, and reverse
                nineBlockStorageRecipes(
                        RecipeCategory.MISC, Items.CHARCOAL,
                        RecipeCategory.BUILDING_BLOCKS, CharcoalPlus.CHARCOAL_BLOCK_ITEM);

                // Compact coal piece to coal, and reverse
                shapeless(RecipeCategory.MISC, Items.COAL, 1)
                        .requires(Ingredient.of(CharcoalPlus.COAL_PIECE), 8)
                        .unlockedBy("has_coal_piece", InventoryChangeTrigger.TriggerInstance.hasItems(CharcoalPlus.COAL_PIECE))
                        .save(output, "coal_from_coal_piece");

                shapeless(RecipeCategory.MISC, CharcoalPlus.COAL_PIECE, 8)
                        .requires(Items.COAL)
                        .unlockedBy("has_coal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL))
                        .save(output, "coal_piece_from_coal");

                /*
                 * Smelting recipes
                 */

                // Smelt bamboo to charcoal piece
                oreSmelting(
                        Collections.singletonList(Items.BAMBOO),
                        RecipeCategory.MISC,
                        CharcoalPlus.CHARCOAL_PIECE,
                        0.1f, 150, "smelting");

                // Smelt sticks to charcoal piece
                oreSmelting(
                        Collections.singletonList(Items.STICK),
                        RecipeCategory.MISC,
                        CharcoalPlus.CHARCOAL_PIECE,
                        0.05f, 25, "smelting");
            }
        };
    }

    @Override
    public String getName() {
        return "Charcoal+ Recipes";
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.fromNamespaceAndPath(CharcoalPlus.MOD_ID, identifier.getPath());
    }
}
