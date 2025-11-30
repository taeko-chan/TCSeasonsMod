package ch.taeko.tcseasonsmod.mixin;

import ch.taeko.tcseasonsmod.TCWeatherMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(IceBlock.class)
public class IceMixin {

    /**
     * @author Taeko
     * @reason Fuck Ice
     * @comment Yeah, seriously. - Colin
     */
    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (TCWeatherMod.currentTemperature > 0.2) {
            this.melt(state, world, pos);
        }
    }

    protected void melt(BlockState state, ServerWorld world, BlockPos pos) {
        // Check if dimension is ultrawarm (Nether)
        if (world.getRegistryKey() == World.NETHER) {
            world.removeBlock(pos, false);
        } else {
            // Replace ice with water (neighbor updates are automatic on the server)
            world.setBlockState(pos, Blocks.WATER.getDefaultState(), 3);
        }
    }
}
