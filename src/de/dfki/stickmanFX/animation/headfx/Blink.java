/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Blink extends AnimationStickmanFX {

  public Blink(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
    //Platform.runLater(() -> playAnimationPart(20));
    playAnimationPart(20);

    pauseAnimation(300);

    //blink up
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
    //Platform.runLater(() -> playAnimationPart(20));
    playAnimationPart(20);
  }
}
