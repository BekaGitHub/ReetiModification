package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContent;
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
  public void onAnimation(AnimationContent animationContent) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    switch (animationContent.getMouthPart()) {
      case UPPER_LIP:
        startUpperLipAnimation(animationContent);
        break;
      case DOWN_LIP:
        startDownLipAnimation(animationContent);
        break;
      case RIGHT_CORNER:
        startRightCornerAnimation(animationContent);
        break;
      case LEFT_CORNER:
        startLeftCornerAnimation(animationContent);
        break;
    }
    SEMAPHORE.release();
  }

  private void startUpperLipAnimation(AnimationContent animationContent) {
    startAnimation(mouthUpperLip.getUpperLip().controlYProperty(),
        animationContent.getPosition(),
        animationContent.getAnimationsDauerInMillisekunden());
  }

  private void startDownLipAnimation(AnimationContent animationContent) {
    startAnimation(mouthDownLip.getDownLip().controlYProperty(), animationContent.getPosition(),
        animationContent.getAnimationsDauerInMillisekunden());
  }

  private void startRightCornerAnimation(AnimationContent animationContent) {
    startAnimation(mouthUpperLip.getUpperLip().startYProperty(), animationContent.getPosition(),
        animationContent.getAnimationsDauerInMillisekunden());
  }

  private void startLeftCornerAnimation(AnimationContent animationContent) {
    startAnimation(mouthUpperLip.getUpperLip().endYProperty(), animationContent.getPosition(),
        animationContent.getAnimationsDauerInMillisekunden());
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
