package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Excited extends AnimationSwing {

  public Excited() {
    mAnimType = ANIMTYPE.EmotionExpression;
  }

  public Excited(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "EXCITED"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "EXCITED"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "EXCITED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "EXCITED"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "EXCITED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "EXCITEDEND"));

    playAnimationPart(20);
  }
}
