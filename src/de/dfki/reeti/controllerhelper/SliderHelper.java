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
