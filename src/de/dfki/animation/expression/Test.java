/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.AnimationContent;

/**
 * @author Beka
 */
public class Test {

  public void playAnimation(Reeti reeti) {

    AnimationContent animationContentForRightEar = new AnimationContent(reeti.getRightEar().getRightEarMesh());
    animationContentForRightEar.setAnimationsDauerInMillisekunden(500);
    animationContentForRightEar.setPivotX(0);
    animationContentForRightEar.setPivotY(0);
    animationContentForRightEar.setPivotZ(0);
    animationContentForRightEar.setRotationsGradAufZAxis(20);
    reeti.getRightEar().onAnimation(animationContentForRightEar);

  }
}
