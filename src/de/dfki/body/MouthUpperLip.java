package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.main.Constants;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public class MouthUpperLip extends Lip {

  private static MouthUpperLip mouthUpperLipInstance = null;

  QuadCurve upperLip = new QuadCurve();
  private Timeline timeline;
  private KeyValue keyValue;
  private KeyFrame keyFrame;


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
    timeline = new Timeline();
    keyValue = new KeyValue(upperLip.controlYProperty(),
        calculateMovementPosition(animationContentTest.getPosition()));
    keyFrame = new KeyFrame(
        Duration.millis(animationContentTest.getAnimationsDauerInMillisekunden()), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();
  }

  private double calculateMovementPosition(double position) {
    return 35 - (position / 5);
  }
}
