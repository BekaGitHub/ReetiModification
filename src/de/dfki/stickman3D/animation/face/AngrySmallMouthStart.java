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
 * @author beka Aptsiauri
 */
public class AngrySmallMouthStart extends AnimationStickman3D {

  public AngrySmallMouthStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry with small mouth start
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYSMALLMOUTH"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRY"));
//        animationContents.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
