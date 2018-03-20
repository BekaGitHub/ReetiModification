/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class Test extends AnimationReeti {

  public Test() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Test(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
    reeti.rightLC(100);
  }
}
