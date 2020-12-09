package me.travis.wurstplus.wurstplustwo.hacks.misc;

import com.mojang.authlib.GameProfile;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.util.UUID;

public class TwoBored2Wait2 extends WurstplusHack {
    public TwoBored2Wait2() {
        super(WurstplusCategory.WURSTPLUS_MISC);
        this.name = "Client Side Creative";
        this.tag = "ClientSideCreative";
        this.description = "makes your gamemode creative in client side";
    }

    @Override
    public void update() {
        if (mc.player==null || mc.playerController==null) return;
        if(!mc.playerController.getCurrentGameType().equals(GameType.CREATIVE)) {
            mc.playerController.setGameType(GameType.CREATIVE);
            mc.player.setGameType(GameType.CREATIVE);
        }
    }

    @Override
    protected void enable() {
        if (mc.player==null || mc.playerController==null) return;
        mc.playerController.setGameType(GameType.CREATIVE);
        mc.player.setGameType(GameType.CREATIVE);
    }
    public void disable() {
        if (mc.player==null || mc.playerController==null) return;
        if(!mc.playerController.getCurrentGameType().equals(GameType.SURVIVAL)) {
            mc.playerController.setGameType(GameType.SURVIVAL);
            mc.player.setGameType(GameType.SURVIVAL);
    }  
  }
}