package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class Rotation {

  public void execute(JFXSlider slider, Point3D axis, BodyPart parts,
      TextField textField, int minusFactor, int multiplicationFactor, int divisionFactor) {
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

  public void execute(Node reetiBodyPart, double pivotX, double pivotY, double pivotZ,
      double x_Rotation, double y_Rotation, double z_Rotation) {
    Rotate rx = new Rotate(x_Rotation, pivotX, pivotY, pivotZ, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, pivotX, pivotY, pivotZ, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, pivotX, pivotY, pivotZ, Rotate.Z_AXIS);

    reetiBodyPart.getTransforms().clear();
    reetiBodyPart.getTransforms().addAll(rz, ry, rx);
  }
}
