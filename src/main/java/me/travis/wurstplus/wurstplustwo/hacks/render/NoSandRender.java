//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.render;

import java.util.Iterator;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.Entity;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class NoSandRender extends WurstplusHack
{
    public NoSandRender() {
        super(WurstplusCategory.WURSTPLUS_RENDER);
        this.name = "No Sand Render";
        this.tag = "NoSandRender";
        this.description = "allows you to drop FPS of other players but not you";
    }
    
    @Override
    public void update() {
        for (final Entity e : NoSandRender.mc.world.loadedEntityList) {
            if (e instanceof EntityFallingBlock) {
                NoSandRender.mc.world.removeEntity(e);
            }
        }
    }
}
