/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Embarrassed extends AnimationStickman3D {

  public Embarrassed() {
    mAnimType = ANIMTYPE.ON;
  }

  public Embarrassed(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // embarrassed
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EMBARRASSED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape",
            "EMBARRASSED"));   ///Add by Robbie
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EMBARRASSED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no embarrassed
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EMBARRASSEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape",
            "EMBARRASSEDEND"));   ///Add by Robbie
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EMBARRASSEDEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
