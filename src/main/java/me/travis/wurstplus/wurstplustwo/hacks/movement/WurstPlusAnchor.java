package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.event.WurstplusEventBus;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.client.event.InputUpdateEvent;

import java.util.ArrayList;

public class WurstPlusAnchor extends WurstplusHack {

    // pasted lol

    public WurstPlusAnchor() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);

        this.name        = "Anchor Rewrite";
        this.tag         = "AnchorRewrite";
        this.description = "Stops all movement if player is above a hole";
    }

    private final BlockPos[] surroundOffset = {
            new BlockPos(0, -1, 0), // down
            new BlockPos(0, 0, -1), // north
            new BlockPos(1, 0, 0), // east
            new BlockPos(0, 0, 1), // south
            new BlockPos(-1, 0, 0) // west
    };

    @Override
    public void update() {
        for (int i=0;i<2;i++) {
            BlockPos pos = mc.player.getPosition().subtract(new Vec3i(0, i+1, 0));
            boolean isSafe = true;
            for (BlockPos offset : surroundOffset) {
                Block block = mc.world.getBlockState(pos.add(offset)).getBlock();
                if (block != Blocks.BEDROCK && block != Blocks.OBSIDIAN && block != Blocks.ENDER_CHEST && block != Blocks.ANVIL) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                mc.player.motionY--;
                mc.player.motionX = 0;
                mc.player.motionZ = 0;
                break;
            }
        }
    }

    public void enable(){
        WurstplusEventBus.EVENT_BUS.subscribe(this);
    }

    public void disable(){
        WurstplusEventBus.EVENT_BUS.unsubscribe(this);
    }
}
