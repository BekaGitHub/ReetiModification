/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeIn extends AnimationStickmanFX {

  private StickmanFX mStickmanFX;

  public FadeIn(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickmanFX = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
//		star fade in
    mStickmanFX.starShowControler = true;
    mStickmanFX.starShowC = true;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
    playAnimationPart(1000);

//		character fade in
    mStickmanFX.starShowControler = false;
    mStickmanFX.setCharacterInvisible = true;
    mStickmanFX.fadeControler = false;

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "shape", "DEFAULT"));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "shape", "DEFAULT"));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "shape", "DEFAULT"));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mNeckFX, "shape", "DEFAULT"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightShoulderFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "shape", "DEFAULT"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "shape", "DEFAULT"));
    //animationContents.add(new AnimationContent3D(mStickmanSwing.mRightLegFX, "shape", "DEFAULT"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
    //animationContents.add(new AnimationContent3D(mStickmanSwing.mLeftLegFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
    playAnimationPart(1000);
    mStickmanFX.setCharacterInvisible = false;

//		stars fade out
    mStickmanFX.starShowC = true;
    mStickmanFX.setCharacterInvisible = false;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
    playAnimationPart(500);

    // bring upper arm and fore arm in position
    int rotationUnit = 10;
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 16));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 16));
    playAnimationPart(200);
    pauseAnimation(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
    playAnimationPart(100);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
    playAnimationPart(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
    playAnimationPart(100);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
    playAnimationPart(100);
    pauseAnimation(200);

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
    playAnimationPart(20);

    mStickmanFX.setCharacterInvisible = false;
    mStickmanFX.starShowControler = false;
    mStickmanFX.starShowC = false;

  }
}
