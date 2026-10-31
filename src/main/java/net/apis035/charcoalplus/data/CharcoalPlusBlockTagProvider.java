package net.apis035.charcoalplus.data;

import net.apis035.charcoalplus.CharcoalPlus;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CharcoalPlusBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public CharcoalPlusBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        // basic block tags
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CharcoalPlus.CHARCOAL_BLOCK);
    }

    @Override
    public String getName() {
        return "Charcoal+ Block Tags";
    }
}
