package me.travis.wurstplus.wurstplustwo.hacks.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusFriendUtil;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;

import java.util.HashMap;


public class WurstplusTotempop extends WurstplusHack {
    
    public WurstplusTotempop() {
		super(WurstplusCategory.WURSTPLUS_CHAT);

		this.name        = "Totem Pop Counter";
		this.tag         = "TotemPopCounter";
		this.description = "dude idk cb+ is just outdated";
    }

    public static final HashMap<String, Integer> totem_pop_counter = new HashMap<String, Integer>();
    
    public static ChatFormatting red = ChatFormatting.RED;
    public static ChatFormatting green = ChatFormatting.GREEN;
    public static ChatFormatting gold = ChatFormatting.GOLD;
    public static ChatFormatting grey = ChatFormatting.GRAY;
    public static ChatFormatting bold = ChatFormatting.BOLD;
    public static ChatFormatting reset = ChatFormatting.RESET;
    public static ChatFormatting aqua = ChatFormatting.AQUA;

    @EventHandler
    private final Listener<WurstplusEventPacket.ReceivePacket> packet_event = new Listener<>(event -> {

        if (event.get_packet() instanceof SPacketEntityStatus) {

            SPacketEntityStatus packet = (SPacketEntityStatus) event.get_packet();

            if (packet.getOpCode() == 35) {

                Entity entity = packet.getEntity(mc.world);

                int count = 1;

                if (totem_pop_counter.containsKey(entity.getName())) {
                    count = totem_pop_counter.get(entity.getName());
                    totem_pop_counter.put(entity.getName(), ++count);
                } else {
                    totem_pop_counter.put(entity.getName(), count);
                }

                if (entity == mc.player) return;

                if (WurstplusFriendUtil.isFriend(entity.getName())) {
                    WurstplusMessageUtil.send_client_message( aqua + "" + bold + " Totem Pop Notfier " + reset + red + "  " + reset + " " + bold + green + entity.getName() + reset + " has popped " + bold + count + reset + " totems. help him");
                } else {
                    WurstplusMessageUtil.send_client_message( aqua + "" + bold + " Totem Pop Notifier " + reset + red + "  " + bold + red + entity.getName() + reset + " has popped " + bold + count + reset + " totems.");
                }

            }

        }

    });

    @Override
	public void update() {
        
        for (EntityPlayer player : mc.world.playerEntities) {

            if (!totem_pop_counter.containsKey(player.getName())) continue;

            if (player.isDead || player.getHealth() <= 0) {

                int count = totem_pop_counter.get(player.getName());

                totem_pop_counter.remove(player.getName());

                if (player == mc.player) continue;

                if (WurstplusFriendUtil.isFriend(player.getName())) {
                    WurstplusMessageUtil.send_client_message( aqua + "" + bold + " Totem Pop Notifier " + player.getName() + reset + " died after popping " + bold + count + reset + " totems.");
                } else {
                    WurstplusMessageUtil.send_client_message( aqua + "" + bold + " Totem Pop Notifier " + red + player.getName() + reset + " died after popping " + bold + count + reset + " totems");
                }

            }

        }

	}

}