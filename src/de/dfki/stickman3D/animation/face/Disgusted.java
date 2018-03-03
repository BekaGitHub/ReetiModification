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
public class Disgusted extends AnimationStickman3D {

  public Disgusted() {
    mAnimType = ANIMTYPE.ON;
  }

  public Disgusted(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // disgusted
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "DISGUSTED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no disgusted
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "DISGUSTEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "DISGUSTEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "DISGUSTEDEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
