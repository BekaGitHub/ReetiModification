/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class FearEnd extends AnimationSwing {

  public FearEnd(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // fear end
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "FEAREND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "DISGUSTEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
