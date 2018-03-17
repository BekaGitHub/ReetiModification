package de.dfki.reeti.stage;

import de.dfki.common.Gender.TYPE;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.util.Dimension;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/de/dfki/reeti/ViewX.fxml"));
    HBox root = loader.load();

//    Reeti reeti = new Reeti("Reeti",  TYPE.MALE, 1.5f, new Dimension(0,0));
    Reeti reeti = new Reeti("Reeti", TYPE.MALE);
    ReetiController controller = loader.getController();
    controller.setReeti(reeti);

    Scene scene = new Scene(root, Dimension.getScreenWidth(), Dimension.getScreenHight(), true,
        SceneAntialiasing.BALANCED);
    StackPane reetiStage = new StackPane();
    HBox.setHgrow(reetiStage, Priority.ALWAYS);
    SubScene subScene = ReetiSubScene.createSubScene(reetiStage);
    root.getChildren().add(subScene);
    //macht Root Element clickbar
    root.setPickOnBounds(false);
    reetiStage.getChildren().add(reeti);
    scene.getStylesheets().add("de/dfki/reeti/stage/Style.css");
    primaryStage.setScene(scene);
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
