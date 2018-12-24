package de.dfki.movement.bodyparts.mouth;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.movement.bodyparts.Movement;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public class MouthBottomLipMovement implements Movement {

  @Override
  public void execute(BodyPart bodyPart, JFXSlider slider, TextField textField, Point3D axis) {
    initializeSlider(slider, 0, 100, 0);
    moveLip(slider, bodyPart, textField);
  }

  private void moveLip(JFXSlider slider, BodyPart bodyPart, TextField textField) {
    slider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
        {
          double newValue = Math.abs(new_val.doubleValue());
          double SliderValue = (newValue + 217) * 16 / 100;

          textField.setText(Integer.toString((int) newValue));
          bodyPart.calculate((int) SliderValue);
        });
  }
}
