package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import java.util.concurrent.Semaphore;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public class Mouth extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private Timeline timeline;

  private MouthDownLip mouthDownLip;
  private MouthUpperLip mouthUpperLip;


  public Mouth(Head head, MouthDownLip mouthDownLip, MouthUpperLip mouthUpperLip) {
    this.mouthDownLip = mouthDownLip;
    this.mouthUpperLip = mouthUpperLip;

    head.getHeadGroup().getChildren()
        .addAll(mouthUpperLip.getUpperLip(), mouthDownLip.getDownLip());
    bindLipCorners();
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    switch (animationContentTest.getMouthPart()) {
      case UPPER_LIP:
        startUpperLipAnimation(animationContentTest);
        break;
      case DOWN_LIP:
        startDownLipAnimation(animationContentTest);
        break;
      case RIGHT_CORNER:
        startRightCornerAnimation(animationContentTest);
        break;
      case LEFT_CORNER:
        startLeftCornerAnimation(animationContentTest);
        break;
    }
    SEMAPHORE.release();
  }

  private void startUpperLipAnimation(AnimationContentTest animationContentTest) {
    startAnimation(mouthUpperLip.getUpperLip().controlYProperty(),
        animationContentTest.getPosition(),
        animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startDownLipAnimation(AnimationContentTest animationContentTest) {
    startAnimation(mouthDownLip.getDownLip().controlYProperty(), animationContentTest.getPosition(),
        animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startRightCornerAnimation(AnimationContentTest animationContentTest) {
    startAnimation(mouthUpperLip.getUpperLip().startYProperty(), animationContentTest.getPosition(),
        animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startLeftCornerAnimation(AnimationContentTest animationContentTest) {
    startAnimation(mouthUpperLip.getUpperLip().endYProperty(), animationContentTest.getPosition(),
        animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startAnimation(WritableValue<Number> target, Number endValue, int duration) {
    timeline = new Timeline();
    KeyValue keyValue = new KeyValue(target, endValue);
    KeyFrame keyFrame = new KeyFrame(Duration.millis(duration), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();
  }

  private void bindLipCorners() {
    mouthDownLip.getDownLip().startYProperty()
        .bindBidirectional(mouthUpperLip.getUpperLip().startYProperty());
    mouthDownLip.getDownLip().endYProperty()
        .bindBidirectional(mouthUpperLip.getUpperLip().endYProperty());
  }
}
