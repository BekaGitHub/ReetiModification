package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import javafx.animation.Timeline;

/**
 * @author Beka Aptsiauri
 */
public class MouthRightCorner extends Lip {

  private MouthUpperLip mouthUpperLip;

  public MouthRightCorner(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  @Override
  public void calculate(int step) {
    MouthDownLip.getnstance().getDownLip().setStartY(step);
  }

  @Override
  public Timeline onAnimation(AnimationContent animationContent) {
    createTimeline(animationContent, mouthUpperLip.getUpperLip().startYProperty()).play();
    return null;
  }

  double calculateMovementPosition(double position) {
    return 25 + (position / 5);
  }
}
