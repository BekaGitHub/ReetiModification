package de.dfki.stickmanFX.animation.facefx;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class ThinkOfLove extends AnimationStickmanFX {

  public ThinkOfLove() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public ThinkOfLove(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int rotationUnit = 10;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mThinkFX, "shape", "THINKOFLOVE"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILE"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));

    playAnimationPart(duration);
    pauseAnimation(2000);

    animationContents.add(new AnimationContentFX(mStickmanFX.mThinkFX, "shape", "THINKOFLOVEEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
    playAnimationPart(duration);

  }
}
