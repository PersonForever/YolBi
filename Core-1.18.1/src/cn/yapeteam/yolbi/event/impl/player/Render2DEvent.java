package cn.yapeteam.yolbi.event.impl.player;

import com.mojang.blaze3d.vertex.PoseStack;
import cn.yapeteam.yolbi.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.client.gui.ScaledResolution;

@Getter
@AllArgsConstructor
public class Render2DEvent extends Event {
    private float partialTicks;
    private ScaledResolution scaledResolution;
    private PoseStack poseStack;
}