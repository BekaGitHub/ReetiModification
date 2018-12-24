package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.style.Effect;
import de.dfki.main.Constants;
import javafx.scene.shape.QuadCurve;

public class Lip extends BodyPart {

  public void createLip(QuadCurve lip) {
    lip.setStartX(Constants.MOUTH_START_POINT_X);
    lip.setStartY(Constants.MOUTH_START_POINT_Y);
    lip.setControlX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH / 2);
    lip.setControlY(Constants.MOUTH_START_POINT_Y);
    lip.setEndX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH);
    lip.setEndY(Constants.MOUTH_START_POINT_Y);
    new Effect().addEffect(lip);
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }
}
