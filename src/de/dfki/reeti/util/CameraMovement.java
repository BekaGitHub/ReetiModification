package de.dfki.reeti.util;

import com.jfoenix.controls.JFXSlider;
import de.dfki.reeti.stage.ReetiCamera;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class CameraMovement {

  private CameraMovement() {
  }

  public static void rotateCamera(JFXSlider cameraRotationSlider, Point3D axis) {
    cameraRotationSlider.setMin(-180);
    cameraRotationSlider.setMax(180);
    cameraRotationSlider.setValue(0);

    cameraRotationSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
          double newValue = new_val.doubleValue();
          double oldValue = old_val.doubleValue();
          double rotationFactor = newValue - oldValue;
          Rotate rotation = new Rotate(rotationFactor, Dimension.getReetiStage_X_Center(),
              Dimension.getReetiStage_Y_Center(), 0, axis);
          ReetiCamera.createCamera().getTransforms().add(rotation);
        });
  }

  public static void translateCamera(JFXSlider cameraTranslationSlider, Point3D axis) {
    cameraTranslationSlider.setMin(-180);
    cameraTranslationSlider.setMax(180);
    cameraTranslationSlider.setValue(0);

    cameraTranslationSlider.valueProperty()
        .addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
          double newValue = new_val.doubleValue();
          double oldValue = old_val.doubleValue();
          double translationFactor = newValue - oldValue;

          Translate translate = null;
          if (axis == Rotate.X_AXIS) {
            translate = new Translate(-translationFactor, 0, 0);
          }
          else if (axis == Rotate.Y_AXIS)
            translate = new Translate(0, translationFactor, 0);
          else
            translate = new Translate(0, 0, translationFactor);

          ReetiCamera.createCamera().getTransforms().add(translate);
        });
  }

  public static void resetCameraPosition(List<JFXSlider> sliders) {
    PerspectiveCamera perspectiveCamera = ReetiCamera.createCamera();
    perspectiveCamera.getTransforms().clear();

    sliders.stream().forEach(e -> e.setValue(0));
  }



}
