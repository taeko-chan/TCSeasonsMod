package ch.taeko.tcseasonsmod.mixin;

import ch.taeko.tcseasonsmod.TCWeatherMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.util.math.MathHelper;

@Mixin(Biome.class)
public class BiomeMixin {

    /**
     * @author Taeko
     * @reason Overwrite vanilla, biome dependent/static temperatures.
     */
    @Overwrite
    public float getTemperature() {
        return (float) TCWeatherMod.currentTemperature;
    }

    /**
     * @author Taeko
     * @reason Overwrite precipitation based on TCWeatherMod temperature
     */
    @Overwrite
    public Biome.Precipitation getPrecipitation(BlockPos pos) {
        return TCWeatherMod.currentTemperature > 0.2
                ? Biome.Precipitation.RAIN
                : Biome.Precipitation.SNOW;
    }

    /**
     * @author colinarelliott
     * @reason Server-side fallback for grass color, mimicking vanilla style
     */
    @Overwrite
    private int getDefaultGrassColor() {
        double temp = MathHelper.clamp(TCWeatherMod.currentTemperature, 0.0, 1.0);
        double downfall = MathHelper.clamp(TCWeatherMod.currentDownfall, 0.0, 1.0);

        // Vanilla-inspired formula: greener with moderate temp, slightly darker with low downfall
        int r = (int) (64 + 80 * temp);         // red component
        int g = (int) (160 + 50 * downfall);    // green component
        int b = (int) (64 + 32 * temp);         // blue component

        return (r << 16) | (g << 8) | b;
    }

    /**
     * @author colinarelliott
     * @reason Server-side fallback for foliage color, mimicking vanilla style
     */
    @Overwrite
    private int getDefaultFoliageColor() {
        double temp = MathHelper.clamp(TCWeatherMod.currentTemperature, 0.0, 1.0);
        double downfall = MathHelper.clamp(TCWeatherMod.currentDownfall, 0.0, 1.0);

        // Vanilla-inspired foliage: medium green, slightly darker in low temperature/downfall
        int r = (int) (70 + 50 * temp);
        int g = (int) (120 + 60 * downfall);
        int b = (int) (60 + 20 * temp);

        return (r << 16) | (g << 8) | b;
    }
}
