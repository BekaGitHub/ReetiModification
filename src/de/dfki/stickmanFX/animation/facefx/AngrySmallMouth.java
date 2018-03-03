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
public class AngrySmallMouth extends AnimationStickmanFX {

  public AngrySmallMouth() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public AngrySmallMouth(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTH"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
    //animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no angry
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
    //animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
    playAnimationPart(20);
  }
}
