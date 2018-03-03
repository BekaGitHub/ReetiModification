/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Clap extends AnimationStickman3D {

  public Clap() {
    mAnimType = ANIMTYPE.ON;
  }

  public Clap(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -30));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -70));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -90));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -120));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -10));
    playAnimationPart(500);

    for (int i = 0; i < 10; i++) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 10));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -15));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 17));
      playAnimationPart(200);

      pauseAnimation(100);

      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -10));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 15));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -17));
      playAnimationPart(200);
    }

    pauseAnimation(1000);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 70));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 90));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 120));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 10));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }

  }

}
