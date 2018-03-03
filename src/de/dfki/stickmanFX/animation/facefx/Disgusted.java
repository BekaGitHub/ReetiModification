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
public class Disgusted extends AnimationStickmanFX {

  public Disgusted() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Disgusted(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // disgusted
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DISGUSTED"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no disgusted
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTEDEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DISGUSTEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTEDEND"));
    playAnimationPart(20);
  }
}
