package com.example.mixin;

import com.example.ExampleMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/player/PlayerEntity;isBlockBreakingRestricted(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/GameMode;)Z", cancellable = true)
	private void init(World world, BlockPos pos, GameMode gameMode, CallbackInfoReturnable<Boolean> cir) {
		ExampleMod.LOGGER.info("Restricting break");
		cir.setReturnValue(true);
	}
}