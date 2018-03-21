package de.dfki.animation.expression;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.AnimationVisivility;
import de.dfki.util.Led;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class Smile extends AnimationReeti {

  public Smile() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Smile(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti)agent);
    reeti.bottomLip(50);
    reeti.leftLC(70);
    reeti.rightLC(70);
    reeti.ledON(Color.GREEN, Led.LEFT);
    reeti.ledON(Color.RED, Led.RIGHT);
    reeti.leftEar(100);
    reeti.rightEar(100);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
