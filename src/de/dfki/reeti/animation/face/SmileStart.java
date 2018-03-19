package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.util.Led;
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
    Reeti reeti = getReeti();
    reeti.bottomLip(50);
    reeti.leftLC(70);
    reeti.rightLC(70);
    reeti.ledON(Color.GREEN, Led.LEFT);
    reeti.ledON(Color.RED, Led.RIGHT);
    reeti.leftEar(100);
    reeti.rightEar(100);
  }
}
