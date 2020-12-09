package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.ZoriWrapper;

public class SwingAnimFix extends WurstplusHack {
	
	public SwingAnimFix() {
		

        super(WurstplusCategory.WURSTPLUS_RENDER);

        this.name = "Swing Anim Fix";
        this.tag = "SwingAnimFix";
        this.description = "pasted from zori lol";
    }
	@Override
    public void update() {
        if (ZoriWrapper.getPlayer() == null) {
            return;
        }
        if (ZoriWrapper.mc.entityRenderer.itemRenderer.equippedProgressMainHand < 1.0f) {
            ZoriWrapper.mc.entityRenderer.itemRenderer.equippedProgressMainHand = 1.0f;
        }
        if (ZoriWrapper.mc.entityRenderer.itemRenderer.itemStackMainHand != ZoriWrapper.getPlayer().getHeldItemMainhand()) {
            ZoriWrapper.mc.entityRenderer.itemRenderer.itemStackMainHand = ZoriWrapper.getPlayer().getHeldItemMainhand();
        }
    }
}


