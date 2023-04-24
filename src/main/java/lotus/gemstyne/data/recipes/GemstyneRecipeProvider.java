package lotus.gemstyne.data.recipes;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class GemstyneRecipeProvider extends FabricRecipeProvider {
    public GemstyneRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Smelting/Blasting =====>
        // =====

        offerSmelting(exporter, List.of(GemstyneOreItems.getRawMochite()), RecipeCategory.MISC,
                GemstyneOreItems.getMochite(), 0.5f, 200, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.getRawMochite()), RecipeCategory.MISC,
                GemstyneOreItems.getMochite(), 0.5f, 100, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.getRawUranium()), RecipeCategory.MISC,
                GemstyneOreItems.getUraniumChunk(), 1.0f, 300, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.getRawUranium()), RecipeCategory.MISC,
                GemstyneOreItems.getUraniumChunk(), 1.0f, 150, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.getRawCrimonite()), RecipeCategory.MISC,
                GemstyneOreItems.getCrimoniteChunk(), 1.0f, 350, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.getRawCrimonite()), RecipeCategory.MISC,
                GemstyneOreItems.getCrimoniteChunk(), 1.0f, 175, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.getRawAldus()), RecipeCategory.MISC,
                GemstyneOreItems.getAldusIngot(), 1.0f, 200, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.getRawAldus()), RecipeCategory.MISC,
                GemstyneOreItems.getAldusIngot(), 1.0f, 100, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getMochite(), RecipeCategory.DECORATIONS, GemstyneDecorBlocks.MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getRawMochite(), RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneDecorBlocks.URANIUM_BLOCK, RecipeCategory.DECORATIONS, GemstyneOreItems.getUraniumIngot());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.getRawUranium(), RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getFireOpal(), RecipeCategory.DECORATIONS, GemstyneDecorBlocks.FIRE_OPAL_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getCrimoniteIngot(), RecipeCategory.DECORATIONS, GemstyneDecorBlocks.CRIMONITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getRawCrimonite(), RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getAldusIngot(), RecipeCategory.DECORATIONS, GemstyneDecorBlocks.ALDUS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.getRawAldus(), RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_ALDUS_BLOCK);

        // =====
        // <===== Ingots =====>
        // =====
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.getUraniumChunk(), GemstyneOreItems.getUraniumIngot(), GemstyneOreItems.getUraniumChunk());
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.getCrimoniteChunk(), GemstyneOreItems.getCrimoniteIngot(), GemstyneOreItems.getCrimoniteChunk());

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMBUED_ROD)
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(Items.QUARTZ),
                        FabricRecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.IMBUED_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMBUED_FEATHER)
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', GemstyneOreItems.getIkarite())
                .input('I', ModItems.IMBUED_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.IMBUED_ROD),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IMBUED_ROD))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.getIkarite()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.getIkarite()))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.IMBUED_FEATHER)));


        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
    }

    private static void offerBasicIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, RecipeCategory category, Item input, Item output, Item name) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("CC")
                .pattern("CC")
                .input('C', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(name)));
    }
}
