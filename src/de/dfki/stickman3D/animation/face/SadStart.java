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
public class SadStart extends AnimationStickman3D {

  public SadStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // sad
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SAD"));
    animationContents.add(
        new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "DISGUSTED"));  // add by Robbie
    animationContents.add(
        new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "DISGUSTED")); // add by Robbie
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
