package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class HappyEnd extends AnimationSwing {

  public HappyEnd(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy end
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "HAPPYEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "HAPPYEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
