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
public class AngrySmallMouth extends AnimationStickman3D {

  public AngrySmallMouth() {
    mAnimType = ANIMTYPE.ON;
  }

  public AngrySmallMouth(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYSMALLMOUTH"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRY"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no angry
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYSMALLMOUTHEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRYEND"));
    animationContents.add(
        new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape", "ANGRYEND"));   ///Add by Robbie
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRYEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
