package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class ExcitedStart extends AnimationStickman3D {

  public ExcitedStart(Stickman3D sm, int duration, boolean block) {
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

    pauseAnimation(10);
  }
}
