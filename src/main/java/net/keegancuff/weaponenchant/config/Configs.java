package net.keegancuff.weaponenchant.config;

public class Configs {
    public static final WeaponEnchantConfig CONFIG = new WeaponEnchantConfig();

    public static void loadConfigs(){
        CONFIG.load();
    }
}
