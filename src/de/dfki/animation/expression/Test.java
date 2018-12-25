/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;

/**
 * @author Beka
 */
public class Test {

  public void playAnimation(Reeti reeti) {
    AnimationContent animationContent = new AnimationContent(reeti.getMouth());
    animationContent.setAnimationsDauerInMillisekunden(500);
    animationContent.setPosition(100);

//    animationContent.setMouthPart(MouthPart.UPPER_LIP);
    animationContent.setAnimationCycleCounter(20);
    reeti.getMouthRightCorner().onAnimation(animationContent);

  }


//  AnimationContent animationContentTest = new AnimationContent(reeti.getHead().getHeadGroup());
//    animationContentTest.setAnimationsDauerInMillisekunden(250);
//    animationContentTest.setPivotX(0);
//    animationContentTest.setPivotY(25);
//    animationContentTest.setPivotZ(-25);
//    animationContentTest.setRotationsGradAufXAxis(20);
//    animationContentTest.setRotationsGradAufYAxis(0);
//    animationContentTest.setRotationsGradAufZAxis(0);
//
//    animationContentTest.setAnimationCycleCounter(20);
//    reeti.getHead().onAnimation(animationContentTest);

  public void onAnimation(Reeti reeti) {
//    AnimationContent animationContentTest = new AnimationContent(reeti.getHead().getHeadGroup());
//    animationContentTest.setAnimationsDauerInMillisekunden(5000);
//    animationContentTest.setPivotX(0);
//    animationContentTest.setPivotY(25);
//    animationContentTest.setPivotZ(-25);
//    animationContentTest.setRotationsGradAufXAxis(0);
//    animationContentTest.setRotationsGradAufYAxis(0);
//    animationContentTest.setRotationsGradAufZAxis(360);
//
//    animationContentTest.setAnimationCycleCounter(20);
//    reeti.getHead().onAnimation(animationContentTest);
    reeti.leftEyeTilt(100, 500);
  }

  public void pauseAnimation(Reeti reeti) {
//    reeti.getHead().pauseAnimation();
  }
}
