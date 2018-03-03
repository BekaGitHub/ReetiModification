/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class HeadRight extends AnimationStickman3D {

  public HeadRight() {
    mAnimType = ANIMTYPE.ON;
  }

  public HeadRight(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKRIGHT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKRIGHT"));
    playAnimationPart(duration);

    pauseAnimation(1000);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKRIGHTEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKRIGHTEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
