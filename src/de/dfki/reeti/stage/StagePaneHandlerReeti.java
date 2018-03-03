package de.dfki.reeti.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.ViewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 11/10/16.
 */
final public class StagePaneHandlerReeti {

  private HBox root = null;
  private ViewController mReetiStageController = null;

  public StagePaneHandlerReeti() {
    if (ApplicationLauncherImpl.isRunning()) {
      try {
        if (mReetiStageController == null) {
          invoke();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public HBox getConfigRoot() throws IOException {
    if (mReetiStageController == null) {
      invoke();
    }

    return root;
  }

  public HBox getStageRoot() throws IOException {
    if (mReetiStageController == null) {
      invoke();
    }
    AnchorPane controlPanel = (AnchorPane) root.lookup("#controlPanel");
    if (controlPanel != null) {
      root.getChildren().remove(controlPanel);
    }
    return root;
  }

  private StagePaneHandlerReeti invoke() throws IOException {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/de/dfki/reeti/View1.fxml"));
    root = loader.load();
    mReetiStageController = loader.getController();
    return this;

  }

  public ViewController getReetiStageController() {
    return mReetiStageController;
  }

  public void setReetisOnStage(AgentsOnStage reeti) {
    mReetiStageController.setStickamnOnStage(reeti);
  }

}
