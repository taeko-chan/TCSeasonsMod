package ch.taeko.tcweathermod.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Biome.class)
public class WeatherMixin {
    /**
     * @author Taeko
     * @reason Fuck snow
     */
    @Overwrite
    public Biome.Precipitation getPrecipitation() {
        return Biome.Precipitation.RAIN;
    }
    /**
     * @author Taeko
     * @reason Summer is nice
     */
    @Overwrite
    public float getTemperature() {
        return 0.5F;
    }
}
