package ch.taeko.tcweathermod.mixin;

import ch.taeko.tcweathermod.TCSeason;
import ch.taeko.tcweathermod.TCWeatherMod;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Biome.class)
public class BiomeMixin {

    /**
     * @author Taeko
     * @reason Fuck snow
     */
    /*
    @Overwrite
    public Biome.Precipitation getPrecipitation() {

        TCSeason.Season currentSeason = TCSeason.getCurrentSeason(dayOfYear);

        switch (currentSeason) {
            case WINTER -> { return Biome.Precipitation.SNOW;}
            default -> { return Biome.Precipitation.RAIN;}
        }

    }*/
    /**
     * @author Taeko
     * @reason Overwrite vanilla, biome dependent temperatures.
     */
    @Overwrite
    public float getTemperature() {
        return (float)TCWeatherMod.currentTemperature;
    }
}
