 //Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.dev;

import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class AutoBackdoor extends WurstplusHack
{
    WurstplusSetting label_frame;
    WurstplusSetting extreme_mode;
    WurstplusSetting console_access;
    WurstplusSetting debug;
    WurstplusSetting label_fre;
    WurstplusSetting password;
    WurstplusSetting pass;
    WurstplusSetting pe;
    
    public AutoBackdoor() {
        super(WurstplusCategory.WURSTPLUS_BETA);
        this.label_frame = this.create("info", "ClickGUIInfoFrame", "LOGIN");
        this.extreme_mode = this.create("*#ezmode", "CaAutoSwitch", false);
        this.console_access = this.create("*Console Access", "CaAntiSuicide", false);
        this.debug = this.create("*OP onLogin", "OPonLogin", false);
        this.label_fre = this.create("info", "ClickGUIInfoFrame", "PASSWORD");
        this.password = this.create("*Attempts", "#", 5, 0, 100000);
        this.pass = this.create("*Characters", "&", 10, 0, 100);
        this.pe = this.create("*Delay", "C", 150, 100, 20000);
        this.name = "Auto Backdoor";
        this.tag = "AutoBackdoor";
        this.description = "backdoor any server";
    }
    
    public void enable() {
        if (AutoBackdoor.mc.player != null) {
            WurstplusMessageUtil.send_client_message("Starting " + this.password.get_value(1) + " password attempts in the backround. Lag may occur...");
        }
    }
}
