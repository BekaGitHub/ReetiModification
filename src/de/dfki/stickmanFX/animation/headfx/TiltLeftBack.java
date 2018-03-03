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
public class TiltLeftBack extends AnimationStickmanFX {

  public TiltLeftBack(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int translationUnit = 8;

    // head down
    animationContents = new ArrayList<>();
    // which bodyparts are involved - check dependencies
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", -translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", -translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", -translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", -translationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", -translationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", -translationUnit));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", -translationUnit));

    playAnimationPart(200);
  }
}
