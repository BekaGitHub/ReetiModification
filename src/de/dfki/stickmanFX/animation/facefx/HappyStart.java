package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class HappyStart extends AnimationStickmanFX {

  public HappyStart() {
    super();
  }

  public HappyStart(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "HAPPY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "HAPPY"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
