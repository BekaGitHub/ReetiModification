package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookDown extends AnimationStickman3D {

  public LookDown() {
    mAnimType = ANIMTYPE.ON;
  }

  public LookDown(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKDOWN"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKDOWN"));
    playAnimationPart(100);

    pauseAnimation(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKDOWNEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKDOWNEND"));
    playAnimationPart(100);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
