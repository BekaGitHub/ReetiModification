package de.dfki.reeti.stage;

import de.dfki.common.Gender;
import de.dfki.common.Gender.TYPE;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.reeti.AReetiStageController;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import java.awt.Dimension;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/de/dfki/reeti/ViewX.fxml"));
    HBox root = loader.load();

    ReetiStageController controller = loader.getController();
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();


//    Reeti reeti = new Reeti("Reeti",  TYPE.MALE, 1.5f, new Dimension(0,0));
    Reeti reeti = new Reeti("Reeti",  TYPE.MALE);

    Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight(), true, SceneAntialiasing.BALANCED);
    StackPane agentStage = controller.getAgentStage();
    root.setPickOnBounds(false);
    AReetiStageController.currentReeti = reeti;
    agentStage.getChildren().add(reeti);
//    agentStage.setStyle("-fx-background-color: red");
    scene.getStylesheets().add("de/dfki/reeti/stage/Style.css");
    primaryStage.setScene(scene);
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
