package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import de.dfki.main.Constants;
import javafx.animation.Timeline;
import javafx.scene.shape.QuadCurve;

/**
 * @author Beka Aptsiauri
 */
public class MouthUpperLip extends Lip {

  private static MouthUpperLip mouthUpperLipInstance = null;

  QuadCurve upperLip = new QuadCurve();

  private MouthUpperLip() {
    upperLip.setTranslateX(Constants.MOUTH_X_POSITION);
    upperLip.setTranslateY(Constants.MOUTH_Y_POSITION);
    upperLip.setTranslateZ(Constants.MOUTH_Z_POSITION);
    createLip(upperLip);
  }

  public static MouthUpperLip getnstance() {
    if (mouthUpperLipInstance == null) {
      mouthUpperLipInstance = new MouthUpperLip();
    }
    return mouthUpperLipInstance;
  }

  public QuadCurve getUpperLip() {
    return upperLip;
  }

  @Override
  public void calculate(int step) {
    upperLip.setControlY(step);
  }

  @Override
  public Timeline onAnimation(AnimationContent animationContent) {
    createTimeline(animationContent, upperLip.controlYProperty()).play();
    return null;
  }

  double calculateMovementPosition(double position) {
    return 35 - (position / 5);
  }
}
