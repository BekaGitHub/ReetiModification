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
public class Sad2 extends AnimationReeti {

  public Sad2() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Sad2(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.leftEyeLid(45, 500);
    reeti.rightEyeLid(45, 500);
    reeti.leftEyeTilt(55, 500);
    reeti.leftEyePan(25, 500);
    reeti.rightEyeTilt(55, 500);
    reeti.rightEyePan(75, 500);
    reeti.leftEar(0, 500);
    reeti.rightEar(0, 500);
    reeti.rightLC(0, 500);
    reeti.leftLC(0, 500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
