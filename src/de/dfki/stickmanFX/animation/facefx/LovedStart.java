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
public class LovedStart extends AnimationStickmanFX {

  public LovedStart() {
    super();
  }

  public LovedStart(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // loved
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILE"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOVED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOVED"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
