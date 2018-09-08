package de.dfki.animationlogic.commonlogic;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Die Klasse ist zuständig, um eine Animation auszuführen.
 */
public class AnimationTest {

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

    Timeline animationTimeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(rotateX.angleProperty(), 0)),
        new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateX.angleProperty(), rotationsGradAufXAxis)),

        new KeyFrame(Duration.ZERO, new KeyValue(rotateY.angleProperty(), 0)),
        new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateY.angleProperty(), rotationsGradAufYAxis)),

        new KeyFrame(Duration.ZERO, new KeyValue(rotateZ.angleProperty(), 0)),
        new KeyFrame(Duration.millis(animationsDauer), new KeyValue(rotateZ.angleProperty(), rotationsGradAufZAxis))
    );

    int animationCycleCounter = animationContentTest.getAnimationCycleCounter();
    if (animationCycleCounter != -1) {
      animationTimeline.setAutoReverse(true);
      animationTimeline.setCycleCount(animationCycleCounter);
    }
    animationTimeline.play();
  }
}
