package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ClientSideSpeed extends WurstplusHack {
	
	WurstplusSetting speed = create("Speed", "CSPSpeed", 1, 0, 5);
	
	public ClientSideSpeed() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.name = "Client Side Speed";
        this.tag = "ClientSideSpeed";
        this.description = "gives speed potion effect client side";
  }
    public void enable() {
        final PotionEffect effect = new PotionEffect(Potion.getPotionById(1), 123456789, speed.get_value(1));
        effect.setPotionDurationMax(true);
        ClientSideSpeed.mc.player.addPotionEffect(effect);
    }
    public void disable() {
        ClientSideSpeed.mc.player.removePotionEffect(Potion.getPotionById(1));
  }
}
