package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import java.util.concurrent.Semaphore;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;

  public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;
  private Point2D downPoint;
  private Path mLips;

  private double downLipRegulator = 0;
  private double recorDownLipRegulator;
  Mouth mouth;

  public MouthDownLip(Mouth mouth) {
    this.mouth = mouth;
    mLips = mouth.getLips();
    downPoint = mouth.getMiddleDownPoint();
  }

//  @Override
//  public void setShape(String s) {
//    MouthDownLip.SHAPE shape = MouthDownLip.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : MouthDownLip.SHAPE.DEFAULT;
//  }


  @Override
  public void calculate(int step) {

    switch (mShape) {
      case DEFAULT:
        break;

      case DOWNLIPACTION:
        if (step == 20) {
          recorDownLipRegulator = downLipRegulator;
          downLipRegulator = downPoint.getY();
        }

        downLipRegulator += recorDownLipRegulator / AnimatorReeti.MAX_ANIM_STEPS;
        downPoint.setLocation(downPoint.getX(), downLipRegulator);

        QuadCurveTo quadCurveTo = (QuadCurveTo) mLips.getElements().get(2);

        quadCurveTo.setControlX(downPoint.getX());
        quadCurveTo.setControlY(downPoint.getY());
        mLips.getElements().set(2, quadCurveTo);
        break;
    }
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
    int position = animationContentTest.getPosition();

    timeline = new Timeline();
//    KeyValue kv = new KeyValue(mouth.getMiddleDownPoint(), 300);
    SEMAPHORE.release();
  }

  public void setDownLipRegulator(double downLipRegulator) {
    this.downLipRegulator = downLipRegulator;
  }

  public enum SHAPE {
    DEFAULT, DOWNLIPACTION
  }
}
