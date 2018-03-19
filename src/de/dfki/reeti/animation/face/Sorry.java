/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.util.Led;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class Sorry extends AnimationReeti {

  public Sorry() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Sorry(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = getReeti();
    reeti.neckPan(20);
    reeti.neckTilt(30);
    reeti.leftEyeLid(30);
    reeti.rightEyeLid(30);
    reeti.leftEyeTilt(20);
    reeti.rightEyeTilt(20);
    reeti.ledON(Color.VIOLET.GREEN.brighter(), Led.BOTH);
    reeti.leftEar(20);
    reeti.rightEar(30);
    reeti.rightLC(10);
    reeti.leftLC(10);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
