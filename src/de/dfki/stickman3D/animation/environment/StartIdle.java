package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Robbie
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartIdle extends AnimationStickman3D {

  int frequent;

  public StartIdle(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman3D = sm;

    frequent = duration / 1000;
    if (frequent <= 0) {
      frequent = 1;
    }
  }

  @Override
  public void playAnimation() {
    if (mStickman3D.mIdleBehavior == null) {
      mStickman3D.mIdleRun = true;
      mStickman3D.mIdleBehavior = new IdleBehavior(mStickman3D);
    }
  }
}
