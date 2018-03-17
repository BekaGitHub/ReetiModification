package de.dfki.reeti.util;

import com.jfoenix.controls.JFXSlider;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.stage.ReetiCamera;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;

public class BodyPartsMovement {

  private BodyPartsMovement () {}

  public static void rotateHead(Head head, JFXSlider headRotationSlider, Point3D axis) {
    headRotationSlider.setMin(0);
    headRotationSlider.setMax(100);
    headRotationSlider.setValue(50);

    headRotationSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
          double newValue = new_val.doubleValue();
          if (axis == Rotate.X_AXIS)
            head.xRotation = (-(newValue - 50) * 40) / 100;
          else if (axis == Rotate.Y_AXIS)
            head.mYRotation = -(newValue - 50);
          else
            head.mZRotation = ((newValue - 50) * 40) / 100;
          head.calculate(0);
        });
  }

}
