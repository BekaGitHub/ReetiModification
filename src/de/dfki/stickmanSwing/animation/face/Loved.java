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
public class Loved extends AnimationSwing {

  public Loved() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Loved(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // loved
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SMILE"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "LOVED"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "LOVED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no loved
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SMILEEND"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "LOVEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "LOVEDEND"));
    playAnimationPart(20);
  }
}
