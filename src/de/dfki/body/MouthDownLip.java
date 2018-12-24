package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends Lip {

  private static MouthDownLip mouthDownLipInstance = null;

  private QuadCurve downLip = new QuadCurve();
  private Timeline timeline;
  private KeyValue keyValue;
  private KeyFrame keyFrame;

  private MouthDownLip() {
    downLip.setTranslateX(Constants.MOUTH_X_POSITION);
    downLip.setTranslateY(Constants.MOUTH_Y_POSITION);
    downLip.setTranslateZ(Constants.MOUTH_Z_POSITION - 1);
    createLip(downLip);
  }

  public static MouthDownLip getnstance() {
    if (mouthDownLipInstance == null) {
      mouthDownLipInstance = new MouthDownLip();
    }
    return mouthDownLipInstance;
  }

  public QuadCurve getDownLip() {
    return downLip;
  }

  @Override
  public void calculate(int step) {
    downLip.setControlY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    timeline = new Timeline();
    keyValue = new KeyValue(downLip.controlYProperty(),
        calculateMovementPosition(animationContentTest.getPosition()));
    keyFrame = new KeyFrame(
        Duration.millis(animationContentTest.getAnimationsDauerInMillisekunden()), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();
  }

  private double calculateMovementPosition(double position) {
    return 35 - (-position / 6);
  }
}
