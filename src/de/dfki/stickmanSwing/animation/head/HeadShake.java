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
public class HeadShake extends AnimationSwing {

  public HeadShake(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int rotationUnit = 10;

    // Its action is strange for the first time!
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "rotate", -rotationUnit));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mHead, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "rotate", -rotationUnit));
    playAnimationPart(200);
    pauseAnimation(100);

    // shaking head 5 times from Robbie
    for (int i = 0; i < 3; i++) {
      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mHead, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mMouth, "rotate", rotationUnit * 2));
      playAnimationPart(200);
      pauseAnimation(100);

      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "rotate", -rotationUnit * 2));
      animationContents
          .add(
              new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mHead, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentSwing(mStickmanSwing.mMouth, "rotate", -rotationUnit * 2));
      playAnimationPart(200);
      pauseAnimation(100);
    }

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "rotate", rotationUnit));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mHead, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "rotate", rotationUnit));

    playAnimationPart(200);
    pauseAnimation(100);

  }

}
