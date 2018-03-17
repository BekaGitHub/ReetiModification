/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.controllerhelper;

import de.dfki.reeti.ReetiController;
import java.awt.Point;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.transform.Rotate;

/**
 * @author EmpaT
 */
public class SliderHelper {

  public static void handleHeadSlider(ReetiController controller, Slider slider,
      String achse) {
    slider.setMin(0);
    slider.setMax(100);
    slider.setValue(50);
    slider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          if (achse.equalsIgnoreCase("X")) {
            controller.currentReeti.head.xRotation = (-(newValue - 50) * 40) / 100;
//            controller.headXRotationField.setText(Integer.toString((int) newValue));
          } else if (achse.equalsIgnoreCase("Y")) {
            controller.currentReeti.head.mYRotation = -(newValue - 50);
//            controller.headYRotationField.setText(Integer.toString((int) newValue));
          } else {
            controller.currentReeti.head.mZRotation = ((newValue - 50) * 40) / 100;
//            controller.headZRotationField.setText(Integer.toString((int) newValue));
          }
          controller.currentReeti.head.calculate(0);
        });
  }

  public static void handleLeftEyeXSlider(ReetiController controller) {
//    controller.leftEyeXSlider.setMin(0);
//    controller.leftEyeXSlider.setMax(100);
//    controller.leftEyeXSlider.setValue(42);
//    controller.leftEyeXSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.leftEye.xRotation = (-(newValue - 47) * 90) / 100;
//          controller.leftEyeXRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.leftEye.calculate(0);
//        });
  }

  public static void handleLeftEyeYSlider(ReetiController controller) {
//    controller.leftEyeYSlider.setMin(0);
//    controller.leftEyeYSlider.setMax(100);
//    controller.leftEyeYSlider.setValue(42);
//    controller.leftEyeYSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.leftEye.mYRotation = (-(newValue - 42) * 90) / 100;
//          controller.leftEyeYRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.leftEye.calculate(0);
//        });
  }

  public static void handleRightEyeXSlider(ReetiController controller) {
//    controller.rightEyeXSlider.setMin(0);
//    controller.rightEyeXSlider.setMax(100);
//    controller.rightEyeXSlider.setValue(47);
//    controller.rightEyeXSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.rightEye.xRotation = (-(newValue - 51) * 90) / 100;
//          controller.rightEyeXRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.rightEye.calculate(0);
//        });
  }

  public static void handleRightEyeYSlider(ReetiController controller) {
//    controller.rightEyeYSlider.setMin(0);
//    controller.rightEyeYSlider.setMax(100);
//    controller.rightEyeYSlider.setValue(65);
//    controller.rightEyeYSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.rightEye.mYRotation = (-(newValue - 65) * 90) / 100;
//          controller.rightEyeYRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.rightEye.calculate(0);
//        });
  }

  public static void handleLeftEyeLidXSlider(ReetiController controller) {
//    controller.leftEyeLidXSlider.setMin(0);
//    controller.leftEyeLidXSlider.setMax(100);
//    controller.leftEyeLidXSlider.setValue(100);
//    controller.leftEyeLidXSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.leftEyelid.xRotation = (-(newValue - 100));
//          controller.leftEyeLidXRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.leftEyelid.calculate(0);
//        });
  }

  public static void handleRightEyeLidXSlider(ReetiController controller) {
//    controller.rightEyeLidXSlider.setMin(0);
//    controller.rightEyeLidXSlider.setMax(100);
//    controller.rightEyeLidXSlider.setValue(100);
//    controller.rightEyeLidXSlider.valueProperty()
//        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
//        {
//          double newValue = new_val.doubleValue();
//          controller.currentReeti.rightEyelid.xRotation = (-(newValue - 100));
//          controller.rightEyeLidXRotationField.setText(Integer.toString((int) newValue));
//          controller.currentReeti.rightEyelid.calculate(0);
//        });
  }

  public static void handleLeftEarSlider(ReetiController controller) {
    controller.leftEarSlider.setMin(0);
    controller.leftEarSlider.setMax(100);
    controller.leftEarSlider.setValue(50);
    controller.leftEarSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          controller.currentReeti.leftEar.mZRotation = (-(newValue - 50));
          controller.leftEarRotationField.setText(Integer.toString((int) newValue));
          controller.currentReeti.leftEar.calculate(0);
        });
  }

  public static void handleRightEarSlider(ReetiController controller) {
    controller.rightEarSlider.setMin(0);
    controller.rightEarSlider.setMax(100);
    controller.rightEarSlider.setValue(50);
    controller.rightEarSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = new_val.doubleValue();
          controller.currentReeti.rightEar.mZRotation = (-(newValue - 50));
          controller.rightEarRotationField.setText(Integer.toString((int) newValue));
          controller.currentReeti.rightEar.calculate(0);
        });
  }

  public static void handleLeftLCSlider(ReetiController controller) {
    controller.leftLCSlider.setMin(-100);
    controller.leftLCSlider.setMax(0);
    controller.leftLCSlider.setValue(-50);
    controller.leftLCSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
          controller.currentReeti.mouthLeftCorner.setShape("LEFTCORNERACTION");
          double SliderValue = (newValue + 170) * 16 / 100;
          controller.currentReeti.mouthLeftCorner.setLeftCornerRegulator(SliderValue);
          int fieldValue = (int) Math.abs(newValue - 100);
          controller.leftLCRotationField.setText(Integer.toString(fieldValue));
          controller.currentReeti.mouthLeftCorner.calculate(0);
        });
  }

  public static void handleRightLCSlider(ReetiController controller) {
    controller.rightLCSlider.setMin(-100);
    controller.rightLCSlider.setMax(0);
    controller.rightLCSlider.setValue(-50);
    controller.rightLCSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
          controller.currentReeti.mouthRightCorner.setShape("RIGHTCORNERACTION");
          double SliderValue = (newValue + 170) * 16 / 100;
          controller.currentReeti.mouthRightCorner.setRightCornerRegulator(SliderValue);
          int fieldValue = (int) Math.abs(newValue - 100);
          controller.rightLCRotationField.setText(Integer.toString(fieldValue));
          controller.currentReeti.mouthRightCorner.calculate(0);
        });
  }

  public static void handleTopLipSlider(ReetiController controller) {
    controller.topLipSlider.setMin(-100);
    controller.topLipSlider.setMax(0);
    controller.topLipSlider.setValue(-100);
    controller.topLipSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
          controller.currentReeti.mouthUpperLip.setShape("UPPERLIPACTION");
          double SliderValue = (newValue + 107) * 16 / 100;
          controller.currentReeti.mouthUpperLip.setUpperLipRegulator(SliderValue);
          int fieldValue = (int) Math.abs(newValue - 100);
          controller.topLipRotationField.setText(Integer.toString(fieldValue));
          controller.currentReeti.mouthUpperLip.calculate(0);
        });
  }

  public static void handleBottomLipSlider(ReetiController controller) {
    controller.bottomLipSlider.setMin(0);
    controller.bottomLipSlider.setMax(100);
    controller.bottomLipSlider.setValue(0);
    controller.bottomLipSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
          controller.currentReeti.mouthDownLip.setShape("DOWNLIPACTION");
          double SliderValue = (newValue + 217) * 16 / 100;
          controller.currentReeti.mouthDownLip.setDownLipRegulator(SliderValue);
          int fieldValue = (int) (newValue);
          controller.bottomLipRotationField.setText(Integer.toString(fieldValue));
          controller.currentReeti.mouthDownLip.calculate(0);
        });
  }
}
