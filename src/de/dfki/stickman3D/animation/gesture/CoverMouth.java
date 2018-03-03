package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class CoverMouth extends AnimationStickman3D {

  public CoverMouth() {
    mAnimType = ANIMTYPE.ON;
  }

  public CoverMouth(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -18));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -150));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 140));
    playAnimationPart(500);

    pauseAnimation(1200);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 18));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 150));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -140));
    playAnimationPart(500);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }

  }
}
