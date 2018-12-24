package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class Rotation {

  public void execute(JFXSlider slider, Point3D axis, BodyPart parts,
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
