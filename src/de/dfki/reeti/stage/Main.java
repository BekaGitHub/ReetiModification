package de.dfki.reeti.stage;

import de.dfki.common.Gender;
import de.dfki.common.Gender.TYPE;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.reeti.AReetiStageController;
import de.dfki.reeti.Reeti;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/de/dfki/reeti/ViewX.fxml"));
    VBox root = loader.load();
    ViewController controller = loader.getController();
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();

    Reeti reeti = new Reeti("Reeti", TYPE.MALE);

    Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight(), true, SceneAntialiasing.BALANCED);
    HBox test = (HBox) scene.lookup("#test");
    root.setPickOnBounds(false);
    AReetiStageController.currentReeti = reeti;
    test.getChildren().add(reeti);
    scene.getStylesheets().add("de/dfki/reeti/stage/Style.css");
    primaryStage.setScene(scene);
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
