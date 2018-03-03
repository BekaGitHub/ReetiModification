/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.Gender;
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
public class Angry2 extends AnimationStickman3D {

  Stickman3D mStickmanFX;
  int rotationUnit;

  public Angry2() {
    mAnimType = ANIMTYPE.ON;
  }

  /**
   * @param sm AgentInterface
   * @param duration Control the speed of the movement from one emotion state to another emotion
   * state.
   * @param block block or not the others movements, when one movement is not finished.
   */
  public Angry2(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickmanFX = sm;
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    if (mStickmanFX.mType == Gender.TYPE.MALE) {
      rotationUnit = 20;
    } else {
      rotationUnit = 30;
    }
    // angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mFaceWrinkle, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "ANGRY"));
    playAnimationPart(duration);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", -30));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", 60));

    animationContents.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", 10));
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -20));

    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", -15));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 35));
    playAnimationPart(duration);

    // foot
    for (int i = 0; i < 8; i++) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickmanFX.mRightFoot, "rotate", 40));
      playAnimationPart(200);

      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickmanFX.mRightFoot, "rotate", -40));
      playAnimationPart(200);
    }

    for (int i = 0; i < 7; i++) {
      animationContents = new ArrayList<>();
      if (i == 0 || i == 6) {
        animationContents.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -10));
      } else if (i % 2 == 1) {
        animationContents.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", 20));
      } else if (i % 2 == 0) {
        animationContents.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -20));
      }
      playAnimationPart(200);
    }

    pauseAnimation(1200);

    // no angry
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "ANGRYEND"));
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "ANGRYEND"));
    animationContents
        .add(new AnimationContent3D(mStickmanFX.mFaceWrinkle, "shape", "ANGRYEND")); /// Add
    /// by
    /// Robbie
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
    playAnimationPart(duration);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", 30));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", -60));

    animationContents.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", -10));
    animationContents.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 20));

    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", 15));
    animationContents.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -35));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
