package net.keegancuff.weaponenchant.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Shadow
    public EnchantmentTarget type;

    @Inject(at = @At("HEAD"), method = "isAcceptableItem", cancellable = true)
    protected void weaponFix(ItemStack item, CallbackInfoReturnable<Boolean> info) {
        if (type.equals(EnchantmentTarget.WEAPON) && !((Object)this instanceof SweepingEnchantment)){
            info.setReturnValue (item.getItem() instanceof SwordItem || item.getItem() instanceof AxeItem || item.getItem() instanceof TridentItem);
            info.cancel();
        }
    }
}
