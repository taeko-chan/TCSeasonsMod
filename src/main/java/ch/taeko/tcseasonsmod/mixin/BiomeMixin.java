package ch.taeko.tcseasonsmod.mixin;

import ch.taeko.tcseasonsmod.TCWeatherMod;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.util.math.MathHelper;
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

    /**
     * @author Taeko
     * @reason Use new temperature and downfall
     */
    @Overwrite
    private int getDefaultGrassColor() {
        double d = MathHelper.clamp(TCWeatherMod.currentTemperature, 0.0F, 1.0F);
        double e = MathHelper.clamp(TCWeatherMod.currentDownfall, 0.0F, 1.0F);
        return GrassColors.getColor(d, e);
    }

    /**
     * @author Taeko
     * @reason Use new temperature and downfall
     */
    @Overwrite
    private int getDefaultFoliageColor() {
        double d = MathHelper.clamp(TCWeatherMod.currentTemperature, 0.0F, 1.0F);
        double e = MathHelper.clamp(TCWeatherMod.currentDownfall, 0.0F, 1.0F);
        return FoliageColors.getColor(d, e);
    }

}
