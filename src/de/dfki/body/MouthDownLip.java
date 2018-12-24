package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.main.Constants;
import javafx.scene.shape.QuadCurve;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends Lip {

  private static MouthDownLip mouthDownLipInstance = null;

  private QuadCurve downLip = new QuadCurve();

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
    createTimeline(animationContentTest, downLip.controlYProperty()).play();
  }

  double calculateMovementPosition(double position) {
    return 35 - (-position / 6);
  }
}
