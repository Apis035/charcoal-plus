package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CharcoalPlusModelProvider extends FabricModelProvider {
    public CharcoalPlusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(CharcoalPlus.CHARCOAL_BLOCK);
    }


    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(CharcoalPlus.COAL_PIECE, Models.GENERATED);
        generator.register(CharcoalPlus.CHARCOAL_PIECE, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Charcoal+ Models";
    }
}
