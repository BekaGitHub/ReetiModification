package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.main.Constants;
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
  public void onAnimation(AnimationContentTest animationContentTest) {
    createTimeline(animationContentTest, upperLip.controlYProperty()).play();
  }

  double calculateMovementPosition(double position) {
    return 35 - (position / 5);
  }
}
