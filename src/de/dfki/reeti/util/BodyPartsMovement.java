package de.dfki.reeti.util;

import com.jfoenix.controls.JFXSlider;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.ReetiParts;
import de.dfki.reeti.body.RightEye;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class BodyPartsMovement {

  private BodyPartsMovement() {
  }

  public static void rotateHead(Head head, JFXSlider headRotationSlider, Point3D axis) {
    headRotationSlider.setMin(0);
    headRotationSlider.setMax(100);
    headRotationSlider.setValue(50);

    headRotationSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
          double newValue = new_val.doubleValue();
          if (axis == Rotate.X_AXIS) {
            head.xRotation = (-(newValue - 50) * 40) / 100;
          } else if (axis == Rotate.Y_AXIS) {
            head.mYRotation = -(newValue - 50);
          } else {
            head.mZRotation = ((newValue - 50) * 40) / 100;
          }
          head.calculate(0);
        });
  }

  public static void rotateLeftEye(LeftEye leftEye, TextField leftEyeTextField, JFXSlider leftEyeSlider, Point3D axis) {
    leftEyeSlider.setMin(0);
    leftEyeSlider.setMax(100);
    leftEyeSlider.setValue(42);

    leftEyeSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          if (axis == Rotate.X_AXIS) {
            leftEye.xRotation = (-(newValue - 47) * 90) / 100;
          } else {
            leftEye.mYRotation = (-(newValue - 42) * 90) / 100;
          }

          leftEyeTextField.setText(Integer.toString((int) newValue));
          leftEye.calculate(0);
        });
  }

  public static void rotateRightEye(RightEye rightEye, TextField rightEyeTextField, JFXSlider rightEyeSlider, Point3D axis) {
    rightEyeSlider.setMin(0);
    rightEyeSlider.setMax(100);
    if (axis == Rotate.X_AXIS)
      rightEyeSlider.setValue(47);
    else
      rightEyeSlider.setValue(65);

    rightEyeSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          if (axis == Rotate.X_AXIS) {
            rightEye.xRotation = (-(newValue - 51) * 90) / 100;
          } else {
            rightEye.mYRotation = (-(newValue - 65) * 90) / 100;
          }

          rightEyeTextField.setText(Integer.toString((int) newValue));
          rightEye.calculate(0);
        });
  }

}
