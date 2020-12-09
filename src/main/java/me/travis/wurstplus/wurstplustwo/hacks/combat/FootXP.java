package me.travis.wurstplus.wurstplustwo.hacks.combat;

import java.util.function.Predicate;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import me.zero.alpine.fork.listener.EventHandler;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.Listener;

public class FootXP extends WurstplusHack
{
   
	
	@EventHandler
    public Listener<WurstplusEventPacket.SendPacket> listener;
	
    
    public FootXP() {

        super(WurstplusCategory.WURSTPLUS_COMBAT);

        this.name = "Feet Experience";
        this.tag = "FeetExperience";
        this.description = "Throw xp to your feet";
        
    
    
        this.listener = new Listener<WurstplusEventPacket.SendPacket>(event -> {
            if (event.get_packet() instanceof CPacketPlayerTryUseItem && this.mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle) {
                this.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(this.mc.player.rotationYaw, 90.0f, this.mc.player.onGround));
            }
        }, (Predicate<WurstplusEventPacket.SendPacket>[])new Predicate[0]);
    }
}
