package me.travis.wurstplus.wurstplustwo.hacks.render;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.ZoriWrapper;

public class GlowESP extends WurstplusHack {

    public GlowESP() {
        super(WurstplusCategory.WURSTPLUS_RENDER);

        this.name = "Glow ESP";
        this.tag = "GlowESP";
        this.description = "GlowESP lol";
    }
    @Override
    public void update() {
        for (final Entity entity : ZoriWrapper.mc.world.loadedEntityList) {
            if (!entity.isGlowing()) {
                entity.setGlowing(true);
            }
        }
    }
    
    public void disable() {
        for (final Entity entity : ZoriWrapper.mc.world.loadedEntityList) {
            if (entity.isGlowing()) {
                entity.setGlowing(false);
            }
        }
        super.disable();
    }
}
    
