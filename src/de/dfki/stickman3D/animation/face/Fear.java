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
 * @author Beka
 */
public class Fear extends AnimationStickman3D {

  public Fear() {
    mAnimType = ANIMTYPE.ON;
  }

  public Fear(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // fear
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FEAR"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SAD"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SAD"));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 10));

    if (mStickman3D.mType == Gender.TYPE.MALE) {
      // Left Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -70));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -100));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -30));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -130));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 20));

      // Right Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 70));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -95));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 30));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 130));

    } else {
      // Left Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -55));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -105));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -25));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -200));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 20));

      // Right Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -100));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 25));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 200));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 20));
    }
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no fear
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FEAREND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SADEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SADEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -10));

    if (mStickman3D.mType == Gender.TYPE.MALE) {
      // Left Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 70));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 100));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 30));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 130));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -20));

      // Right Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -70));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 95));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -30));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -130));
    } else {
      // Left Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 55));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 105));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 25));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 200));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -20));

      // Right Hand
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 100));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -25));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -200));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -20));

    }
    playAnimationPart(duration);

    // pauseAnimation(1200);
    // animationContents = new ArrayList<>();
    // animationContents.add(new AnimationContent3D(mStickmanSwing.head,
    // "yrotate", -90));
    // animationContents.add(new AnimationContent3D(mStickmanSwing.mUpperBody,
    // "yrotate", -90));
    // playAnimationPart(500);
    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
