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
public class Contempt extends AnimationStickmanFX {

  public Contempt() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Contempt(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // Contempt
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "CONTEMPT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "CONTEMPT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "CONTEMPT"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no Contempt
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "CONTEMPTEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "CONTEMPTEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "CONTEMPTEND"));
    playAnimationPart(20);
  }
}
