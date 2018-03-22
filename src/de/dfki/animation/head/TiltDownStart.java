/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;

/**
 * @author Beka
 */
public class TiltDownStart extends AnimationReeti {

  public TiltDownStart(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    ((Reeti) agent).neckTilt(20, 500);
  }
}
