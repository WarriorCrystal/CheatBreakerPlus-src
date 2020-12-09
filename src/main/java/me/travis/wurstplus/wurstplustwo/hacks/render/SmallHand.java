package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class SmallHand extends WurstplusHack {
	WurstplusSetting offset = create("Offset", "SmallHandOffset", 90, 0, 360);

	public SmallHand() {
		super(WurstplusCategory.WURSTPLUS_RENDER);

		this.name        = "Small Hand";
		this.tag         = "SmallHand";
		this.description = "Small hand in game.";

	}

	@Override
	public void update() {
		mc.player.renderArmPitch = offset.get_value(1);
	}
}
