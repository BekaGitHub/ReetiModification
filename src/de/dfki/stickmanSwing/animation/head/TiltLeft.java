/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class TiltLeft extends AnimationSwing {

  public TiltLeft(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int translationUnit = 8;

    // head down
    animationContents = new ArrayList<>();
    // which bodyparts are involved - check dependencies
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mHead, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "tilt", translationUnit));

    playAnimationPart(200);
  }
}
