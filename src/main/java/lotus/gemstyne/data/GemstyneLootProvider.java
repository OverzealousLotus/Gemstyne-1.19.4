package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public final class GemstyneLootProvider extends FabricBlockLootTableProvider {
    public GemstyneLootProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        /* Add drops when breaking FIRST block.
        * For example, first entry drops itself.
        * Second entry drops Raw Mochite from Mochite Ore.
        * Third the same, except from Deepslate variant. */

        // ======
        // <===== Overworld Ore Loot =====>
        // ======
        gemstyneOreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, GemstyneOreItems.FIRE_OPAL);

        gemstyneOreDrops(GemstyneOreBlocks.MOCHITE.stoneOre, GemstyneOreItems.RAW_MOCHITE);
        gemstyneOreDrops(GemstyneOreBlocks.MOCHITE.deepslateOre, GemstyneOreItems.RAW_MOCHITE);

        gemstyneOreDrops(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, GemstyneOreItems.MORKITE);

        gemstyneRichOreDrops(GemstyneOreBlocks.TIN.stoneOre,
                GemstyneOreItems.TIN.RAW, 1.0f, 3.0f);
        gemstyneRichOreDrops(GemstyneOreBlocks.TIN.deepslateOre,
                GemstyneOreItems.TIN.RAW, 1.0f, 3.0f);

        gemstyneOreDrops(GemstyneOreBlocks.URANIUM.deepslateOre, GemstyneOreItems.URANIUM.RAW);
        // ======
        // <===== Nether Ore Loot =====>
        // ======

        gemstyneOreDrops(GemstyneOreBlocks.ALDUS.netherOre, GemstyneOreItems.ALDUS.RAW);

        gemstyneOreDrops(GemstyneOreBlocks.CRIMONITE.netherOre, GemstyneOreItems.CRIMONITE.RAW);
        // ======
        // <===== Ore Extension Loot =====>
        // ======
        gemstyneRichOreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE,
                Items.COAL, 2.0f, 5.0f);

        // ======
        // <===== Compact Ore Loot =====>
        // ======
        addDrop(GemstyneOreBlocks.ALDUS.rawBlock);
        addDrop(GemstyneOreBlocks.ALDUS.pureBlock);

        addDrop(GemstyneOreBlocks.CRIMONITE.rawBlock);
        addDrop(GemstyneOreBlocks.CRIMONITE.pureBlock);

        addDrop(GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        addDrop(GemstyneOreBlocks.MOCHITE.rawBlock);
        addDrop(GemstyneOreBlocks.MOCHITE.pureBlock);

        addDrop(GemstyneOreBlocks.MORKITE_BLOCK);

        addDrop(GemstyneOreBlocks.TIN.rawBlock);
        addDrop(GemstyneOreBlocks.TIN.pureBlock);

        addDrop(GemstyneOreBlocks.URANIUM.rawBlock);
        addDrop(GemstyneOreBlocks.URANIUM.pureBlock);

        addDrop(GemstyneOreBlocks.IKARITE_BLOCK);
        addDrop(GemstyneOreBlocks.GARNET_BLOCK);

        // ======
        // <===== Mineral Loot =====>
        // ======
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());

        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.halite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro());

        // ======
        // <===== Geode Drops =====>
        // ======
        gemstyneOreDrops(GemstyneOreBlocks.IKARITE_CLUSTER, GemstyneOreItems.IKARITE);
        gemstyneOreDrops(GemstyneOreBlocks.GARNET_CLUSTER, GemstyneOreItems.GARNET);

        gemstyneOreDrops(GemstyneOreBlocks.NEFARIUM_ORE, Items.DIAMOND);
    }


    // ======
    // <===== Assistive Methods =====>
    // ======
    public void gemstyneRichOreDrops(Block ore, Item drop, float min, float max) {
        LootTable.Builder table = BlockLootTableGenerator.dropsWithSilkTouch(ore,
                this.applyExplosionDecay(ore, ((LeafEntry.Builder<?>) ItemEntry.builder(drop).apply(
                        SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

        addDrop(ore, table);
    }

    private void gemstyneOreDrops(Block ore, Item drop) {
        addDrop(ore, oreDrops(ore, drop));
    }
}
