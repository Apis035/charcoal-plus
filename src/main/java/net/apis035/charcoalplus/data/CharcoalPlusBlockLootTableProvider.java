package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CharcoalPlusBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected CharcoalPlusBlockLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        // simple blocks
        dropSelf(CharcoalPlus.CHARCOAL_BLOCK);
    }

    @Override
    public String getName() {
        return "Charcoal+ Block Loot Tables";
    }
}
