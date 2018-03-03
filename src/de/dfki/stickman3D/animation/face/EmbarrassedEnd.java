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
 * @author Patrick Gebhard
 */
public class EmbarrassedEnd extends AnimationStickman3D {

  public EmbarrassedEnd(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // no embarrassed
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EMBARRASSEDEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
//        animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkle, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EMBARRASSEDEND"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EMBARRASSEDEND"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
