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
public class AngryStart extends AnimationSwing {

  public AngryStart(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "ANGRY"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "ANGRY"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "ANGRY"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mFaceWrinkle, "shape",
            "ANGRY"));   ///Add by Robbie
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "ANGRY"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "ANGRY"));
//		playAnimationPart(20);
    playAnimationPart(duration);
    pauseAnimation(10);
  }
}
