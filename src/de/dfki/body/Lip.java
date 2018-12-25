package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.main.Constants;
import de.dfki.style.Effect;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

public abstract class Lip extends BodyPart {

  public void createLip(QuadCurve lip) {
    lip.setStartX(Constants.MOUTH_START_POINT_X);
    lip.setStartY(Constants.MOUTH_START_POINT_Y);
    lip.setControlX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH / 2);
    lip.setControlY(Constants.MOUTH_START_POINT_Y);
    lip.setEndX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH);
    lip.setEndY(Constants.MOUTH_START_POINT_Y);
    new Effect().addEffect(lip);
  }

  Timeline createTimeline(AnimationContent animationContent, DoubleProperty property) {
    Timeline timeline = new Timeline();

    KeyValue keyValue = new KeyValue(property,
        calculateMovementPosition(animationContent.getPosition()));
    KeyFrame keyFrame = new KeyFrame(
        Duration.millis(animationContent.getAnimationsDauerInMillisekunden()), keyValue);
    timeline.getKeyFrames().add(keyFrame);
    return timeline;
  }

  abstract double calculateMovementPosition(double position);
}
