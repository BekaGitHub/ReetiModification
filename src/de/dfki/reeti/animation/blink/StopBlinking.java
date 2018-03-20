package de.dfki.reeti.animation.blink;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Robbie
 */
public class StopBlinking extends AnimationReeti {

  public StopBlinking() {
    setAnimtype(ANIMTYPE.ON);
  }

  public StopBlinking(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (getReeti().blinking != null) {
      getReeti().blinking.stopBlinkAktion();
    }

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
