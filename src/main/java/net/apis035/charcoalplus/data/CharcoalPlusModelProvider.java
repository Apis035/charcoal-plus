package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CharcoalPlusModelProvider extends FabricModelProvider {
    public CharcoalPlusModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createTrivialCube(CharcoalPlus.CHARCOAL_BLOCK);
    }


    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(CharcoalPlus.COAL_PIECE, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CharcoalPlus.CHARCOAL_PIECE, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName() {
        return "Charcoal+ Models";
    }
}
