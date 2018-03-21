package de.dfki.stage;

import javafx.scene.PerspectiveCamera;

public class ReetiCamera {

  private static PerspectiveCamera perspectiveCamera;

  public static PerspectiveCamera getCameraInstance() {
    if (perspectiveCamera == null) {
      perspectiveCamera = new PerspectiveCamera(false);
      return perspectiveCamera;
    } else {
      return perspectiveCamera;
    }
  }

  public static void setCamera(PerspectiveCamera camera) {
    perspectiveCamera = camera;
  }

}
