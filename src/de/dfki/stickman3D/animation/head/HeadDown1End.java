/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class HeadDown1End extends AnimationStickman3D {

  public HeadDown1End(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // blink up
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -15));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKDOWNEND"));
    animationContents.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKDOWNEND"));
    playAnimationPart(duration);

    AnimationStickman3D.isHeadTiltInAction = false;

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
