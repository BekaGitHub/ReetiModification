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
 * @author Beka
 */
public class Sad extends AnimationStickmanFX {

  public Sad() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Sad(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // sad
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SAD"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape",
            "DISGUSTED"));  // add by Robbie
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape",
            "DISGUSTED")); // add by Robbie
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no sad
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SADEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape",
            "DISGUSTEDEND"));  // add by Robbie
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape",
            "DISGUSTEDEND")); // add by Robbie
    playAnimationPart(20);
  }
}
