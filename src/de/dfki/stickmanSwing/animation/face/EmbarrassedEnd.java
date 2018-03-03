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
public class EmbarrassedEnd extends AnimationSwing {

  public EmbarrassedEnd(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // embarrassed end
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mFaceWrinkle, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "EMBARRASSEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
