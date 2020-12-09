package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class FullBright extends WurstplusHack {
	float old_gamme_value;	

	public FullBright() {
		super(WurstplusCategory.WURSTPLUS_RENDER);

		// Info.
		this.name        = "Brightness";
		this.tag         = "Brightness";
		this.description = "Set full gamma.";
	}

	@Override
	public void disable() {
		mc.gameSettings.gammaSetting -= 1000;
	}

	@Override
	public void enable() {
		mc.gameSettings.gammaSetting += 1000;
	}
}
