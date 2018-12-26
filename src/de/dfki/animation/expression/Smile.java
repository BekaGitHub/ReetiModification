package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.AnimationContent;

/**
 * @author Beka
 */
public class Smile {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContentForLeftEyeLid = new AnimationContent(reeti.getLeftEyelid().getLeftEyeLidMesh());
    animationContentForLeftEyeLid.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftEyeLid.setPivotX(0);
    animationContentForLeftEyeLid.setPivotY(0);
    animationContentForLeftEyeLid.setPivotZ(0);
    animationContentForLeftEyeLid.setRotationsGradAufXAxis(20);
    reeti.getLeftEyelid().onAnimation(animationContentForLeftEyeLid);

    AnimationContent animationContentForRightEyeLid = new AnimationContent(reeti.getRightEyelid().getRightEyelid());
    animationContentForRightEyeLid.setAnimationsDauerInMillisekunden(500);
    animationContentForRightEyeLid.setPivotX(0);
    animationContentForRightEyeLid.setPivotY(0);
    animationContentForRightEyeLid.setPivotZ(0);
    animationContentForRightEyeLid.setRotationsGradAufXAxis(20);
    reeti.getRightEyelid().onAnimation(animationContentForRightEyeLid);

    AnimationContent animationContentForMouthLeftCorner = new AnimationContent(reeti.getMouthLeftCorner());
    animationContentForMouthLeftCorner.setAnimationsDauerInMillisekunden(500);
    animationContentForMouthLeftCorner.setPosition(30);
    reeti.getMouthLeftCorner().onAnimation(animationContentForMouthLeftCorner);

    AnimationContent animationContentForMouthRightCorner = new AnimationContent(reeti.getMouthRightCorner());
    animationContentForMouthRightCorner.setAnimationsDauerInMillisekunden(500);
    animationContentForMouthRightCorner.setPosition(30);
    reeti.getMouthRightCorner().onAnimation(animationContentForMouthRightCorner);

    AnimationContent animationContentForMouthUpperLip = new AnimationContent(reeti.getMouthUpperLip());
    animationContentForMouthUpperLip.setAnimationsDauerInMillisekunden(500);
    animationContentForMouthUpperLip.setPosition(40);
    reeti.getMouthUpperLip().onAnimation(animationContentForMouthUpperLip);

    AnimationContent animationContentForMouthDownLip = new AnimationContent(reeti.getMouthDownLip());
    animationContentForMouthDownLip.setAnimationsDauerInMillisekunden(500);
    animationContentForMouthDownLip.setPosition(100);
    reeti.getMouthDownLip().onAnimation(animationContentForMouthDownLip);

    AnimationContent animationContentForLeftEar = new AnimationContent(reeti.getLeftEar().getLeftEarMesh());
    animationContentForLeftEar.setAnimationsDauerInMillisekunden(500);
    animationContentForLeftEar.setPivotX(0);
    animationContentForLeftEar.setPivotY(0);
    animationContentForLeftEar.setPivotZ(0);
    animationContentForLeftEar.setRotationsGradAufZAxis(10);
    reeti.getLeftEar().onAnimation(animationContentForLeftEar);

    AnimationContent animationContentForRightEar = new AnimationContent(reeti.getRightEar().getRightEarMesh());
    animationContentForRightEar.setAnimationsDauerInMillisekunden(500);
    animationContentForRightEar.setPivotX(0);
    animationContentForRightEar.setPivotY(0);
    animationContentForRightEar.setPivotZ(0);
    animationContentForRightEar.setRotationsGradAufZAxis(-10);
    reeti.getRightEar().onAnimation(animationContentForRightEar);
  }
}
