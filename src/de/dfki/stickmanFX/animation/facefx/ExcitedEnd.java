package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class ExcitedEnd extends AnimationStickmanFX {

  public ExcitedEnd() {
    super();
  }

  public ExcitedEnd(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // no excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EXCITEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
