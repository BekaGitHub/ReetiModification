/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.animationlogic.reeti.AnimationReeti;
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
    Reeti reeti = ((Reeti)agent);
    reeti.leftEyeLid(45);
    reeti.rightEyeLid(45);
    reeti.leftEyeTilt(55);
    reeti.leftEyePan(25);
    reeti.rightEyeTilt(55);
    reeti.rightEyePan(75);
    reeti.leftEar(0);
    reeti.rightEar(0);
    reeti.rightLC(0);
    reeti.leftLC(0);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
