package me.travis.wurstplus.wurstplustwo.hacks.render;


import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.ZoriWrapper;



public class OffhandSwing extends WurstplusHack {

	public OffhandSwing() {
		

        super(WurstplusCategory.WURSTPLUS_RENDER);

        this.name = "Offhand Swing";
        this.tag = "OffhandSwing";
        this.description = "Swing your offhand instead of mainhand";
    }
	@Override
    public void update() {
        if (ZoriWrapper.mc.world == null) {
            return;
        }
        ZoriWrapper.getPlayer().swingingHand = EnumHand.OFF_HAND;
    }
}
