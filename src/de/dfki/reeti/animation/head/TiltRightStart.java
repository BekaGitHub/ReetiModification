/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class TiltRightStart extends AnimationReeti {

  public TiltRightStart(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    getReeti().neckPan(80);
  }
}
