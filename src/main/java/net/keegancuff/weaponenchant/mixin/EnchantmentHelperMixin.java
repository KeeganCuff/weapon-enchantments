package net.keegancuff.weaponenchant.mixin;

import com.google.common.collect.Lists;
import net.keegancuff.weaponenchant.config.Configs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(at = @At("HEAD"), method = "getPossibleEntries", cancellable = true)
    private static void tableFix(int power, ItemStack stack, boolean treasureAllowed, CallbackInfoReturnable<List<EnchantmentLevelEntry>> info){
        if (stack.getItem() instanceof AxeItem && Configs.CONFIG.isAxeWeapon() && Configs.CONFIG.isAxeWeaponInTable()||
        stack.getItem() instanceof TridentItem && Configs.CONFIG.isTridentWeapon() && Configs.CONFIG.isTridentWeaponInTable()){
            info.setReturnValue(getPossibleEntriesModified(power, stack, treasureAllowed));
            info.cancel();
        }
    }

    private static List<EnchantmentLevelEntry> getPossibleEntriesModified(int power, ItemStack stack, boolean treasureAllowed) {
        List<EnchantmentLevelEntry> list = Lists.newArrayList();
        Item item = stack.getItem();
        boolean bl = stack.isOf(Items.BOOK);
        Iterator var6 = Registries.ENCHANTMENT.iterator();

        while(true) {
            while(true) {
                Enchantment enchantment;
                do {
                    do {
                        do {
                            if (!var6.hasNext()) {
                                return list;
                            }

                            enchantment = (Enchantment)var6.next();
                        } while(enchantment.isTreasure() && !treasureAllowed);
                    } while(!enchantment.isAvailableForRandomSelection());
                } while(!enchantment.isAcceptableItem(item.getDefaultStack()) && !bl);

                for(int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
                    if (power >= enchantment.getMinPower(i) && power <= enchantment.getMaxPower(i)) {
                        list.add(new EnchantmentLevelEntry(enchantment, i));
                        break;
                    }
                }
            }
        }
    }

}
