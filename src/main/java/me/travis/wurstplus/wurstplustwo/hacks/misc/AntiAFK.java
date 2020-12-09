package me.travis.wurstplus.wurstplustwo.hacks.misc;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import me.travis.wurstplus.wurstplustwo.event.WurstplusEventBus;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;

import net.minecraftforge.client.event.ClientChatReceivedEvent;


public final class AntiAFK extends WurstplusHack
{
    public AntiAFK()
    {
        super(WurstplusCategory.WURSTPLUS_MISC);
        this.name = "Anti AFK";
        this.tag = "AntiAFK";
        this.description = "prevents from getting kicked";
    }
    
    
    WurstplusSetting delay = create("Delay", "AntiAFKDelay", 5, 0, 30);

    static String lastcode;

    @EventHandler
    private Listener<ClientChatReceivedEvent> listener = new Listener<>(event ->{
        if(event.getMessage().getUnformattedText().contains(lastcode))
            event.setCanceled(true);
    });

    long lastmsg = 0;

    public void onUpdate() {
        if (mc.player.ticksExisted%2!=0) return;

        if ( System.currentTimeMillis()-lastmsg >= (delay.get_value(1)*1000) ) {
            lastmsg = System.currentTimeMillis();
            lastcode = getRandomHexString(16);
            mc.player.sendChatMessage("/msg "+mc.player.getName()+" antiafk "+lastcode);
        }
    }

    public void enable(){
        WurstplusEventBus.EVENT_BUS.subscribe(this);
    }

    public void disable(){
        WurstplusEventBus.EVENT_BUS.unsubscribe(this);
    }

    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }
}

