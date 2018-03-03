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
public class EmbarrassedStart extends AnimationStickman3D {

  public EmbarrassedStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    // embarrassed
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "EMBARRASSED"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "EMBARRASSED"));
    //animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkle, "shape", "EMBARRASSED"));   ///Add by Robbie
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "EMBARRASSED"));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "EMBARRASSED"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
