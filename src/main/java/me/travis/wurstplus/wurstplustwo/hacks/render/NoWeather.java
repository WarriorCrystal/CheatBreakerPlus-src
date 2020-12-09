package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class NoWeather extends WurstplusHack {
	
	
    public NoWeather() {
	
    super(WurstplusCategory.WURSTPLUS_RENDER);
    
	this.name        = "No Weather";
	this.tag         = "NoWeatger";
	this.description = "Disables weather render";
	
    }
	
    @Override
    public void update() {
        if (this.mc.world == null) {
            return;
        }
        if (this.mc.world.isRaining()) {
            this.mc.world.setRainStrength(0.0f);
        }
    }
}
