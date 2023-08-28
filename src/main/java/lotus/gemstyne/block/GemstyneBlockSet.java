package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.util.GemstyneBlockTypes;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Pair;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GemstyneBlockSet {
    @NotNull private final Map<String, Block> blockVariants = new LinkedHashMap<>();
    @NotNull private final Set<Pair<String, Block>> blockSet = new HashSet<>();
    // public Block rawBlock;
    // public Block pureBlock;

    private StatusEffect effect;
    private BlockSoundGroup currentSounds = BlockSoundGroup.STONE;
    private float currentHardness = 3.0f;
    private float currentResistance = 3.0f;
    private UniformIntProvider experience = UniformIntProvider.create(2, 5);
    private FabricBlockSettings currentSettings = FabricBlockSettings.copyOf(Blocks.STONE);
    private final String SET_NAME;

    public GemstyneBlockSet(String setName) {
        this.SET_NAME = setName;
    }

    /**
     * Method to modify strength of {@link GemstyneBlockSet}
     * @param hardness Hardness of BlockSet
     * @param resistance Blast Resistance of BlockSet.
     * @return Returns current instance of {@link GemstyneBlockSet}
     */
    public GemstyneBlockSet modifyStrength(float hardness, float resistance) {
        this.currentHardness = hardness;
        this.currentResistance = resistance;
        this.currentSettings = this.currentSettings.strength(this.currentHardness, this.currentResistance);
        return this;
    }

    /**
     * Simplified version of <code>modifyStrength</code>
     * @param hardness Hardness of BlockSet
     * @return Returns current instance of {@link GemstyneBlockSet}
     */
    protected GemstyneBlockSet modifyStrength(float hardness) {
        this.currentHardness = hardness;
        this.currentSettings = this.currentSettings.strength(this.currentHardness);
        return this;
    }

    /**
     * Modifies sounds of {@link GemstyneBlockSet}
     * @param sounds {@link BlockSoundGroup} to be assigned.
     * @return Returns an instance of itself.
     */
    protected GemstyneBlockSet modifySounds(BlockSoundGroup sounds) {
        this.currentSounds = sounds;
        return this;
    }

    /**
     * Sets experience of {@link GemstyneBlockSet}.
     * @param experience Experience dropped by all ores in set.
     * @return Returns an instance of itself.
     */
    protected GemstyneBlockSet setExperience(UniformIntProvider experience) {
        this.experience = experience;
        return this;
    }

    /**
     * Sets {@link StatusEffect} of {@link GemstyneBlockSet}
     * @param effect {@link StatusEffect}
     * @return Instance of self.
     */
    public GemstyneBlockSet setEffect(StatusEffect effect) {
        this.effect = effect;
        return this;
    }

    /**
     * Creates a Stone variant for {@link GemstyneBlockSet}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOre() {
        this.blockVariants.put("stone", new ExperienceDroppingBlock(this.currentSettings));
        this.blockSet.add(new Pair<>(this.SET_NAME + "_ore", safelyFetch("stone")));
        return this;
    }

    /**
     * Variant of original method to create generic block
     * @param block Any which implements {@link ExperienceDroppingBlock}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOre(ExperienceDroppingBlock block) {
        this.blockVariants.put("stone", block);
        this.blockSet.add(new Pair<>(this.SET_NAME + "_ore", this.safelyFetch("stone")));
        return this;
    }

    /**
     * Creates an unknown ore variant for {@link GemstyneBlockSet}
     * @param type Variant
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.blockVariants.put(type, new ExperienceDroppingBlock(this.currentSettings, this.experience));
        this.blockSet.add(new Pair<>(type + "_" + this.SET_NAME + "_ore", safelyFetch(type)));
        return this;
    }

    /**
     * Variation of original method, but instead creates an {@link AfflictiveOre}
     * @param type Variant
     * @param duration Duration of {@link StatusEffect}
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, int duration, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.blockVariants.put(type, new AfflictiveOre(this.currentSettings, this.effect,
                duration, GemstyneBlockTypes.ORE, this.experience));
        this.blockSet.add(new Pair<>(type + "_" + this.SET_NAME + "_ore", safelyFetch(type)));
        return this;
    }

    /**
     * Variation of original method, but instead creates a generic ore with no special parameters.
     * @param type Variant
     * @param block Any which extends {@link ExperienceDroppingBlock}
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, ExperienceDroppingBlock block, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.blockVariants.put(type, block);
        this.blockSet.add(new Pair<>(type + "_" + this.SET_NAME + "_ore", safelyFetch(type)));
        return this;
    }

    public GemstyneBlockSet createRawBlock() {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.blockVariants.put("raw", new Block(this.currentSettings));
        this.blockSet.add(new Pair<>("raw_" + this.SET_NAME + "_block", this.safelyFetch("raw")));
        return this;
    }

    public GemstyneBlockSet createRawBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.blockVariants.put("raw", new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.RAW));
        this.blockSet.add(new Pair<>("raw_" + this.SET_NAME + "_block", this.safelyFetch("raw")));
        return this;
    }

    public GemstyneBlockSet createPureBlock() {
        this.blockVariants.put("pure", new Block(this.currentSettings.sounds(this.currentSounds)));
        this.blockSet.add(new Pair<>(this.SET_NAME + "_block", this.safelyFetch("pure")));
        return this;
    }

    public GemstyneBlockSet createPureBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds);
        this.blockVariants.put("pure", new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.PURE));
        this.blockSet.add(new Pair<>(this.SET_NAME + "_block", this.safelyFetch("pure")));
        return this;
    }

    public GemstyneBlockSet createDefaultBlockSet(float strength) {
        this.modifyStrength(strength).createOre()
                .modifyStrength(strength + 1.5f)
                .createOreType("deepslate", BlockSoundGroup.DEEPSLATE)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock()
                .create();
        return this;
    }
    public GemstyneBlockSet createDefaultNetherBlockSet(float strength) {
        return this.modifyStrength(strength).createOreType("nether", BlockSoundGroup.NETHER_ORE)
                .modifyStrength(strength + 1.5f)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock()
                .create();
    }

    public void generateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockSet.forEach(blockIdPair -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockIdPair.getRight()));
    }

    /**
     * Used to finalize creation of {@link GemstyneBlockSet}. Responsible for registering blocks
     * into Minecraft, using a {@link HashSet} storing a {@link Pair} containing a String on the left:
     * The ID of the block; On the right: The block itself.
     * @return Returns an instance of self.
     */
    public GemstyneBlockSet create() {
        this.blockSet.forEach(blockIdPair -> GemstyneRegistry.registerBlock(blockIdPair.getLeft(), blockIdPair.getRight()));
        return this;
    }

    /**
     * Safely fetches an {@link Block} from {@link GemstyneBlockSet}. If the Block is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param blockName Name of target {@link Block}
     * @return Returns {@link Block} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    private Block safelyFetch(String blockName) {
        Optional<Block> block = Optional.ofNullable(this.blockVariants.get(blockName));
        if(block.isPresent()) {
            return this.blockVariants.get(blockName);
        } else {
            Gemstyne.LOGGER.error("[[ ERROR: " + blockName + " for set " + this.SET_NAME + " is null!" +
                    " Maybe the Block is improperly initialized?" +
                    " OR the BlockSet was called in an incompatible Method!" +
                    " OTHERWISE the wrong getter was called!");
        }
        throw new NullPointerException();
    }

    public Block stoneOre() { return safelyFetch("stone"); }
    public Block deepslateOre() { return safelyFetch("deepslate"); }
    public Block netherOre() { return safelyFetch("nether"); }
    public Block rawBlock() { return safelyFetch("raw"); }
    public Block pureBlock() { return safelyFetch("pure"); }
}
