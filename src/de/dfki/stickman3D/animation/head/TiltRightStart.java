/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class TiltRightStart extends AnimationStickman3D {

  public TiltRightStart(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    AnimationStickman3D.isHeadTiltInAction = true;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "zrotate", -10));
    playAnimationPart(200);

  }
}
