package de.dfki.stage;

import de.dfki.util.Constants;
import de.dfki.util.Dimension;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.layout.StackPane;

public class ReetiSubScene {

  private ReetiSubScene(){}

  public static SubScene createSubScene(StackPane stackPane) {
    SubScene subScene = new SubScene(stackPane, Dimension.getScreenWidth() - Constants.CONTROLPANEL_WIDTH,
        Dimension.getScreenHight(),
        true, SceneAntialiasing.BALANCED);
    subScene.setCamera(ReetiCamera.getCameraInstance());
    return subScene;
  }
}
