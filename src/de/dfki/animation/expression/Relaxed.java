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
public class Relaxed extends AnimationReeti {

  public Relaxed() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Relaxed(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }


  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.neckTilt(75, 500);
    reeti.leftEyeLid(25, 500);
    reeti.rightEyeLid(25, 500);
    reeti.leftEyeTilt(15, 500);
    reeti.rightEyeTilt(20, 500);
    reeti.ledON(Color.GREEN, Led.BOTH);
    reeti.leftEar(0, 500);
    reeti.rightEar(0, 500);
    reeti.leftLC(75, 500);
    reeti.rightLC(60, 500);
    reeti.bottomLip(10, 500);
    reeti.topLip(3, 500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
