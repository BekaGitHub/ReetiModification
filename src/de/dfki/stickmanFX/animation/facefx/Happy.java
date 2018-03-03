package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Happy extends AnimationStickmanFX {

  public Happy() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Happy(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "HAPPY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "HAPPY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "HAPPYEND"));
    playAnimationPart(20);
  }
}
