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
public class NeckPan {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForLeftPan = new AnimationContent(reeti.getHead().getHeadGroup());
    animationContentForLeftPan.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftPan.setPivotX(0);
    animationContentForLeftPan.setPivotY(25);
    animationContentForLeftPan.setPivotZ(-25);
    animationContentForLeftPan.setRotationsGradAufZAxis(20);
    animationContentForLeftPan.setAnimationCycleCounter(2);
    reeti.getHead().onAnimation(animationContentForLeftPan);

    AnimationContent animationContentForRightPan = new AnimationContent(reeti.getHead().getHeadGroup());
    animationContentForRightPan.setAnimationsDauerInMillisekunden(500);
    animationContentForRightPan.setPivotX(0);
    animationContentForRightPan.setPivotY(25);
    animationContentForRightPan.setPivotZ(-25);
    animationContentForRightPan.setRotationsGradAufZAxis(40);
    animationContentForRightPan.setAnimationCycleCounter(2);
    reeti.getHead().onAnimation(animationContentForRightPan);


  }
}
