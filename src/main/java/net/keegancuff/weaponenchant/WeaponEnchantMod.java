package net.keegancuff.weaponenchant;

import net.fabricmc.api.ModInitializer;
import net.keegancuff.weaponenchant.config.Configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeaponEnchantMod implements ModInitializer {
	public static final String MOD_ID = "weaponenchant";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Configs.loadConfigs();
	}
}
