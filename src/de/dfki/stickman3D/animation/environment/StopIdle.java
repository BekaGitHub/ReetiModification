package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Robbie
 */
public class StopIdle extends AnimationStickman3D {

  public StopIdle(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    mStickman3D.mIdleRun = false;
    mStickman3D.mIdleBehavior = null;
    System.out.println("de.dfki.stickman3D.animation.environmentfx.StopIdle.playAnimation()");
  }
}
