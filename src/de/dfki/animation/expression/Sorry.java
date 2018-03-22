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
public class Sorry extends AnimationReeti {

  public Sorry() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Sorry(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.neckPan(20, 500);
    reeti.neckTilt(30, 500);
    reeti.leftEyeLid(30, 500);
    reeti.rightEyeLid(30, 500);
    reeti.leftEyeTilt(20, 500);
    reeti.rightEyeTilt(20, 500);
    reeti.ledON(Color.VIOLET.GREEN.brighter(), Led.BOTH);
    reeti.leftEar(20, 500);
    reeti.rightEar(30, 500);
    reeti.rightLC(10, 500);
    reeti.leftLC(10, 500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
