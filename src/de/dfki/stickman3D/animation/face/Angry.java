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
 * An angry facial movement is created in this class. The face moves from the default state to the
 * angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry extends AnimationStickman3D {

  /**
   * @param sm StickmanSwing
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */
  public Angry() {
    mAnimType = ANIMTYPE.ON;
  }

  public Angry(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    // angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(1000);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
