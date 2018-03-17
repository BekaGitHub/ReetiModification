package de.dfki.reeti.util;

import com.jfoenix.controls.JFXSlider;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.LeftEyelid;
import de.dfki.reeti.body.ReetiParts;
import de.dfki.reeti.body.RightEye;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class BodyPartsMovement {

  private BodyPartsMovement() {
  }

  public static void rotateHead(Head head, JFXSlider headRotationSlider, TextField headRotationTextField, Point3D axis) {
    headRotationSlider.setMin(0);
    headRotationSlider.setMax(100);
    headRotationSlider.setValue(50);

    rotate(headRotationSlider, axis, head, headRotationTextField, 50, 40, 100);
  }

  public static void rotateLeftEye(LeftEye leftEye, TextField leftEyeTextField, JFXSlider leftEyeSlider, Point3D axis) {
    leftEyeSlider.setMin(0);
    leftEyeSlider.setMax(100);
    leftEyeSlider.setValue(42);

    rotate(leftEyeSlider, axis, leftEye, leftEyeTextField, 42, 90, 100);
  }

  public static void rotateRightEye(RightEye rightEye, TextField rightEyeTextField, JFXSlider rightEyeSlider, Point3D axis) {
    rightEyeSlider.setMin(0);
    rightEyeSlider.setMax(100);
    rightEyeSlider.setValue(51);

    rotate(rightEyeSlider, axis, rightEye, rightEyeTextField, 51, 90, 100);
  }

  public static void rotateEyeLid(ReetiParts eyeLid, TextField eyeLidTextField, JFXSlider eyeLidSlider, Point3D axis) {
    eyeLidSlider.setMin(0);
    eyeLidSlider.setMax(100);
    eyeLidSlider.setValue(100);

    rotate(eyeLidSlider, axis, eyeLid, eyeLidTextField, 100, 100, 100);
  }

  public static void rotateEar(ReetiParts ear, TextField earTextField, JFXSlider earSlider, Point3D axis) {
    earSlider.setMin(0);
    earSlider.setMax(100);
    earSlider.setValue(50);

    rotate(earSlider, axis, ear, earTextField, 50, 50, 50);
  }

  private static void rotate(JFXSlider slider, Point3D axis, ReetiParts parts, TextField textField, int minusFactor, int multiplicationFactor, int divisionFactor) {
    slider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          double rotationGrad = (-(newValue - minusFactor) * multiplicationFactor) / divisionFactor;
          if (axis == Rotate.X_AXIS) {
            parts.xRotation = rotationGrad;
          } else if (axis == Rotate.Y_AXIS){
            parts.mYRotation = rotationGrad;
          } else {
            parts.mZRotation = rotationGrad;
          }
          textField.setText(Integer.toString((int) newValue));
          parts.calculate(0);
        });
  }

}
