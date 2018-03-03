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
public class Sad extends AnimationSwing {

  public Sad() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Sad(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // sad
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SAD"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape",
            "DISGUSTED"));  // add by Robbie
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape",
            "DISGUSTED")); // add by Robbie
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no sad
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SADEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape",
            "DISGUSTEDEND"));  // add by Robbie
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape",
            "DISGUSTEDEND")); // add by Robbie
    playAnimationPart(20);
  }
}
