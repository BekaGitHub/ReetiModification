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
public class Contempt extends AnimationSwing {

  public Contempt() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Contempt(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // Contempt
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "CONTEMPT"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "CONTEMPT"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "CONTEMPT"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no Contempt
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "CONTEMPTEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "CONTEMPTEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "CONTEMPTEND"));
    playAnimationPart(20);
  }
}
