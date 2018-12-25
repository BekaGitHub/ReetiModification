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
public class NeckTilt {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForDownTilt = new AnimationContent(reeti.getHead().getHeadGroup());
    animationContentForDownTilt.setAnimationsDauerInMillisekunden(500);
    animationContentForDownTilt.setPivotX(0);
    animationContentForDownTilt.setPivotY(25);
    animationContentForDownTilt.setPivotZ(-25);
    animationContentForDownTilt.setRotationsGradAufXAxis(20);
    animationContentForDownTilt.setAnimationCycleCounter(2);
    Timeline timeline = reeti.getHead().onAnimation(animationContentForDownTilt);

    timeline.setOnFinished(event -> {
      AnimationContent animationContentForUpperTilt = new AnimationContent(reeti.getHead().getHeadGroup());
      animationContentForUpperTilt.setAnimationsDauerInMillisekunden(500);
      animationContentForUpperTilt.setPivotX(0);
      animationContentForUpperTilt.setPivotY(25);
      animationContentForUpperTilt.setPivotZ(-25);
      animationContentForUpperTilt.setRotationsGradAufXAxis(-20);
      animationContentForUpperTilt.setAnimationCycleCounter(2);
      reeti.getHead().onAnimation(animationContentForUpperTilt);
    });
  }
}
