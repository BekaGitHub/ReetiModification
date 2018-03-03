package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class LookLeft extends AnimationStickman3D {

  public LookLeft() {
    mAnimType = ANIMTYPE.ON;
  }

  public LookLeft(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKLEFT"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKLEFT"));
    playAnimationPart(100);

    pauseAnimation(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKLEFTEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKLEFTEND"));
    playAnimationPart(100);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
