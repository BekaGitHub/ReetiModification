/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class HeadShake extends AnimationStickmanFX {

  StickmanFX mStickmanFX;

  public HeadShake(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
    this.mStickmanFX = sm;
  }

  @Override
  public void playAnimation() {
    int rotationUnit = 10;

    // Its action is strange for the first time!
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -rotationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", -rotationUnit));
    playAnimationPart(200);
    pauseAnimation(100);

    // shaking head 5 times from Robbie
    for (int i = 0; i < 3; i++) {
      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", rotationUnit * 2));

      if (mStickmanFX.mType == Gender.TYPE.MALE) {
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", rotationUnit * 2));
      } else {
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit * 2));
      }

      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", rotationUnit * 2));
      playAnimationPart(200);
      pauseAnimation(100);

      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit * 2));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -rotationUnit * 2));

      if (mStickmanFX.mType == Gender.TYPE.MALE) {
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit * 2));
      } else {
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit * 2));
      }

      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", -rotationUnit * 2));
      playAnimationPart(200);
      pauseAnimation(100);
    }

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", rotationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", rotationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", rotationUnit));

    playAnimationPart(200);
    pauseAnimation(100);

  }

}
