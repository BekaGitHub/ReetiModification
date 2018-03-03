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
public class EmbarrassedEnd extends AnimationStickmanFX {

  public EmbarrassedEnd() {
    super();
  }

  public EmbarrassedEnd(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // no embarrassed
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSEDEND"));
//        animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkle, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSEDEND"));
    playAnimationPart(20);

    pauseAnimation(10);
  }
}
