package de.dfki.animation.blink;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.reeti.ReetiController;
import de.dfki.util.AnimationVisivility;

/**
 * @author Robbie
 */
public class StopBlinking extends AnimationReeti {

  public StopBlinking() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public StopBlinking(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (((Reeti) agent).blinking != null) {
      ((Reeti) agent).blinking.stopBlinkAktion();
    }

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
