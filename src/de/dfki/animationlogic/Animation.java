package de.dfki.animationlogic;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Die Klasse ist zuständig, um eine Animation starten/pausieren/stopen.
 */
public class Animation {

  private Timeline timeline;

  public Timeline onAnimation(AnimationContent animationContent) {

    Rotation rotation = new Rotation();
    Rotate rotateX = rotation.createXRotation(animationContent);
    Rotate rotateY = rotation.createYRotation(animationContent);
    Rotate rotateZ = rotation.createZRotation(animationContent);

    animationContent.getKoerperteil().getTransforms().addAll(rotateX, rotateY, rotateZ);

    int animationsDauer = animationContent.getAnimationsDauerInMillisekunden();
    double rotationsGradAufXAxis = animationContent.getRotationsGradAufXAxis();
    double rotationsGradAufYAxis = animationContent.getRotationsGradAufYAxis();
    double rotationsGradAufZAxis = animationContent.getRotationsGradAufZAxis();

    timeline = new Timeline();
    KeyFrame xZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateX.angleProperty(), 0));
    KeyFrame xEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateX.angleProperty(), rotationsGradAufXAxis));
    KeyFrame yZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateY.angleProperty(), 0));
    KeyFrame yEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateY.angleProperty(), rotationsGradAufYAxis));
    KeyFrame zZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateZ.angleProperty(), 0));
    KeyFrame zEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateZ.angleProperty(), rotationsGradAufZAxis));

    timeline.getKeyFrames().addAll(xZero, xEnd, yZero, yEnd, zZero, zEnd);

    int animationCycleCounter = animationContent.getAnimationCycleCounter();
    if (animationCycleCounter != -1) {
      timeline.setAutoReverse(true);
      timeline.setCycleCount(animationCycleCounter);
    }
    timeline.play();
    return timeline;
  }

  public void pauseAnimation() {
    timeline.pause();
  }

  public void stopAnimation() {
    timeline.stop();
  }
}
