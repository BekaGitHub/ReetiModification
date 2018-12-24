package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.util.Constants;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public class EarMovement implements Movement {

  @Override
  public void execute(BodyPart bodyPart, JFXSlider slider, TextField textField, Point3D axis) {
    initializeSlider(slider, 0, 100, 50);

    Rotation rotation = new Rotation();
    rotation.execute(slider, axis, bodyPart, textField,
        Constants.EAR_MINUS_FACTOR,
        Constants.EAR_MULTIPLIKATION_FACTOR,
        Constants.EAR_DIVISION_FACTOR);
  }
}
