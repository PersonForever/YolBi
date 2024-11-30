package cn.yapeteam.yolbi.module.impl.combat;

import cn.yapeteam.loader.Natives;
import cn.yapeteam.yolbi.event.Listener;
import cn.yapeteam.yolbi.event.impl.render.EventRender2D;
import cn.yapeteam.yolbi.module.Module;
import cn.yapeteam.yolbi.module.ModuleCategory;
import cn.yapeteam.yolbi.module.values.impl.NumberValue;
import com.mojang.blaze3d.platform.InputConstants;
import cn.yapeteam.yolbi.utils.player.RotationUtilsBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;


public class FuckBed extends Module {
    public FuckBed(){
        super("OnlyBed", ModuleCategory.COMBAT, InputConstants.KEY_CAPSLOCK);
        addValues(range);
    }
    private NumberValue<Double> range = new NumberValue<Double>("MaxRange",5.5,0.1,6.1d,0.1d);
    @Listener
    public void FuckBedUpdate(EventRender2D e){
        if (mc.player == null||mc.level == null) {
            return;
        }
        BlockPos playerPos = mc.player.blockPosition();
        BlockPos bedPosition = findBedsAround(playerPos,range.getValue().intValue());
        if(bedPosition.getY() == 983978&&bedPosition.getX() == 983978&&bedPosition.getZ() == 983978){
            mc.gui.getChat().addMessage(new TextComponent("Return in null pos"));
            return;
        }
        float[] r = RotationUtilsBlock.getSimpleRotations(bedPosition.getX(),bedPosition.getY(),bedPosition.getZ());
        mc.player.setYBodyRot(r[0]);
        //breakBlock(bedPosition);
        breakBedsideBlock(bedPosition);
        if(GetRange(mc.player.blockPosition(),bedPosition)<=4.9){
            mc.player.setYRot(r[0]);
            mc.player.setXRot(r[1]);
            if(hasBlockAt(bedPosition)){
                Natives.SendLeft(true);
            }else{
                Natives.SendLeft(false);
            }
        }

    }
    private BlockPos findBedsAround(BlockPos center, int radius) {
        List<BlockPos> bedPositions = new ArrayList<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = mc.level.getBlockState(pos);
                    Block block = state.getBlock();
                    if (BlockTags.BEDS.contains(block)) {
                        bedPositions.add(pos);
                    }
                }
            }
        }
        int min = 911111111;
        BlockPos mi = new BlockPos(983978,983978,983978);
        BlockPos b = new BlockPos(mc.player.getX(),mc.player.getY(),mc.player.getZ());
        for(int i=0;i<bedPositions.size();i++){
            mc.gui.getChat().addMessage(new TextComponent("Find bed in "+ bedPositions.get(i).getX()+" " + bedPositions.get(i).getY() +" "+ bedPositions.get(i).getZ()));
            if(GetRange(bedPositions.get(i),b)<min){
                if(GetRange(bedPositions.get(i),b)<=range.getValue().doubleValue()){
                    mi = bedPositions.get(i);
                }
            }

        }

        return mi;
    }
    private void breakBedsideBlock(BlockPos centerPos){
        for (int x = -2; x <= 2; x++) {
                    BlockPos targetPos = centerPos.offset(x, 1, 0);
                    if (!targetPos.equals(centerPos)) {
                        if (hasBlockAt(targetPos)) {
                            breakBlock(targetPos);
                        }
                    }
        }

    }
    public boolean hasBlockAt( BlockPos pos) {
        if (mc.level == null) {
            return false;
        }
        BlockState blockState = null;
        blockState = mc.level.getBlockState(pos);
        return !blockState.isAir();
    }
    private void breakBlock(BlockPos pos) {
        Level world = mc.level;
        Block block = mc.level.getBlockState(pos).getBlock();
        mc.level.destroyBlock(pos,true);
        world.updateNeighborsAt(pos, block);
        world.updateNeighborsAt(pos.below(), block);
        mc.gui.getChat().addMessage(new TextComponent("DevLog:Break "+pos.toString()));
    }

    private double GetRange(BlockPos a,BlockPos b){
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) + Math.abs(a.getZ() - b.getZ());
    }
}
