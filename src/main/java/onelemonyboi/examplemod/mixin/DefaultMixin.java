package onelemonyboi.examplemod.mixin;

import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;

@Mixin(SplashScreen.class)
public class DefaultMixin {
    @Inject(method = "getSize", at = @At("HEAD"), cancellable = true)
    public void size(CallbackInfoReturnable<ResourceLocation> cir) {

    }
}