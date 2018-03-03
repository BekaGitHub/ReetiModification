package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author beka
 */
public class HappyEnd extends AnimationStickman3D {

  public HappyEnd(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // no happy
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "HAPPYEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "HAPPYEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
