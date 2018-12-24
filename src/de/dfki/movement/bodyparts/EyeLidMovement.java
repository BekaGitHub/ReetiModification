package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.main.Constants;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public class EyeLidMovement implements Movement {

  @Override
  public void execute(BodyPart bodyPart, JFXSlider slider, TextField textField, Point3D axis) {
    initializeSlider(slider, 0, 100, 100);

    Rotation rotation = new Rotation();
    rotation.execute(slider, axis, bodyPart, textField,
        Constants.EYE_LID_MINUS_FACTOR,
        Constants.EYE_LID_MULTIPLIKATION_FACTOR,
        Constants.EYE_LID_DIVISION_FACTOR);
  }
}
