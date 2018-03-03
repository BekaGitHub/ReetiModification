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
 * @author Patrick Gebhard
 */
public class Surprised extends AnimationSwing {

  public Surprised() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Surprised(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // surprised
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "SURPRISED"));
//		playAnimationPart(20);duration
    playAnimationPart(duration);
    pauseAnimation(1200);

    // no surprised
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "SURPRISEDEND"));
    playAnimationPart(20);
  }
}
