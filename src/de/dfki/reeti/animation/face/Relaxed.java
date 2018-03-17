/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class Relaxed extends AnimationReeti {

  public Relaxed() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Relaxed(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
    reeti.neckTilt(75);
    reeti.leftEyeLid(25);
    reeti.rightEyeLid(25);
    reeti.leftEyeTilt(15);
    reeti.rightEyeTilt(20);
    reeti.setLedColor("green");
    reeti.leftEar(0);
    reeti.rightEar(0);
    reeti.leftLC(75);
    reeti.rightLC(60);
    reeti.bottomLip(10);
    reeti.topLip(3);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
