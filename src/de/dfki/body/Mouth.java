package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.util.Constants;
import java.util.concurrent.Semaphore;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public class Mouth extends BodyPart {

  private static final int MOUTH_START_POINT_X = -9;
  private static final int MOUTH_START_POINT_Y = 35;
  private static final int MOUTH_LENGTH = 32;

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private Timeline timeline;

  QuadCurve upperLipQuadCurve = new QuadCurve();
  QuadCurve downLipCuadCurve = new QuadCurve();


  public Mouth(Head head) {
    //Setze Anfangsposition des upperLips
    upperLipQuadCurve.setTranslateX(Constants.MOUTH_X_POSITION);
    upperLipQuadCurve.setTranslateY(Constants.MOUTH_Y_POSITION);
    upperLipQuadCurve.setTranslateZ(Constants.MOUTH_Z_POSITION);
    //Setze Angangsposition des downLips
    downLipCuadCurve.setTranslateX(Constants.MOUTH_X_POSITION);
    downLipCuadCurve.setTranslateY(Constants.MOUTH_Y_POSITION);
    downLipCuadCurve.setTranslateZ(Constants.MOUTH_Z_POSITION-1);

    head.getHeadGroup().getChildren().addAll(upperLipQuadCurve, downLipCuadCurve);
    createMouth();
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
    startAnimation(upperLipQuadCurve.controlYProperty(), animationContentTest.getPosition(), animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startDownLipAnimation(AnimationContentTest animationContentTest) {
    startAnimation(downLipCuadCurve.controlYProperty(), animationContentTest.getPosition(), animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startRightCornerAnimation(AnimationContentTest animationContentTest) {
    startAnimation(upperLipQuadCurve.startYProperty(), animationContentTest.getPosition(), animationContentTest.getAnimationsDauerInMillisekunden());
  }

  private void startLeftCornerAnimation(AnimationContentTest animationContentTest) {
    startAnimation(upperLipQuadCurve.endYProperty(), animationContentTest.getPosition(), animationContentTest.getAnimationsDauerInMillisekunden());
  }
  private void startAnimation(WritableValue<Number> target, Number endValue, int duration) {
    timeline = new Timeline();
    KeyValue keyValue = new KeyValue(target, endValue);
    KeyFrame keyFrame = new KeyFrame(Duration.millis(duration), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();
  }

  private void createMouth() {
    createUpperLip();
    createDownLip();
    bindLipCorners();
  }

  private void createUpperLip() {
    upperLipQuadCurve.setStartX(MOUTH_START_POINT_X);
    upperLipQuadCurve.setStartY(MOUTH_START_POINT_Y);
    upperLipQuadCurve.setControlX(MOUTH_START_POINT_X + MOUTH_LENGTH / 2);
    upperLipQuadCurve.setControlY(MOUTH_START_POINT_Y - 10);
    upperLipQuadCurve.setEndX(MOUTH_START_POINT_X + MOUTH_LENGTH);
    upperLipQuadCurve.setEndY(MOUTH_START_POINT_Y);
    addEffect(upperLipQuadCurve);
  }

  private void createDownLip() {
    downLipCuadCurve.setStartX(MOUTH_START_POINT_X);
    downLipCuadCurve.setStartY(MOUTH_START_POINT_Y);
    downLipCuadCurve.setControlX(MOUTH_START_POINT_X + MOUTH_LENGTH / 2);
    downLipCuadCurve.setControlY(MOUTH_START_POINT_Y + 10);
    downLipCuadCurve.setEndX(MOUTH_START_POINT_X + MOUTH_LENGTH);
    downLipCuadCurve.setEndY(MOUTH_START_POINT_Y);
    addEffect(downLipCuadCurve);
  }

  private void bindLipCorners() {
    downLipCuadCurve.startYProperty().bindBidirectional(upperLipQuadCurve.startYProperty());
    downLipCuadCurve.endYProperty().bindBidirectional(upperLipQuadCurve.endYProperty());
  }

  private void addEffect(QuadCurve lipQadCurve){
    lipQadCurve.setStroke(Color.BLACK);
    lipQadCurve.setStrokeWidth(1);
    lipQadCurve.setFill(Color.GRAY.brighter());
  }
}
