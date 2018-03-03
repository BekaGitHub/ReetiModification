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
 * @author Beka Aptsiauri
 */
public class AngrySmallMouthEnd extends AnimationStickmanFX {

  public AngrySmallMouthEnd() {
    super();
  }

  public AngrySmallMouthEnd(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry with small mouth end
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
//        animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkle, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
