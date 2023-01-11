package net.keegancuff.weaponenchant.mixin;

import net.keegancuff.weaponenchant.config.Configs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
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
        if (type.equals(EnchantmentTarget.WEAPON)){
            info.setReturnValue (item.getItem() instanceof SwordItem ||
                    Configs.CONFIG.isAxeWeapon() && item.getItem() instanceof AxeItem ||
                    Configs.CONFIG.isTridentWeapon() && item.getItem() instanceof TridentItem);
            info.cancel();
        }
    }
}
