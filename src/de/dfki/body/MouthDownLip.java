package de.dfki.body;

import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends ReetiBodyPart {

  public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;
  private Point2D downPoint;
  private Path mLips;

  private double downLipRegulator = 0;
  private double recorDownLipRegulator;

  public MouthDownLip(Mouth mouth) {
    mLips = mouth.getLips();
    downPoint = mouth.getDownPoint();
  }

  @Override
  public void setShape(String s) {
    MouthDownLip.SHAPE shape = MouthDownLip.SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : MouthDownLip.SHAPE.DEFAULT;
  }


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

  public void setDownLipRegulator(double downLipRegulator) {
    this.downLipRegulator = downLipRegulator;
  }

  public enum SHAPE {
    DEFAULT, DOWNLIPACTION
  }
}
