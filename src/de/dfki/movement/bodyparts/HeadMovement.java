package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import de.dfki.main.Constants;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public class HeadMovement implements Movement {

  @Override
  public void execute(BodyPart bodyPart, JFXSlider slider,
      TextField textField, Point3D axis) {
    initializeSlider(slider, 0, 100, 50);

    Rotation rotation = new Rotation();
    rotation.execute(slider, axis, bodyPart, textField,
        Constants.HEAD_MINUS_FACTOR,
        Constants.HEAD_MULTIPLIKATION_FACTOR,
        Constants.HEAD_DIVISION_FACTOR);
  }
}
