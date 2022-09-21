package ch.taeko.tcseasonsmod.mixin;

import ch.taeko.tcseasonsmod.TCWeatherMod;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Biome.class)
public class BiomeMixin {
    /**
     * @author Taeko
     * @reason Overwrite vanilla, biome dependent/static temperatures.
     */
    @Overwrite
    public float getTemperature() {
        return (float)TCWeatherMod.currentTemperature;
    }
    /**
     * @author Taeko
     * @reason Overwrite vanilla, biome dependent/static downfall.
     */
    @Overwrite
    public float getDownfall() { return (float)TCWeatherMod.currentDownfall; }
}
