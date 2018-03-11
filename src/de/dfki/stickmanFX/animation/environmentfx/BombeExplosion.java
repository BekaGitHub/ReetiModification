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
import javafx.application.Platform;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class BombeExplosion extends AnimationStickmanFX {

  public BombeExplosion(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickmanFX = sm;
  }

  @Override
  public void playAnimation() {
    int translationUnit = 8;
    int rotationUnit = 10;

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBETRANSITION"));
    playAnimationPart(duration);

    // headTilt
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));

    // embarrassed
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape",
            "EMBARRASSED"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
    playAnimationPart(duration);

    pauseAnimation(2000);

    //end HeadTilt
    animationContents = new ArrayList<>();
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
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", -translationUnit));

    //change embarrassed with angry
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "SURPRISED"));
    playAnimationPart(duration);

    pauseAnimation(1000);

    //Blink
    for (int i = 0; i < 3; i++) {
      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
      animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
      animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
      playAnimationPart(100);

      pauseAnimation(300);

      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
      playAnimationPart(100);

    }

    pauseAnimation(1500);

    // headTilt
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
    } else {
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
    }

    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));
    // embarrassed
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape",
            "EMBARRASSED"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
    playAnimationPart(duration);

    //playAnimationPart(duration);
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit * 2));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
    playAnimationPart(duration);

    for (int i = 0; i < 3; i++) {
      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -rotationUnit));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", -rotationUnit * 3));
      playAnimationPart(200);

      pauseAnimation(150);

      animationContents = new ArrayList<>();
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit));
      animationContents
          .add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
      playAnimationPart(200);
    }

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBEEXPLOSION"));
    playAnimationPart(duration);

    //mStickmanSwing.mBodyFX.currentColor = Color.BLACK;
    Platform.runLater(() -> mStickmanFX.mBodyFX.paintFrontOrientation(Color.BLACK));
    mStickmanFX.mHeadFX.color = Color.BLACK;

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "DEFAULT"));
    playAnimationPart(20);

    mStickmanFX.mLeftHandFX.setVisible(false);
    mStickmanFX.mLeftForeArmFX.setVisible(false);
    mStickmanFX.mLeftUpperArmFX.setVisible(false);

    mStickmanFX.mRightHandFX.setVisible(false);
    mStickmanFX.mRightForeArmFX.setVisible(false);
    mStickmanFX.mRightUpperArmFX.setVisible(false);

    mStickmanFX.mRightShoulderFX.setVisible(false);
    mStickmanFX.mLeftShoulderFX.setVisible(false);
    mStickmanFX.mNeckFX.setVisible(false);
    mStickmanFX.mLeftEyebrowFX.setVisible(false);
    mStickmanFX.mRightEyebrowFX.setVisible(false);
    mStickmanFX.mMouthFX.setVisible(false);
    mStickmanFX.mFaceWrinkleFX.setVisible(false);

    animationContents = new ArrayList<>();
    mStickmanFX.mHeadFX.translateRight = true;
    animationContents.add(new AnimationContentFX(mStickmanFX.mHeadFX, "Translate", -2000));
    if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
      animationContents.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "Translate", -2000));
    } else {
      animationContents.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "Translate", -2000));
    }
    mStickmanFX.mBodyFX.setVisible(false);
    playAnimationPart(duration);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", 90));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "translate", 100));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 70));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "translate", 120));
    playAnimationPart(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 90));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "translate", 155));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 120));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "translate", 160));
    playAnimationPart(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", 90));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", 170));
    playAnimationPart(100);

    mStickmanFX.mLeftEyeFX.setVisible(false);
    mStickmanFX.mRightEyeFX.setVisible(false);

  }
}
