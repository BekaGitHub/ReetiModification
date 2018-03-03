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

/**
 * An angry facial movement is created in this class. The face moves from the default state to the
 * angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Dancing extends AnimationStickman3D {

  public Dancing() {
    mAnimType = ANIMTYPE.ON;
  }

  public Dancing(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -40));
    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -110));
    } else {
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -30));
    }
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -40));
    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 110));
    } else {
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 30));
    }
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -60));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 40));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -60));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -40));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 110));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -110));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "rotate", 20));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", -50));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 130));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", 45));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "zrotate", -10));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", 10));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "rotate", 20));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", 50));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "zrotate", -45));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "zrotate", 10));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger2, "zrotate", -10));
    playAnimationPart(500);

    pauseAnimation(500);

    for (int i = 0; i < 20; i++) {
      animationContents = new ArrayList<>();
      if (mStickman3D.mType == Gender.TYPE.MALE) {
        animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -30));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -30));
      } else {
        animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -10));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -10));
      }
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "rotate", 5));
      if (i == 3) {
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftFoot, "yrotate", 30));
      }
      if (i > 3) {
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 10));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperLeg, "rotate", -50));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeLeg, "rotate", 50));
        animationContents.add(new AnimationContent3D(mStickman3D.mDownBody, "rotate", 10));
      }

      if (i == 6) {
        animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "TWO"));
      }
      if (i == 13) {
        animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SMILE"));
      }
      playAnimationPart(200);

      animationContents = new ArrayList<>();
      if (mStickman3D.mType == Gender.TYPE.MALE) {
        animationContents
            .add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 30));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 30));
      } else {
        animationContents
            .add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 10));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 10));
      }
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "rotate", -5));
      if (i > 3) {
        animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -10));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperLeg, "rotate", 50));
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeLeg, "rotate", -50));
        animationContents.add(new AnimationContent3D(mStickman3D.mDownBody, "rotate", -10));
      }
      if (i == 12) {
        animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "DEFAULT"));
      }
      if (i == 17) {
        animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SMILEEND"));
      }
      if (i == 19) {
        animationContents.add(new AnimationContent3D(mStickman3D.mLeftFoot, "yrotate", -30));
      }
      playAnimationPart(200);

    }

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 40));
    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 110));
    } else {
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 30));
    }
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 40));
    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -110));
    } else {
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -30));
    }

    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 60));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -40));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 60));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 40));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -110));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 110));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "rotate", -20));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", 50));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", -45));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "zrotate", 10));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", -10));

    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "rotate", -20));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger1, "zrotate", -50));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -130));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger4, "zrotate", 45));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger3, "zrotate", -10));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightFinger2, "zrotate", 10));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
