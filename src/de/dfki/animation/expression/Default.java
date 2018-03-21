/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.controllers.ReetiController;
import de.dfki.util.AnimationVisivility;

/**
 * @author Beka
 */
public class Default extends AnimationReeti {

  public Default() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Default(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.neckRotat(50);
    reeti.neckPan(50);
    reeti.neckTilt(50);
    reeti.rightLC(50);
    reeti.leftLC(50);
    reeti.topLip(0);
    reeti.bottomLip(100);
    reeti.rightEyePan(60);
    reeti.rightEyeTilt(42);
    reeti.leftEyePan(40);
    reeti.leftEyeTilt(42);
    reeti.leftEyeLid(100);
    reeti.rightEyeLid(100);
    reeti.rightEar(50);
    reeti.leftEar(50);
    reeti.ledOFF();
    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
