/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeOut extends AnimationStickman3D {

  public FadeOut() {
    mAnimType = ANIMTYPE.ON;
  }

  public FadeOut(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman3D = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mStars, "shape", "STARSFADEIN"));
    playAnimationPart(500);

    pauseAnimation(500);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mNose, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEar, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEar, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "shape", "FADEOUT"));
    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mMaleHair, "shape", "FADEOUT"));
    }
    animationContents.add(new AnimationContent3D(mStickman3D.mNeck, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mDownBody, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "shape", "FADEOUT"));

    animationContents.add(new AnimationContent3D(mStickman3D.mStars, "shape", "STARSFADEOUT"));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger2, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "shape", "FADEOUT"));
    if (mStickman3D.mType == Gender.TYPE.FEMALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mFemaleHair, "shape", "FADEOUT"));
    }
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperLeg, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeLeg, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFoot, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperLeg, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeLeg, "shape", "FADEOUT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFoot, "shape", "FADEOUT"));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
