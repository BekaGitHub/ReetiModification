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
public class OpenMouth {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForUpperLip = new AnimationContent(reeti.getMouthUpperLip().getUpperLip());
    animationContentForUpperLip.setAnimationsDauerInMillisekunden(2);
    animationContentForUpperLip.setPosition(100);
    reeti.getMouthUpperLip().onAnimation(animationContentForUpperLip);

    AnimationContent animationContentForDownLip = new AnimationContent(reeti.getMouthDownLip().getDownLip());
    animationContentForDownLip.setAnimationsDauerInMillisekunden(2);
    animationContentForDownLip.setPosition(100);
    reeti.getMouthDownLip().onAnimation(animationContentForDownLip);
  }
}
