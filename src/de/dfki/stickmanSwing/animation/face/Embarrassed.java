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
public class Embarrassed extends AnimationSwing {

  public Embarrassed() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Embarrassed(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // embarrassed
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mFaceWrinkle, "shape",
            "EMBARRASSED"));   ///Add by Robbie
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "EMBARRASSED"));
    playAnimationPart(duration);
//		playAnimationPart(20);

    pauseAnimation(1200);

    // no embarrassed
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mFaceWrinkle, "shape",
            "EMBARRASSEDEND"));   ///Add by Robbie
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "EMBARRASSEDEND"));
    playAnimationPart(20);
  }
}
