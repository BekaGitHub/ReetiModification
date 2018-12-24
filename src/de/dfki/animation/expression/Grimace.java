/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.animation.AnimationVisivility;

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
    reeti.neckPan(25, 500);
    reeti.neckTilt(20, 500);
    reeti.leftEyePan(60, 500);
    reeti.leftEyeTilt(60, 500);
    reeti.rightEyePan(15, 500);
    reeti.rightEyeTilt(40, 500);
    reeti.rightEar(0, 500);
    reeti.leftLC(75, 500);
    reeti.rightLC(60, 500);
    reeti.bottomLip(10, 500);
    reeti.topLip(3, 500);
  }
}
