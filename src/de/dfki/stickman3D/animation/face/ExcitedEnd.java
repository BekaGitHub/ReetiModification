package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class ExcitedEnd extends AnimationStickman3D {

  public ExcitedEnd(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // no excited
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EXCITEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EXCITEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EXCITEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
