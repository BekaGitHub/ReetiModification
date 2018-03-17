package de.dfki.reeti.stage;

import javafx.scene.PerspectiveCamera;

public class ReetiCamera {
  private static PerspectiveCamera perspectiveCamera;

  public static PerspectiveCamera createCamera() {
    if (perspectiveCamera == null) {
      perspectiveCamera = new PerspectiveCamera(false);
      return perspectiveCamera;
    } else {
      return perspectiveCamera;
    }
  }

}
