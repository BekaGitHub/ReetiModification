package de.dfki.movement.bodyparts;

import com.jfoenix.controls.JFXSlider;
import de.dfki.body.BodyPart;
import javafx.geometry.Point3D;
import javafx.scene.control.TextField;

public interface Movement {

  void execute(BodyPart bodyPart, JFXSlider slider,
      TextField textField, Point3D axis);

  default void initializeSlider(JFXSlider slider, int min, int max, int value) {
    slider.setMin(min);
    slider.setMax(max);
    slider.setValue(value);
  }
}
