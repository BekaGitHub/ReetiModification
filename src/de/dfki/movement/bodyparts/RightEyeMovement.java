package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.main.Constants;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public class RightEyeMovement implements Movement {

  @Override
  public void execute(BodyPart bodyPart, JFXSlider slider, TextField textField, Point3D axis) {
    initializeSlider(slider, 0, 100, 51);

    Rotation rotation = new Rotation();
    rotation.execute(slider, axis, bodyPart, textField,
        Constants.RIGHT_EYE_MINUS_FACTOR,
        Constants.RIGHT_EYE_MULTIPLIKATION_FACTOR,
        Constants.RIGHT_EYE_DIVISION_FACTOR);
  }
}
