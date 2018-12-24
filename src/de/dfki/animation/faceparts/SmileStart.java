package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.animation.Led;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class SmileStart extends AnimationReeti {

  public SmileStart(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Reeti reeti = ((Reeti) agent);
    reeti.bottomLip(50, 500);
    reeti.leftLC(70, 500);
    reeti.rightLC(70, 500);
    reeti.ledON(Color.GREEN, Led.LEFT);
    reeti.ledON(Color.RED, Led.RIGHT);
    reeti.leftEar(100, 500);
    reeti.rightEar(100, 500);
  }
}
