/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

public class TurnLeft extends AnimationStickman3D {

  public TurnLeft() {
    mAnimType = ANIMTYPE.ON;
  }

  public TurnLeft(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
    playAnimationPart(100);

    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -40));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
      playAnimationPart(500);
    } else {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -70));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
      playAnimationPart(500);
    }

    pauseAnimation(1000);

    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 40));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 40));
      playAnimationPart(500);
    } else {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 70));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 40));
      playAnimationPart(500);
    }

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
