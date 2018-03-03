package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

/**
 * @author Robbie
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class StartIdle extends AnimationSwing {

  public StartIdle(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (!mStickmanSwing.mIdleBehavior.isAlive()) {
      mStickmanSwing.mIdleRun = true;
      mStickmanSwing.mIdleBehavior = new IdleBehavior(mStickmanSwing, mStickmanSwing.simplexNoise);
      mStickmanSwing.mIdleBehavior.start();
    }
  }
}
