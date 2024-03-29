package ch.taeko.tcseasonsmod.mixin;

import ch.taeko.tcseasonsmod.TCWeatherMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.block.Block.dropStacks;

@Mixin(SnowBlock.class)
public class SnowMixin {

    /**
     * @author Taeko
     * @reason Snow melts naturally
     */
    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (TCWeatherMod.currentTemperature > 0.2 || world.getLightLevel(LightType.BLOCK, pos) > 5) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }
}
