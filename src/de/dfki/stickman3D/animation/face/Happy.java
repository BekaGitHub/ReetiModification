package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Happy extends AnimationStickman3D {

  public Happy() {
    mAnimType = ANIMTYPE.ON;
  }

  public Happy(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "HAPPYEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
