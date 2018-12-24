package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthRightCorner extends BodyPart {

  public MouthRightCorner.SHAPE mShape = MouthRightCorner.SHAPE.DEFAULT;

//  @Override
//  public void setShape(String s) {
//    MouthRightCorner.SHAPE shape = MouthRightCorner.SHAPE.valueOf(s);
//    mShape = (shape != null) ? shape : MouthRightCorner.SHAPE.DEFAULT;
//  }

  @Override
  public void calculate(int step) {
    MouthDownLip.getnstance().getDownLip().setStartY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }

  public enum SHAPE {
    DEFAULT, RIGHTCORNERACTION
  }
}
