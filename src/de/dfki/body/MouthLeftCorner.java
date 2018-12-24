package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.awt.geom.Point2D;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public class MouthLeftCorner extends BodyPart {

  private MouthUpperLip mouthUpperLip;

  public MouthLeftCorner(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  @Override
  public void calculate(int step) {
    MouthUpperLip.getnstance().getUpperLip().setEndY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    Timeline timeline = new Timeline();
    KeyValue keyValue = new KeyValue(mouthUpperLip.getUpperLip().endYProperty(), calculateMovementPosition(animationContentTest.getPosition()));
    KeyFrame keyFrame = new KeyFrame(Duration.millis(animationContentTest.getAnimationsDauerInMillisekunden()), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();
  }

  private double calculateMovementPosition(double position) {
    return 25 + (position/5);
  }
}
