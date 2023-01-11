package net.keegancuff.weaponenchant.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.data.ConfigOptions;
import net.keegancuff.weaponenchant.WeaponEnchantMod;

public class WeaponEnchantConfig extends Config {

    @ConfigEntry(comment = "Allows axes to get all weapon enchantments")
    private boolean axeWeapon = true;
    @ConfigEntry(comment = "Requires axeWeapon = true\nAllows axes to get weapon enchantments out of the enchanting table.")
    private boolean axeWeaponInTable = true;
    @ConfigEntry(comment = "Allows tridents to get all weapon enchantments")
    private boolean tridentWeapon = true;
    @ConfigEntry(comment = "Requires tridentWeapon = true\nAllows axes to get weapon enchantments out of the enchanting table.")
    private boolean tridentWeaponInTable = true;

    public WeaponEnchantConfig() {
        super(ConfigOptions.mod(WeaponEnchantMod.MOD_ID));
    }

    public boolean isAxeWeaponInTable() {
        return axeWeaponInTable;
    }

    public boolean isTridentWeaponInTable() {
        return tridentWeaponInTable;
    }

    public boolean isAxeWeapon() {
        return axeWeapon;
    }

    public boolean isTridentWeapon() {
        return tridentWeapon;
    }
}
