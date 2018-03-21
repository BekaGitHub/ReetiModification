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
public class Grimace extends AnimationReeti {

  public Grimace() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Grimace(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.neckPan(25);
    reeti.neckTilt(20);
    reeti.leftEyePan(60);
    reeti.leftEyeTilt(60);
    reeti.rightEyePan(15);
    reeti.rightEyeTilt(40);
    reeti.rightEar(0);
    reeti.leftLC(75);
    reeti.rightLC(60);
    reeti.bottomLip(10);
    reeti.topLip(3);
  }
}
