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
import de.dfki.util.Led;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class Sad extends AnimationReeti {

  public Sad() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Sad(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.leftEyeLid(60, 500);
    reeti.rightEyeLid(60, 500);
    reeti.leftEyeTilt(15, 500);
    reeti.rightEyeTilt(15, 500);
    reeti.ledON(Color.VIOLET, Led.BOTH);
    reeti.leftEar(0, 500);
    reeti.rightEar(0, 500);
    reeti.rightLC(0, 500);
    reeti.leftLC(0, 500);
    reeti.neckTilt(0, 500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
