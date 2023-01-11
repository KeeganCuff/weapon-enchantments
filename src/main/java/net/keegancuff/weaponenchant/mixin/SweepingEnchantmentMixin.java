package net.keegancuff.weaponenchant.mixin;

import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SweepingEnchantment.class)
public class SweepingEnchantmentMixin extends EnchantmentMixin{

    @Override
    protected void weaponFix(ItemStack item, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(this.type.isAcceptableItem(item.getItem()));
        info.cancel();
    }
}
