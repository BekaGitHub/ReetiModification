/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.environment.SpeechBubbleFX;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Speaking extends AnimationReeti {

  public Speaking() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Speaking(Reeti reeti, int duration, boolean block) {
    super(reeti, duration, block);
  }

  @Override
  public void playAnimation() {
    if (parameter instanceof String) {
      getReeti().getSpeechBubbleFX().mText = (String) parameter;
    }

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentReeti(getReeti().getSpeechBubbleFX(), "shape",
            SpeechBubbleFX.SHAPE.SPEAK.name()));
    playAnimationPart(duration);

    animationContents
        .add(new AnimationContentReeti(getReeti().getSpeechBubbleFX(), "shape",
            SpeechBubbleFX.SHAPE.DEFAULT.name()));
    playAnimationPart(20);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }

  }
}
