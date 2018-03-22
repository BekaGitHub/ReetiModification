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
    reeti.neckRotat(50, 500);
    reeti.neckPan(50, 500);
    reeti.neckTilt(50, 500);
    reeti.rightLC(50, 500);
    reeti.leftLC(50, 500);
    reeti.topLip(0, 500);
    reeti.bottomLip(100, 500);
    reeti.rightEyePan(60, 500);
    reeti.rightEyeTilt(42, 500);
    reeti.leftEyePan(40, 500);
    reeti.leftEyeTilt(42, 500);
    reeti.leftEyeLid(100, 500);
    reeti.rightEyeLid(100, 500);
    reeti.rightEar(50, 500);
    reeti.leftEar(50, 500);
    reeti.ledOFF();
    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
