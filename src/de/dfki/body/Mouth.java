package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.util.Constants;
import java.util.concurrent.Semaphore;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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

  private AnimationTest animationTest;
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
    downLipCuadCurve.setTranslateY(Constants.MOUTH_Y_POSITION-0.5);
    downLipCuadCurve.setTranslateZ(Constants.MOUTH_Z_POSITION);

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
    int animationsDauer = animationContentTest.getAnimationsDauerInMillisekunden();
    int position = animationContentTest.getPosition();
    timeline = new Timeline();
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.setAutoReverse(true);
    final KeyValue kv = new KeyValue(upperLipQuadCurve.controlYProperty(), 2);
    final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
    timeline.getKeyFrames().addAll(kf);
    timeline.play();
    SEMAPHORE.release();
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


  public enum SHAPE {
    DEFAULT, MOUTHACTION, MOUTHACTIONEND, LEFTCORNERACTION, LEFTCORNERACTIONEND, RIGHTCORNERACTION, RIGHTCORNERACTIONEND, OPEN,
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY
  }


}
