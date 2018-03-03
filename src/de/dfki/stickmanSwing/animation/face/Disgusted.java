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
public class Disgusted extends AnimationSwing {

  public Disgusted() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Disgusted(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // disgusted
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "DISGUSTED"));
//		playAnimationPart(20);
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no disgusted
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "DISGUSTEDEND"));
    playAnimationPart(20);
  }
}
