/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class ContemptStart extends AnimationSwing {

  public ContemptStart(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // Contempt start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "CONTEMPT"));
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "CONTEMPT"));
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "CONTEMPT"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
