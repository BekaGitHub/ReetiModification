/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class WaveLeft extends AnimationStickman3D {

  public WaveLeft() {
    mAnimType = ANIMTYPE.ON;
  }

  public WaveLeft(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // mStickmanSwing.stopIdleBehavior();
    // mStickmanSwing.startIdleBehavior("TouchHead");

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -35));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -120));
    playAnimationPart(200);

    for (int i = 0; i < 6; i++) {
      if (i == 0) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -10));
        playAnimationPart(200);
      } else if (i == 5) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 10));
        playAnimationPart(200);
      } else if (i % 2 == 1) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 20));
        playAnimationPart(200);
      } else {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -20));
        playAnimationPart(200);
      }
    }

    pauseAnimation(1000);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 35));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 120));
    playAnimationPart(200);

  }
}
