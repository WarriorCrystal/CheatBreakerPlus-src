package me.travis.wurstplus.wurstplustwo.util;



import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import javax.annotation.Nullable;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.Minecraft;





public class ZoriWrapper 
	{
	    public static final Minecraft mc;
	    
	    @Nullable
	    public static EntityPlayerSP getPlayer() {
	        return ZoriWrapper.mc.player;
	    }
	    
	    @Nullable
	    public static WorldClient getWorld() {
	        return ZoriWrapper.mc.world;
	    }
	    
	    public static FontRenderer getFontRenderer() {
	        return ZoriWrapper.mc.fontRenderer;
	    }
	    
	    static {
	        mc = Minecraft.getMinecraft();
	    }
	}