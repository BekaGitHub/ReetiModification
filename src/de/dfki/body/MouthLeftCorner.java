package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthLeftCorner extends BodyPart {

  public MouthLeftCorner.SHAPE mShape = MouthLeftCorner.SHAPE.DEFAULT;
  private Path mLips;
  private Point2D leftCorner;

  private double leftCornerRegulator = 0;
  private double recordLeftCornerRegulator;

  public MouthLeftCorner(Mouth mouth) {
    mLips = mouth.getLips();
    leftCorner = mouth.getLeftCorner();
  }

//  @Override
//  public void setShape(String s) {
//    MouthLeftCorner.SHAPE shape = MouthLeftCorner.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : MouthLeftCorner.SHAPE.DEFAULT;
//  }

  @Override
  public void calculate(int step) {
    switch (mShape) {
      case DEFAULT:
        break;

      case LEFTCORNERACTION:
        if (step == 20) {
          recordLeftCornerRegulator = leftCornerRegulator;
          leftCornerRegulator = leftCorner.getY();
        }

        leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.MAX_ANIM_STEPS;
        leftCorner.setLocation(leftCorner.getX(), leftCornerRegulator);
        QuadCurveTo leftQuadCurveTo = (QuadCurveTo) mLips.getElements().get(1);

        leftQuadCurveTo.setX(leftCorner.getX());
        leftQuadCurveTo.setY(leftCornerRegulator);
        mLips.getElements().set(1, leftQuadCurveTo);
        break;
    }
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }

  public void setLeftCornerRegulator(double rightCornerRegler) {
    this.leftCornerRegulator = rightCornerRegler;
  }

  public enum SHAPE {
    DEFAULT, LEFTCORNERACTION
  }
}
