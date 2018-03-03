package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

/**
 * @author Robbie
 */
public class StopIdle extends AnimationStickmanFX {

  public StopIdle(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    mStickmanFX.mIdleRun = false;
    while (mStickmanFX.mIdleBehavior.isAlive()) {
      ;
    }
  }
}
