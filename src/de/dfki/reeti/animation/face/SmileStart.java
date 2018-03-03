package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

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
    reeti.setLedColor("green", Reeti.LED.LEFTLED);
    reeti.setLedColor("red", Reeti.LED.RIGHTLED);
    reeti.leftEar(100);
    reeti.rightEar(100);
  }
}
