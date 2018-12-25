/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.AnimationContent;
import javafx.animation.Timeline;

/**
 * @author Beka
 */
public class NeckRotation {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForLeftRotation = new AnimationContent(reeti.getHead().getHeadGroup());
    animationContentForLeftRotation.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftRotation.setPivotX(0);
    animationContentForLeftRotation.setPivotY(25);
    animationContentForLeftRotation.setPivotZ(-25);
    animationContentForLeftRotation.setRotationsGradAufYAxis(20);
    animationContentForLeftRotation.setAnimationCycleCounter(2);
    Timeline timeline = reeti.getHead().onAnimation(animationContentForLeftRotation);

    timeline.setOnFinished(event -> {
      AnimationContent animationContentForRightRotation = new AnimationContent(reeti.getHead().getHeadGroup());
      animationContentForRightRotation.setAnimationsDauerInMillisekunden(500);
      animationContentForRightRotation.setPivotX(0);
      animationContentForRightRotation.setPivotY(25);
      animationContentForRightRotation.setPivotZ(-25);
      animationContentForRightRotation.setRotationsGradAufYAxis(-20);
      animationContentForRightRotation.setAnimationCycleCounter(2);
      reeti.getHead().onAnimation(animationContentForRightRotation);
    });
  }
}
