/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.MouthPart;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.animation.AnimationVisivility;

/**
 * @author Beka
 */
public class Test {

  public void playAnimation(Reeti reeti) {
    AnimationContentTest animationContentTest = new AnimationContentTest(reeti.getMouth());
    animationContentTest.setAnimationsDauerInMillisekunden(500);
    animationContentTest.setPosition(35);

    animationContentTest.setMouthPart(MouthPart.RIGHT_CORNER);
    animationContentTest.setAnimationCycleCounter(20);
    reeti.getMouth().onAnimation(animationContentTest);

  }


//  AnimationContentTest animationContentTest = new AnimationContentTest(reeti.getHead().getHeadGroup());
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
//    AnimationContentTest animationContentTest = new AnimationContentTest(reeti.getHead().getHeadGroup());
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
