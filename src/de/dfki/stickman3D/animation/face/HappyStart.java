package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class HappyStart extends AnimationStickman3D {

  public HappyStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // happy start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "HAPPY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "HAPPY"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
