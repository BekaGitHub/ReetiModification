/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Beka
 */
public class UnsynchronizedConversationHandsStart extends AbstractConversationHands {

  private static boolean movementStarted = false;

  public UnsynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    intensity = 10;
  }

  public UnsynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block,
      HashMap<String, String> extraParams) {
    super(sm, duration, block, extraParams);
  }

  @Override
  public void playAnimation() {
    if (!movementStarted) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -38));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "yrotate", 13));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -18));

      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -76));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "yrotate", 35));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate",
          START_LEFT_FORE_ARM_POSITION));

      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 0));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -54));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "zrotate", 7));

      //Right Part
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -56));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "yrotate", 28));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 27));

      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -19));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", 27));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate",
          START_RIGHT_FORE_ARM_POSITION));

      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -8));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 34));
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 0));
      playAnimationPart(200);
      pauseAnimation(duration);
      movementStarted = true;
    }

    animationContents = new ArrayList<>();
    moveConversationHands();
    playAnimationPart(200);
  }


  protected int getLeftArmMovement() {
    int leftForeArmZ;
    leftForeArmZ = START_LEFT_FORE_ARM_POSITION - getMovementDistance();
    return leftForeArmZ;
  }

  protected int getRightArmMovement() {
    int rightForeArmZ;
    rightForeArmZ = START_RIGHT_FORE_ARM_POSITION + getMovementDistance();
    return rightForeArmZ;
  }


}
