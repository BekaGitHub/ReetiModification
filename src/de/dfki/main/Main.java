package de.dfki.main;

import de.dfki.agent.Reeti;
import de.dfki.controllers.ReetiController;
import de.dfki.tts.Cereproc;
import de.dfki.util.Dimension;
import de.dfki.util.XMLParser;
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

  public static void main(String[] args) {
//    XMLParser.createDocument(null);
//    System.out.println(XMLParser.getVauleOf("cereproc-library-path"));
//    Cereproc cereproc = new Cereproc(null);
//    cereproc.setLibraryPathFromXML("cereproc-library-path");
//    cereproc.setVoiceNameFromXML("voice-name");
//    cereproc.setLicenseNameFromXML("license-name");
//    cereproc.buildCereVoice();
//    cereproc.speakFromFile("C:\\Users\\Beka\\Desktop\\test.txt  ");
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/de/dfki/view/controlPanelView.fxml"));

//    Reeti reeti = new Reeti("Reeti",  TYPE.MALE, 1.5f, new Dimension(0,0));
    Reeti reeti = new Reeti();
    ReetiController controller = new ReetiController();
    controller.setReeti(reeti);
    loader.setController(controller);
    HBox root = loader.load();

    Scene scene = new Scene(root, Dimension.getScreenWidth(), Dimension.getScreenHight(), true,
        SceneAntialiasing.BALANCED);
    StackPane reetiStage = new StackPane();
    HBox.setHgrow(reetiStage, Priority.ALWAYS);
    SubScene subScene = ReetiSubScene.createSubScene(reetiStage);
    root.getChildren().add(subScene);
    //macht Root Element clickbar
    root.setPickOnBounds(false);
    reetiStage.getChildren().add(reeti);
    scene.getStylesheets().add("de/dfki/main/Style.css");
    primaryStage.setScene(scene);
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
  }
}
