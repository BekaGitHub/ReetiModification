/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.AnimationVisivility;

/**
 * @author Beka
 */
public class Test extends AnimationReeti {

  public Test() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Test(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = (Reeti) agent;
    AnimationContentTest animationContentTest = new AnimationContentTest(reeti.getHead().getHeadGroup());
    animationContentTest.setAnimationsDauerInMillisekunden(5000);
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(25);
    animationContentTest.setPivotZ(-25);
    animationContentTest.setRotationsGradAufXAxis(0);
    animationContentTest.setRotationsGradAufYAxis(0);
    animationContentTest.setRotationsGradAufZAxis(360);

    animationContentTest.setAnimationCycleCounter(20);
    reeti.getHead().onAnimation(animationContentTest);
  }

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
