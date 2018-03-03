package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookRight extends AnimationStickmanFX {

  public LookRight(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int translationUnit = 3;

    // look left
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKRIGHT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKRIGHT"));
    playAnimationPart(20);

//		// blink up
//		animationContents = new ArrayList<>();
//		animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "DEFAULT"));
//		animationContents.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
  }
}
