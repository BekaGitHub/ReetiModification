package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookLeft extends AnimationSwing {

  public LookLeft(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    int translationUnit = 3;

    // look left
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "LOOKLEFT"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "LOOKLEFT"));
    playAnimationPart(20);

//		// blink up
//		animationContents = new ArrayList<>();
//		animationContents.add(new AnimationContentSwing(mStickmanSwing.leftEye, "shape", "DEFAULT"));
//		animationContents.add(new AnimationContentSwing(mStickmanSwing.rightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
  }
}
