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
 * @author Beka Aptsiauri
 */
public class AngryStart extends AnimationStickman3D {

  public AngryStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // angry start
    AnimationStickman3D.isAngryInAction = true;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mFaceWrinkle, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRY"));
    animationContents.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRY"));
    playAnimationPart(duration);

    pauseAnimation(10);
  }
}
