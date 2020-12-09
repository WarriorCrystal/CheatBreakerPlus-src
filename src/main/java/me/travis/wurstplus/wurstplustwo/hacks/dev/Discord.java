package me.travis.wurstplus.wurstplustwo.hacks.dev;


import net.minecraft.util.Util;
import java.awt.Desktop;
import java.net.URI;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusModuleManager;


public class Discord extends WurstplusHack {
    public Discord() {
        super(WurstplusCategory.WURSTPLUS_BETA);

        this.name        = "Discord";
        this.tag         = "Discord";
        this.description = "Discord invite";
   }
    
    @Override
    public void enable()
    {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://discord.gg/hR595WRHww"));
            }
        } catch (Exception e) {e.printStackTrace();}
    }

}


