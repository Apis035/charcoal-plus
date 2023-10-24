package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class CharcoalPlusBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected CharcoalPlusBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // simple blocks
        addDrop(CharcoalPlus.CHARCOAL_BLOCK);
    }
}
