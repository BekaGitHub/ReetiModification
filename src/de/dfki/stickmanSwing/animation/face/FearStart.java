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
public class FearStart extends AnimationSwing {

  public FearStart(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // fear start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "FEAR"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "DISGUSTED"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
