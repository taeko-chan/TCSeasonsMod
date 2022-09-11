package ch.taeko.tcweathermod.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.block.Block.dropStacks;

@Mixin(SnowBlock.class)
public class SnowMixin {

    /**
     * @author Taeko
     * @reason FUck snow
     */
    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        dropStacks(state, world, pos);
        world.removeBlock(pos, false);
    }
}
