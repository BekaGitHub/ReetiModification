package de.dfki.stickmanFX.animation.gesturefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class CoverMouth extends AnimationStickmanFX {

  public CoverMouth() {
    mAnimType = ANIMTYPE.Gesture;
  }

  public CoverMouth(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int rotationUnit = 16;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", -rotationUnit * 3));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 9));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 9));
    playAnimationPart(200);

    pauseAnimation(1200);

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", +rotationUnit * 3));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 9));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 9));
    playAnimationPart(300);
  }
}
