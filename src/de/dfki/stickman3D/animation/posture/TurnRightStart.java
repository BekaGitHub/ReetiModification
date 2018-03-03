/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the default state to the
 * angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class TurnRightStart extends AnimationStickman3D {

  public TurnRightStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  /**
   * This method creates the angry facial movement.
   */
  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 20));
    playAnimationPart(100);

    if (mStickman3D.mType == Gender.TYPE.MALE) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 40));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 20));
      playAnimationPart(500);
    } else {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 70));
      animationContents.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 20));
      playAnimationPart(500);
    }

    pauseAnimation(10);

  }
}
