package ch.taeko.tcseasonsmod;

import net.minecraft.world.biome.Biome;

public class TCBiomeHelper {

    /**
     * Returns the current temperature according to TCWeatherMod.
     */
    public static float getTemperature(Biome biome) {
        // Optionally, you could factor biome.getTemperature() if you want
        return (float) TCWeatherMod.currentTemperature;
    }

    /**
     * Returns the current precipitation type according to TCWeatherMod.
     */
    public static Biome.Precipitation getPrecipitation(Biome biome) {
        return TCWeatherMod.currentTemperature > 0.2
                ? Biome.Precipitation.RAIN
                : Biome.Precipitation.SNOW;
    }
}
