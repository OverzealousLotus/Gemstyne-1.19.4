package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneMineralItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

/**
 * <h3>GemstyneItemHandler</h3>
 * <code>GemstyneItemHandler</code> is used to wrap all of Gemstyne's items together, and provide methods
 * to help the registering process.
 */
public final class GemstyneItemHandler {
    /**
     * Method used to assign an {@link Item} to fields.
     * @param settings {@link FabricItemSettings}
     * @return Returns a new {@link Item} with specified settings.
     */
    public static Item assignItem(FabricItemSettings settings) {
        return new Item(settings);
    }

    public static void registerGemstyneItems() {
        Gemstyne.LOGGER.info("Registering Items for " + Gemstyne.MOD_ID + "!");
        GemstyneGearItems.registerGearItems();
        GemstyneOreItems.registerOreItems();
        GemstyneMineralItems.registerMineralItems();
        GemstyneCraftingItems.registerCraftingItems();
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        Gemstyne.LOGGER.info("Successfully registered Items for " + Gemstyne.MOD_ID + "!");
    }
}
