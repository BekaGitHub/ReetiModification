/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;

/**
 * @author Beka
 */
public class BlinkLeftEyelid {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContent = new AnimationContent(reeti.getLeftEyelid().getLeftEyeLidMesh());
    animationContent.setAnimationsDauerInMillisekunden(500);
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    animationContent.setRotationsGradAufXAxis(100);
    animationContent.setAnimationCycleCounter(4);
    reeti.getLeftEyelid().onAnimation(animationContent);
  }
}
