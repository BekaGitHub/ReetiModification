package de.dfki.body;

import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthUpperLip extends BodyPart {

  public MouthUpperLip.SHAPE mShape = MouthUpperLip.SHAPE.DEFAULT;
  private Point2D upperPoint;
  private Path mLips;

  private double upperLipRegulator = 0;
  private double recordupperLipRegulator;

  public MouthUpperLip(Mouth mouth) {
    mLips = mouth.getLips();
    upperPoint = mouth.getUpperPoint();
  }

  @Override
  public void setShape(String s) {
    MouthUpperLip.SHAPE shape = MouthUpperLip.SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : MouthUpperLip.SHAPE.DEFAULT;
  }


  @Override
  public void calculate(int step) {

    switch (mShape) {
      case DEFAULT:
        break;

      case UPPERLIPACTION:
        if (step == 20) {
          recordupperLipRegulator = upperLipRegulator;
          upperLipRegulator = upperPoint.getY();
        }

        upperLipRegulator += recordupperLipRegulator / AnimatorReeti.MAX_ANIM_STEPS;
        upperPoint.setLocation(upperPoint.getX(), upperLipRegulator);

        QuadCurveTo quadCurveTo = (QuadCurveTo) mLips.getElements().get(1);

        quadCurveTo.setControlX(upperPoint.getX());
        quadCurveTo.setControlY(upperPoint.getY());
        mLips.getElements().set(1, quadCurveTo);
        break;
    }
  }

  public void setUpperLipRegulator(double upperLipRegulator) {
    this.upperLipRegulator = upperLipRegulator;
  }

  public enum SHAPE {
    DEFAULT, UPPERLIPACTION
  }

}
