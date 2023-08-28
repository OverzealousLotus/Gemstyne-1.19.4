package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneOreModels {


    public static void generateOreBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // ==========
        // <========== Quadrilateral Ores ==========>
        // ==========
        // =====



        // =====
        // <===== Overworld =====>
        // =====

        GemstyneOreBlocks.TORRIUM.generateModels(blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        GemstyneOreBlocks.MOCHITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.TIN.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.URANIUM.generateModels(blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MORKITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        GemstyneOreBlocks.CRIMONITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.ALDUS.generateModels(blockStateModelGenerator);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NEFARIUM_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.MOCHITE.raw(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.TIN.raw(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM.raw(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.GARNET, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.raw(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ALDUS.raw(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.MOCHITE.crystal(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.TIN.ingot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.URANIUM.nugget(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM.chunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM.ingot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.nugget(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.chunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.ingot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ALDUS.nugget(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ALDUS.ingot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.BRONZE.ingot(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE.chain(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE.nugget(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);
    }
}
