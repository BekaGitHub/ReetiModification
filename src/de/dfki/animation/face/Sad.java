/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.face;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.util.Led;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class Sad extends AnimationReeti {

  public Sad() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Sad(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
    reeti.leftEyeLid(60);
    reeti.rightEyeLid(60);
    reeti.leftEyeTilt(15);
    reeti.rightEyeTilt(15);
    reeti.ledON(Color.VIOLET, Led.BOTH);
    reeti.leftEar(0);
    reeti.rightEar(0);
    reeti.rightLC(0);
    reeti.leftLC(0);
    reeti.neckTilt(0);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
