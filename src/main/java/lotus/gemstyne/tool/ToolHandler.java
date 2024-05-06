package lotus.gemstyne.tool;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.tool.custom.PaxelItem;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * Gemstyne's tool-item holder. A record is used to auto-generate getters.
 */
public final class ToolHandler {
    private ToolHandler() {}
    
    // =====
    // <=====| Damage & Speed |=====>
    // =====
    private static final float[] ALDUS_DAMAGE = {6.0f, -2.0f, 1.0f, 1.5f, 4.0f};
    private static final float[] BRONZE_DAMAGE = {6.0f, -2.0f, 1, 1.5f, 3.0f};
    private static final float[] RENDFIRE_DAMAGE = {5.0f, -4.0f, 1.0f, 1.5f, 4.0f};

    private static final float[] ALDUS_SPEED = {-3.0f, -0.5f, -2.7f, -3.0f, -2.4f};
    private static final float[] BRONZE_SPEED = {-3.1f, -0.5f, -2.7f, -2.8f, -2.4f};
    private static final float[] RENDFIRE_SPEED = {-3.0f, 0.0f, -2.8f, -3.0f, -2.4f};

    public static final GemstyneToolSet ALDUS = new GemstyneToolSet(new OwoItemSettings(),
            ALDUS_DAMAGE, ALDUS_SPEED, "aldus", GemstyneToolMaterials.ALDUS, ItemHandler.ALDUS.ingot());
    public static final GemstyneToolSet BRONZE = new GemstyneToolSet(new OwoItemSettings(),
            BRONZE_DAMAGE, BRONZE_SPEED, "bronze", GemstyneToolMaterials.BRONZE, ItemHandler.BRONZE.ingot());
    public static final GemstyneToolSet RENDFIRE = new GemstyneToolSet(new OwoItemSettings(),
            RENDFIRE_DAMAGE, RENDFIRE_SPEED, "rendfire", GemstyneToolMaterials.RENDFIRE, ItemHandler.FIRE_OPAL);
    public static final GemstyneToolSet MUTALIUM = new GemstyneToolSet(new OwoItemSettings(),
        ALDUS_DAMAGE, ALDUS_DAMAGE, "mutalium", GemstyneToolMaterials.ALDUS, ItemHandler.MUTALIUM.ingot());

    public static final PaxelItem ALDUS_PAXEL = new PaxelItem(6.0f, -2.0f, GemstyneToolMaterials.ALDUS, new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE));


    public static void registerToolItems() {
        Registry.register(Registries.ITEM, GemstyneRegistry.id("aldus_paxel"), ALDUS_PAXEL);
        Gemstyne.LOGGER.info("Registering Tool Items...");

    }
}
