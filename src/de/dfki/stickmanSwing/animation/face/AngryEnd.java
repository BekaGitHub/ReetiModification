/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the angry state to the
 * default state, and stays in the default state until it receives a new command.
 *
 * @author Patrick Gebhard
 */
public class AngryEnd extends AnimationSwing {

  /**
   * @param sm StickmanSwing
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */
  public AngryEnd(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    // angry end
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mFaceWrinkle, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "ANGRYEND"));
//		playAnimationPart(20);
    playAnimationPart(duration);

    pauseAnimation(10);

  }
}
