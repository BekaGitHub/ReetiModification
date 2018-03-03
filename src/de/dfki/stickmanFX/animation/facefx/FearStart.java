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
 * @author Patrick Gebhard
 */
public class FearStart extends AnimationStickmanFX {

  public FearStart() {
    super();
  }

  public FearStart(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // fear
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FEAR"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
