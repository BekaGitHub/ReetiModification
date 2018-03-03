package de.dfki.stickmanSwing.animation.face;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Mouth_FIVE extends AnimationSwing {

  public Mouth_FIVE(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  public void playAnimation() {
    // smile
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "FIVE"));
    playAnimationPart(20);
  }
}
