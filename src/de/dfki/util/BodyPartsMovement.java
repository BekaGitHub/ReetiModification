package de.dfki.util;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.body.Head;
import de.dfki.body.LeftEye;
import de.dfki.body.MouthDownLip;
import de.dfki.body.MouthLeftCorner;
import de.dfki.body.MouthRightCorner;
import de.dfki.body.MouthUpperLip;
import de.dfki.body.RightEye;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class BodyPartsMovement {

  private BodyPartsMovement() {
  }

  public static void rotateHead(Head head, JFXSlider headRotationSlider,
      TextField headRotationTextField, Point3D axis) {
    headRotationSlider.setMin(0);
    headRotationSlider.setMax(100);
    headRotationSlider.setValue(50);

    rotate(headRotationSlider, axis, head, headRotationTextField, 50, 40, 100);
  }

  public static void rotateLeftEye(LeftEye leftEye, TextField leftEyeTextField,
      JFXSlider leftEyeSlider, Point3D axis) {
    leftEyeSlider.setMin(0);
    leftEyeSlider.setMax(100);
    leftEyeSlider.setValue(42);

    rotate(leftEyeSlider, axis, leftEye, leftEyeTextField, 42, 90, 100);
  }

  public static void rotateRightEye(RightEye rightEye, TextField rightEyeTextField,
      JFXSlider rightEyeSlider, Point3D axis) {
    rightEyeSlider.setMin(0);
    rightEyeSlider.setMax(100);
    rightEyeSlider.setValue(51);

    rotate(rightEyeSlider, axis, rightEye, rightEyeTextField, 51, 90, 100);
  }

  public static void rotateEyeLid(BodyPart eyeLid, TextField eyeLidTextField,
      JFXSlider eyeLidSlider, Point3D axis) {
    eyeLidSlider.setMin(0);
    eyeLidSlider.setMax(100);
    eyeLidSlider.setValue(100);

    rotate(eyeLidSlider, axis, eyeLid, eyeLidTextField, 100, 100, 100);
  }

  public static void rotateEar(BodyPart ear, TextField earTextField, JFXSlider earSlider,
      Point3D axis) {
    earSlider.setMin(0);
    earSlider.setMax(100);
    earSlider.setValue(50);

    rotate(earSlider, axis, ear, earTextField, 50, 50, 50);
  }

  public static void moveMouthLeftCorner(MouthLeftCorner mouthLeftCorner,
      JFXSlider mouthLeftCornerSlider, TextField mouthLeftCornerTextField) {
    mouthLeftCornerSlider.setMin(-100);
    mouthLeftCornerSlider.setMax(0);
    mouthLeftCornerSlider.setValue(-50);

    moveLip(mouthLeftCornerSlider, mouthLeftCorner, mouthLeftCornerTextField, "LEFTCORNERACTION",
        170, 16, 100);
  }

  public static void moveMouthRightCorner(MouthRightCorner mouthRightCorner,
      JFXSlider mouthRightCornerSlider, TextField mouthRightCornerTextField) {
    mouthRightCornerSlider.setMin(-100);
    mouthRightCornerSlider.setMax(0);
    mouthRightCornerSlider.setValue(-50);

    moveLip(mouthRightCornerSlider, mouthRightCorner, mouthRightCornerTextField,
        "RIGHTCORNERACTION", 170, 16, 100);
  }

  public static void moveMouthUpperLip(MouthUpperLip mouthUpperLip, JFXSlider mouthUpperLipSlider,
      TextField mouthUpperLipTextField) {
    mouthUpperLipSlider.setMin(-100);
    mouthUpperLipSlider.setMax(0);
    mouthUpperLipSlider.setValue(-100);

    moveLip(mouthUpperLipSlider, mouthUpperLip, mouthUpperLipTextField, "UPPERLIPACTION", 107, 16,
        100);
  }

  public static void moveMouthBottomLip(MouthDownLip mouthDownLip, JFXSlider mouthDownLipSlider,
      TextField mouthDownLipTextField) {
    mouthDownLipSlider.setMin(0);
    mouthDownLipSlider.setMax(100);
    mouthDownLipSlider.setValue(0);

    moveLip(mouthDownLipSlider, mouthDownLip, mouthDownLipTextField, "DOWNLIPACTION", 217, 16, 100);
  }

  private static BodyPart moveLip(JFXSlider lipSlider, BodyPart lip,
      TextField lipTextField,
      String action, int plusFactor, int multiplicationFactor, int divisionFactor) {
    lipSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
//          lip.setShape(action);
          double SliderValue = (newValue + plusFactor) * multiplicationFactor / divisionFactor;
          if (lip instanceof MouthDownLip) {
            ((MouthDownLip) lip).setDownLipRegulator(SliderValue);
          } else if (lip instanceof MouthUpperLip) {
            ((MouthUpperLip) lip).setUpperLipRegulator(SliderValue);
          } else if (lip instanceof MouthRightCorner) {
            ((MouthRightCorner) lip).setRightCornerRegulator(SliderValue);
          } else {
            ((MouthLeftCorner) lip).setLeftCornerRegulator(SliderValue);
          }
          int fieldValue = (int) (newValue);
          lipTextField.setText(Integer.toString(fieldValue));
          lip.calculate(0);
        });
    return lip;
  }

  private static void rotate(JFXSlider slider, Point3D axis, BodyPart parts,
      TextField textField,
      int minusFactor, int multiplicationFactor, int divisionFactor) {
    slider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          double rotationGrad = (-(newValue - minusFactor) * multiplicationFactor) / divisionFactor;
          if (axis == Rotate.X_AXIS) {
            parts.x_Rotation = rotationGrad;
          } else if (axis == Rotate.Y_AXIS) {
            parts.y_Rotation = rotationGrad;
          } else {
            parts.z_Rotation = rotationGrad;
          }
          textField.setText(Integer.toString((int) newValue));
          parts.calculate(0);
        });
  }
}
