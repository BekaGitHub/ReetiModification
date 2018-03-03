/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class FearEnd extends AnimationStickman3D {

  public FearEnd(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // no fear
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FEAREND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "DISGUSTEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "SURPRISEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "DISGUSTEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
