/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.AnimationVisivility;

/**
 * @author Beka
 */
public class Test_1 extends AnimationReeti {

  public Test_1() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Test_1(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.neckPan(0, 500);
  }
}
