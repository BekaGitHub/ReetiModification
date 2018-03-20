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
public class Sunbathing extends AnimationReeti {

  public Sunbathing() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Sunbathing(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
    reeti.leftEyeLid(0);
    reeti.rightEyeLid(0);
    reeti.ledON(Color.RED, Led.BOTH);
    reeti.leftEar(0);
    reeti.rightEar(0);
    reeti.rightLC(40);
    reeti.leftLC(80);
    reeti.neckTilt(85);
    reeti.topLip(20);
    reeti.bottomLip(50);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
