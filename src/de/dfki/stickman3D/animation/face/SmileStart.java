package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class SmileStart extends AnimationStickman3D {

  public SmileStart() {
    mAnimType = ANIMTYPE.ON;
  }

  public SmileStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // smile start
    AnimationStickman3D.isSmileInAction = true;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SMILE"));
    playAnimationPart(duration);
    pauseAnimation(10);

  }
}
