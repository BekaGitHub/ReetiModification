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

//  @Override
//  public void setShape(String s) {
//    MouthLeftCorner.SHAPE shape = MouthLeftCorner.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : MouthLeftCorner.SHAPE.DEFAULT;
//  }

  @Override
  public void calculate(int step) {
    MouthUpperLip.getnstance().getUpperLip().setEndY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }

  public enum SHAPE {
    DEFAULT, LEFTCORNERACTION
  }
}
