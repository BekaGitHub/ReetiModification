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
public class OneTwoThree extends AnimationStickman3D {

  /**
   * @param sm AgentInterface
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */

  public OneTwoThree() {
    mAnimType = ANIMTYPE.ON;
  }

  public OneTwoThree(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    // LeftHand Up
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 23));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -105));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", 130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", 20));

    // RightHand Up
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -58));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -5));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 10));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -10));

    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 25));
    playAnimationPart(500);

    // One
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -3));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 130));
    playAnimationPart(500);
    pauseAnimation(500);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 3));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -30));
    playAnimationPart(500);

    pauseAnimation(200);

    // Two
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -7));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", 130));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKUP"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKUP"));
    playAnimationPart(500);
    pauseAnimation(500);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 7));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -30));
    playAnimationPart(500);

    pauseAnimation(200);

    // Three
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -10));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", 130));
    playAnimationPart(500);
    pauseAnimation(500);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 10));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -30));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKUPEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKUPEND"));
    playAnimationPart(500);

    pauseAnimation(500);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", -130));
    // LeftHand Down
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 30));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -23));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 105));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", -20));
    // RightHand Down
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 60));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 5));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -10));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 10));

    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -25));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
