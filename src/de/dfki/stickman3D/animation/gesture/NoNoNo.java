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
 * An angry facial movement is created in this class. The face moves from the default state to the
 * angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class NoNoNo extends AnimationStickman3D {

  /**
   * @param sm AgentInterface
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */

  public NoNoNo() {
    mAnimType = ANIMTYPE.ON;
  }

  public NoNoNo(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -100));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -60));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -50));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 135));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", 135));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", 40));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "rotate", 35));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRY"));
    playAnimationPart(500);

    pauseAnimation(200);

    for (int i = 0; i < 6; i++) {
      if (i == 0) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", -30));
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 10));
        playAnimationPart(500);
      } else if (i == 5) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 30));
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -10));
        playAnimationPart(500);
      } else if (i % 2 == 1) {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 60));
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
        playAnimationPart(500);
      } else {
        animationContents = new ArrayList<>();
        animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", -60));
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 20));
        playAnimationPart(500);
      }

    }

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 100));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 60));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 50));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -135));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", -135));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", -40));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "rotate", -35));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRYEND"));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
