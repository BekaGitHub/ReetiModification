/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.AnimationContent;

/**
 * @author Beka
 */
public class LipDown {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContent = new AnimationContent(reeti.getMouthDownLip().getDownLip());
    animationContent.setAnimationsDauerInMillisekunden(500);
    animationContent.setPosition(100);
    reeti.getMouthDownLip().onAnimation(animationContent);
  }
}
