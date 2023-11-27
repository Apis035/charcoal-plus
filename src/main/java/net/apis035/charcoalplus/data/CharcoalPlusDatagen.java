package net.apis035.charcoalplus.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CharcoalPlusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        pack.addProvider(CharcoalPlusBlockLootTableProvider::new);
        pack.addProvider(CharcoalPlusBlockTagProvider::new);
        pack.addProvider(CharcoalPlusRecipeProvider::new);
    }
}
