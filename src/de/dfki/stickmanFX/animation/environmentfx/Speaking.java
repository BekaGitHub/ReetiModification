/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleFX;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Speaking extends AnimationStickmanFX {

  public Speaking(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (parameter instanceof String) {
      mStickmanFX.mSpeechBubbleFX.mText = (String) parameter;
    }

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape",
            SpeechBubbleFX.SHAPE.SPEAK.name()));
    playAnimationPart(duration);

    animationContents
        .add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape",
            SpeechBubbleFX.SHAPE.DEFAULT.name()));
    playAnimationPart(20);

  }
}
