package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemstyneCreativeGroup {
    public static final ItemGroup GEMSTYNE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Gemstyne.MOD_ID, "gemstyne"),
            FabricItemGroup.builder().displayName(Text.translatable("Gemstyne"))
                    .icon(() -> new ItemStack(GemstyneOreItems.MOCHITE)).entries((displayContext, entries) -> {
                        // =====
                        // <=====| Overworld Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

                        entries.add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

                        entries.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
                        entries.add(GemstyneOreBlocks.MORKITE_BLOCK);

                        entries.add(GemstyneOreBlocks.MOCHITE.stoneOre);
                        entries.add(GemstyneOreBlocks.MOCHITE.deepslateOre);
                        entries.add(GemstyneOreBlocks.MOCHITE.rawBlock);

                        entries.add(GemstyneOreBlocks.TIN.stoneOre);
                        entries.add(GemstyneOreBlocks.TIN.deepslateOre);
                        entries.add(GemstyneOreBlocks.TIN.rawBlock);

                        entries.add(GemstyneOreBlocks.URANIUM.deepslateOre);
                        entries.add(GemstyneOreBlocks.URANIUM.rawBlock);

                        // =====
                        // <=====| Nether Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.ALDUS.netherOre);
                        entries.add(GemstyneOreBlocks.ALDUS.rawBlock);

                        entries.add(GemstyneOreBlocks.CRIMONITE.netherOre);
                        entries.add(GemstyneOreBlocks.CRIMONITE.rawBlock);
                        // =====
                        // <=====| End Ores |=====>
                        // =====

                        // =====
                        // <=====| Geodes |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.GARNET_CLUSTER);
                        entries.add(GemstyneOreBlocks.LARGE_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.MEDIUM_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.SMALL_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.BUDDING_GARNET);
                        entries.add(GemstyneOreBlocks.GARNET_BLOCK);
                        entries.add(GemstyneOreItems.GARNET);

                        entries.add(GemstyneOreBlocks.IKARITE_CLUSTER);
                        entries.add(GemstyneOreBlocks.LARGE_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.SMALL_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.BUDDING_IKARITE);
                        entries.add(GemstyneOreBlocks.IKARITE_BLOCK);
                        entries.add(GemstyneOreItems.IKARITE);

                        // =====
                        // <=====| Minerals |=====>
                        // =====
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice());

                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());

                        // =====
                        // <=====| Overworld Harvested Ore |=====>
                        // =====
                        entries.add(GemstyneOreItems.FIRE_OPAL);

                        entries.add(GemstyneOreItems.MORKITE);

                        entries.add(GemstyneOreBlocks.MOCHITE.pureBlock);
                        entries.add(GemstyneOreItems.RAW_MOCHITE);
                        entries.add(GemstyneOreItems.MOCHITE);

                        entries.add(GemstyneOreBlocks.TIN.pureBlock);
                        entries.add(GemstyneOreItems.TIN.RAW);
                        entries.add(GemstyneOreItems.TIN.INGOT);

                        entries.add(GemstyneOreBlocks.URANIUM.pureBlock);
                        entries.add(GemstyneOreItems.URANIUM.RAW);
                        entries.add(GemstyneOreItems.URANIUM.LUMP);
                        entries.add(GemstyneOreItems.URANIUM.INGOT);

                        // =====
                        // <=====| Nether Harvested Ore |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.ALDUS.pureBlock);
                        entries.add(GemstyneOreItems.ALDUS.RAW);
                        entries.add(GemstyneOreItems.ALDUS.INGOT);

                        entries.add(GemstyneOreBlocks.CRIMONITE.pureBlock);
                        entries.add(GemstyneOreItems.CRIMONITE.RAW);
                        entries.add(GemstyneOreItems.CRIMONITE.LUMP);
                        entries.add(GemstyneOreItems.CRIMONITE.INGOT);

                        // =====
                        // <=====| End Harvested Ore |=====>
                        // =====

                        // =====
                        // <=====| Alloys |=====>
                        // =====
                        entries.add(GemstyneOreItems.BRONZE.INGOT);
                        entries.add(GemstyneOreItems.BRONZE.NUGGET);
                        entries.add(GemstyneOreItems.BRONZE.CHAIN);

                        // =====
                        // <=====| Armors |=====>
                        // =====
                        entries.add(GemstyneArmorItems.ALDUS.HELMET);
                        entries.add(GemstyneArmorItems.ALDUS.CHESTPLATE);
                        entries.add(GemstyneArmorItems.ALDUS.LEGGINGS);
                        entries.add(GemstyneArmorItems.ALDUS.BOOTS);

                        entries.add(GemstyneArmorItems.BRONZEMAIL.HELMET);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.CHESTPLATE);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.LEGGINGS);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.BOOTS);

                        entries.add(GemstyneArmorItems.BRONZEPLATE.HELMET);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.LEGGINGS);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.BOOTS);

                        entries.add(GemstyneArmorItems.RENDFIRE.HELMET);
                        entries.add(GemstyneArmorItems.RENDFIRE.CHESTPLATE);
                        entries.add(GemstyneArmorItems.RENDFIRE.LEGGINGS);
                        entries.add(GemstyneArmorItems.RENDFIRE.BOOTS);
                        // =====
                        // <=====| Tools |=====>
                        // =====
                        entries.add(GemstyneToolItems.ALDUS.AXE);
                        entries.add(GemstyneToolItems.ALDUS.HOE);
                        entries.add(GemstyneToolItems.ALDUS.PICKAXE);
                        entries.add(GemstyneToolItems.ALDUS.SHOVEL);
                        entries.add(GemstyneToolItems.ALDUS.SWORD);

                        entries.add(GemstyneToolItems.BRONZE.AXE);
                        entries.add(GemstyneToolItems.BRONZE.HOE);
                        entries.add(GemstyneToolItems.BRONZE.PICKAXE);
                        entries.add(GemstyneToolItems.BRONZE.SHOVEL);
                        entries.add(GemstyneToolItems.BRONZE.SWORD);

                        entries.add(GemstyneToolItems.RENDFIRE.AXE);
                        entries.add(GemstyneToolItems.RENDFIRE.HOE);
                        entries.add(GemstyneToolItems.RENDFIRE.PICKAXE);
                        entries.add(GemstyneToolItems.RENDFIRE.SHOVEL);
                        entries.add(GemstyneToolItems.RENDFIRE.SWORD);

                        // =====
                        // <=====| Gear |=====>
                        // =====
                        entries.add(GemstyneGearItems.getImbuedFeather());
                        entries.add(GemstyneFluids.LIQUID_MORKITE_BUCKET);


                        entries.add(GemstyneCraftingItems.getImbuedRod());
                    }).build());

    public static final OwoItemGroup GEMSTYNE_GROUP = OwoItemGroup.builder(GemstyneRegistry.id("main"),
            () -> Icon.of(GemstyneOreItems.FIRE_OPAL)).build();

    public static void registerGroups() {
        Gemstyne.LOGGER.info("Registering Gemstyne Group(s)...");
        GEMSTYNE_GROUP.initialize();
        Gemstyne.LOGGER.info("Successfully registered Gemstyne Group(s)!");
    }


}
