package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class HappyStart extends AnimationSwing {

  public HappyStart(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "HAPPY"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "HAPPY"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
