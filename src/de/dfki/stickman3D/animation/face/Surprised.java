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
 * @author Beka
 */
public class Surprised extends AnimationStickman3D {

  public Surprised() {
    mAnimType = ANIMTYPE.ON;
  }

  public Surprised(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // surprised
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SURPRISED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "SURPRISED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SURPRISED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "SURPRISED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SURPRISED"));
    playAnimationPart(duration);
    pauseAnimation(1200);

    // no surprised
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SURPRISEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SURPRISEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SURPRISEDEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
