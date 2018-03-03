/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the default state to the
 * angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry extends AnimationStickmanFX {

  /**
   * @param sm StickmanSwing
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */
  public Angry() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Angry(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    // angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
    animationContents.add(
        new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
    animationContents.add(
        new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
    playAnimationPart(20);
  }
}
