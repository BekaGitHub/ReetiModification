package de.dfki.animationlogic.commonlogic;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Die Klasse ist zuständig, um eine Animation starten/pausieren/stopen.
 */
public class AnimationTest {

  private Timeline timeline;

  public void onAnimation(AnimationContentTest animationContentTest) {

    Rotation rotation = new Rotation();
    Rotate rotateX = rotation.createXRotation(animationContentTest);
    Rotate rotateY = rotation.createYRotation(animationContentTest);
    Rotate rotateZ = rotation.createZRotation(animationContentTest);

    animationContentTest.getKoerperteil().getTransforms().addAll(rotateX, rotateY, rotateZ);

    int animationsDauer = animationContentTest.getAnimationsDauerInSekunden();
    double rotationsGradAufXAxis = animationContentTest.getRotationsGradAufXAxis();
    double rotationsGradAufYAxis = animationContentTest.getRotationsGradAufYAxis();
    double rotationsGradAufZAxis = animationContentTest.getRotationsGradAufZAxis();

    timeline = new Timeline();
    KeyFrame xZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateX.angleProperty(), 0));
    KeyFrame xEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateX.angleProperty(), rotationsGradAufXAxis));
    KeyFrame yZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateY.angleProperty(), 0));
    KeyFrame yEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateY.angleProperty(), rotationsGradAufYAxis));
    KeyFrame zZero = new KeyFrame(Duration.ZERO, new KeyValue(rotateZ.angleProperty(), 0));
    KeyFrame zEnd = new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateZ.angleProperty(), rotationsGradAufZAxis));

    timeline.getKeyFrames().addAll(xZero, xEnd, yZero, yEnd, zZero, zEnd);

    int animationCycleCounter = animationContentTest.getAnimationCycleCounter();
    if (animationCycleCounter != -1) {
      timeline.setAutoReverse(true);
      timeline.setCycleCount(animationCycleCounter);
    }
    timeline.play();
  }

  public void pauseAnimation() {
    timeline.pause();
  }

  public void stopAnimation() {
    timeline.stop();
  }
}