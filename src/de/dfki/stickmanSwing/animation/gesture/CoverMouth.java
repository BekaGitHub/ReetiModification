package de.dfki.stickmanSwing.animation.gesture;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class CoverMouth extends AnimationSwing {

  public CoverMouth(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int rotationUnit = 16;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftShoulder, "rotate", -rotationUnit * 3));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftUpperArm, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftForeArm, "rotate", rotationUnit * 9));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftHand, "rotate", rotationUnit * 9));
    playAnimationPart(200);

    pauseAnimation(1200);

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftShoulder, "rotate", +rotationUnit * 3));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftUpperArm, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftForeArm, "rotate", -rotationUnit * 9));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftHand, "rotate", -rotationUnit * 9));
    playAnimationPart(300);
  }
}
