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
public class Grimace {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForLeftEyeLid = new AnimationContent(reeti.getLeftEyelid().getLeftEyeLidMesh());
    animationContentForLeftEyeLid.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftEyeLid.setPivotX(0);
    animationContentForLeftEyeLid.setPivotY(0);
    animationContentForLeftEyeLid.setPivotZ(0);
    animationContentForLeftEyeLid.setRotationsGradAufXAxis(50);
    reeti.getLeftEyelid().onAnimation(animationContentForLeftEyeLid);


    AnimationContent animationContentForRightEyeLid = new AnimationContent(reeti.getRightEyelid().getRightEyelid());
    animationContentForRightEyeLid.setAnimationsDauerInMillisekunden(500);
    animationContentForRightEyeLid.setPivotX(0);
    animationContentForRightEyeLid.setPivotY(0);
    animationContentForRightEyeLid.setPivotZ(0);
    animationContentForRightEyeLid.setRotationsGradAufXAxis(50);
    reeti.getRightEyelid().onAnimation(animationContentForRightEyeLid);

    AnimationContent animationContentForUpperLip = new AnimationContent(reeti.getMouthUpperLip().getUpperLip());
    animationContentForUpperLip.setAnimationsDauerInMillisekunden(500);
    animationContentForUpperLip.setPosition(70);
    reeti.getMouthUpperLip().onAnimation(animationContentForUpperLip);

    AnimationContent animationContentForDownLip = new AnimationContent(reeti.getMouthDownLip().getDownLip());
    animationContentForDownLip.setAnimationsDauerInMillisekunden(500);
    animationContentForDownLip.setPosition(100);
    reeti.getMouthDownLip().onAnimation(animationContentForDownLip);

    AnimationContent animationContentForLeftEye = new AnimationContent(reeti.getLeftEye().getLeftEyeGroup());
    animationContentForLeftEye.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftEye.setPivotX(0);
    animationContentForLeftEye.setPivotY(0);
    animationContentForLeftEye.setPivotZ(0);
    animationContentForLeftEye.setRotationsGradAufYAxis(50);
    reeti.getLeftEye().onAnimation(animationContentForLeftEye);

    AnimationContent animationContentForRightEye = new AnimationContent(reeti.getRightEye().getRightEyeGroup());
    animationContentForRightEye.setAnimationsDauerInMillisekunden(500);
    animationContentForRightEye.setPivotX(0);
    animationContentForRightEye.setPivotY(0);
    animationContentForRightEye.setPivotZ(0);
    animationContentForRightEye.setRotationsGradAufXAxis(30);
    reeti.getRightEye().onAnimation(animationContentForRightEye);
  }

  private void resetLeftEyeLid(Reeti reeti) {
    AnimationContent animationContentForLeftEyeLid = new AnimationContent(reeti.getLeftEyelid().getLeftEyeLidMesh());
    animationContentForLeftEyeLid.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftEyeLid.setPivotX(0);
    animationContentForLeftEyeLid.setPivotY(0);
    animationContentForLeftEyeLid.setPivotZ(0);
    animationContentForLeftEyeLid.setRotationsGradAufXAxis(-50);
    reeti.getLeftEyelid().onAnimation(animationContentForLeftEyeLid);
  }
}
