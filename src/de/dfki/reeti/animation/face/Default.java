/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class Default extends AnimationReeti {

  public Default() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Default(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
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
    reeti.setLedColor("stop");
    if (ReetiStageController.currentRadioButton != null) {
      ReetiStageController.currentRadioButton.setSelected(false);
    }
  }
}
