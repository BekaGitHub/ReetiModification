package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import javafx.animation.Timeline;
import javafx.scene.shape.QuadCurve;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends Lip {

  private static MouthDownLip mouthDownLipInstance = null;

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;

  public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;

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

//  @Override
//  public void setShape(String s) {
//    MouthDownLip.SHAPE shape = MouthDownLip.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : MouthDownLip.SHAPE.DEFAULT;
//  }


  @Override
  public void calculate(int step) {
    downLip.setControlY(step);
  }

  Timeline timeline;

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    int animationsDauer = animationContentTest.getAnimationsDauerInMillisekunden();
    double position = animationContentTest.getPosition();

    timeline = new Timeline();
//    KeyValue kv = new KeyValue(mouth.getMiddleDownPoint(), 300);
    SEMAPHORE.release();
  }

  public enum SHAPE {
    DEFAULT, DOWNLIPACTION
  }
}
