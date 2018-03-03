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
 * @author Patrick Gebhard
 */
public class Nod extends AnimationStickmanFX {

  public Nod(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int translationUnit = 3;

    // head down
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", translationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", translationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
    }

    animationContents
        .add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", translationUnit));
    playAnimationPart(200);

    // head up
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", -translationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
    }

    animationContents
        .add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", -translationUnit));

    playAnimationPart(200);
  }
}
