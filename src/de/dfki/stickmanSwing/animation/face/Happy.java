package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Robbie
 */
public class Happy extends AnimationSwing {

  public Happy() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Happy(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "HAPPY"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "HAPPY"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "HAPPYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "HAPPYEND"));

    playAnimationPart(20);
  }
}
