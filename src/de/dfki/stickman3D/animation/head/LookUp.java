package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookUp extends AnimationStickman3D {

  public LookUp() {
    mAnimType = ANIMTYPE.ON;
  }

  public LookUp(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKUP"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKUP"));
    playAnimationPart(100);

    pauseAnimation(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKUPEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKUPEND"));
    playAnimationPart(100);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
