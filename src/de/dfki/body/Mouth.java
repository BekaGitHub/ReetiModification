package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.util.Constants;
import java.awt.geom.Point2D;
import java.util.concurrent.Semaphore;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineJoin;

/**
 * @author Beka Aptsiauri
 */
public class Mouth extends Pane {

  private static final int MOUTH_LENGTH = 32;

  QuadCurve upperLipQuadCurve = new QuadCurve();
  QuadCurve downLipCuadCurve = new QuadCurve();

  public Point2D leftCorner;
  public Point2D rightCorner;
  public Point2D middleUpperPoint;
  public Point2D middleDownPoint;
  private Path mLips;

  private static final int MOUTH_START_POINT_X = -9;
  private static final int MOUTH_START_POINT_Y = 35;

  public Mouth(Head head) {
//    color = Color.DARKGREY;
    mLips = new Path();

    init();
    head.getHeadGroup().getChildren().addAll(upperLipQuadCurve, downLipCuadCurve);
  }

//  @Override
  public void init() {
    initialeMouthPoints();
    upperLipQuadCurve.setTranslateX(Constants.MOUTH_X_POSITION);
    upperLipQuadCurve.setTranslateY(Constants.MOUTH_Y_POSITION);
    upperLipQuadCurve.setTranslateZ(Constants.MOUTH_Z_POSITION);

    downLipCuadCurve.setTranslateX(Constants.MOUTH_X_POSITION);
    downLipCuadCurve.setTranslateY(Constants.MOUTH_Y_POSITION);
    downLipCuadCurve.setTranslateZ(Constants.MOUTH_Z_POSITION);
    createMouth();
  }

//  @Override
//  public void setShape(String s) {
//    Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
//  }


//  @Override
  public void calculate(int step) {

  }

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;

//  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    animationTest = new AnimationTest();
    animationTest.onAnimation(animationContentTest);
    SEMAPHORE.release();
  }

  private void initialeMouthPoints() {
    rightCorner = new Point2D.Double(MOUTH_START_POINT_X, MOUTH_START_POINT_Y);
    leftCorner = new Point2D.Double(rightCorner.getX() + MOUTH_LENGTH, rightCorner.getY());
    middleUpperPoint = new Point2D.Double(rightCorner.getX() + MOUTH_LENGTH / 2, rightCorner.getY());
    middleDownPoint = new Point2D.Double(middleUpperPoint.getX(), middleUpperPoint.getY());

    upperLipQuadCurve.setStartX(MOUTH_START_POINT_X);
    upperLipQuadCurve.setStartY(MOUTH_START_POINT_Y);
    upperLipQuadCurve.setControlX(MOUTH_START_POINT_X + MOUTH_LENGTH / 2);
    upperLipQuadCurve.setControlY(MOUTH_START_POINT_Y - 10);
    upperLipQuadCurve.setEndX(MOUTH_START_POINT_X + MOUTH_LENGTH);
    upperLipQuadCurve.setEndY(MOUTH_START_POINT_Y);

    downLipCuadCurve.setStartX(MOUTH_START_POINT_X);
    downLipCuadCurve.setStartY(MOUTH_START_POINT_Y);
    downLipCuadCurve.setControlX(MOUTH_START_POINT_X + MOUTH_LENGTH / 2);
    downLipCuadCurve.setControlY(MOUTH_START_POINT_Y + 10);
    downLipCuadCurve.setEndX(MOUTH_START_POINT_X + MOUTH_LENGTH);
    downLipCuadCurve.setEndY(MOUTH_START_POINT_Y);
  }

  private void createMouth() {
    addEffect();
    MoveTo startPoint = createStartPoint();
    QuadCurveTo upperLipPath = createUpperLipQuadCurve();
    QuadCurveTo downLipPath = createDownLipQuadCurve();
    mLips.getElements().add(startPoint);
    mLips.getElements().add(upperLipPath);
    mLips.getElements().add(downLipPath);
    mLips.getElements().add(new ClosePath());
  }

  private MoveTo createStartPoint() {
    return new MoveTo(rightCorner.getX(), rightCorner.getY());
  }

  private QuadCurveTo createUpperLipQuadCurve() {
    return new QuadCurveTo(middleUpperPoint.getX(), middleUpperPoint.getY(), leftCorner.getX(),
        leftCorner.getY());
  }

  private QuadCurveTo createDownLipQuadCurve() {
    return new QuadCurveTo(middleDownPoint.getX(), middleDownPoint.getY(), rightCorner.getX(),
        rightCorner.getY());
  }

  private void addEffect(){
    mLips.getElements().clear();
    mLips.setStrokeLineJoin(StrokeLineJoin.ROUND);
    mLips.setStrokeWidth(3);
//    mLips.setStroke(color);
    mLips.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 );");
  }


  public Path getLips() {
    return mLips;
  }

  public Point2D getLeftCorner() {
    return leftCorner;
  }

  public Point2D getRightCorner() {
    return rightCorner;
  }

  public Point2D getMiddleUpperPoint() {
    return middleUpperPoint;
  }

  public Point2D getMiddleDownPoint() {
    return middleDownPoint;
  }

  public enum SHAPE {
    DEFAULT, MOUTHACTION, MOUTHACTIONEND, LEFTCORNERACTION, LEFTCORNERACTIONEND, RIGHTCORNERACTION, RIGHTCORNERACTIONEND, OPEN,
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY
  }


}
