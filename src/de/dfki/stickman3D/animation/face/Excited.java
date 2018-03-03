package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Excited extends AnimationStickman3D {

  public Excited() {
    mAnimType = ANIMTYPE.ON;
  }

  public Excited(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EXCITED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EXCITED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EXCITED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EXCITED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EXCITED"));
    playAnimationPart(duration);

    pauseAnimation(1200);

    // no excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EXCITEDEND"));
    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
