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
public class Grimace extends AnimationReeti {

  public Grimace() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Grimace(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
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

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
