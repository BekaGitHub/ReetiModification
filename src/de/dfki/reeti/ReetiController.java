package de.dfki.reeti;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import de.dfki.agent.Reeti;
import de.dfki.util.BodyPartsMovement;
import de.dfki.util.CameraMovement;
import de.dfki.util.Constants;
import de.dfki.util.Led;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

/**
 * @author Beka
 */
public class ReetiController {

  public static RadioButton currentRadioButton;

  @FXML
  private HBox root;
  @FXML
  private VBox controlPanelBox;

  @FXML
  private JFXListView<Label> expressionListView;
  @FXML
  private JFXListView<Label> environmentListView;

  @FXML
  private JFXColorPicker leftLedColorPicker;
  @FXML
  private JFXColorPicker rightLedColorPicker;
  @FXML
  private JFXColorPicker bothLedColorPicker;
  @FXML
  private JFXButton ledOffButton;

  @FXML
  private JFXSlider head_X_Slider;
  @FXML
  private JFXSlider head_Y_Slider;
  @FXML
  private JFXSlider head_Z_Slider;
  @FXML
  private TextField head_X_RotationField;
  @FXML
  private TextField head_Y_RotationField;
  @FXML
  private TextField head_Z_RotationField;

  @FXML
  private JFXSlider leftEye_X_Slider;
  @FXML
  private JFXSlider leftEye_Y_Slider;
  @FXML
  private TextField leftEye_X_RotationFiled;
  @FXML
  private TextField leftEye_Y_RotationFiled;

  @FXML
  private JFXSlider rightEye_X_Slider;
  @FXML
  private JFXSlider rightEye_Y_Slider;
  @FXML
  private TextField rightEye_X_RotationFiled;
  @FXML
  private TextField rightEye_Y_RotationFiled;

  @FXML
  private JFXSlider leftEyeLid_X_Slider;
  @FXML
  private TextField leftEyeLid_X_RotationField;

  @FXML
  private JFXSlider rightEyeLid_X_Slider;
  @FXML
  private TextField rightEyeLid_X_RotationField;

  @FXML
  private JFXSlider leftEarSlider;
  @FXML
  private TextField leftEarRotationField;

  @FXML
  private JFXSlider rightEarSlider;
  @FXML
  private TextField rightEarRotationField;

  @FXML
  private TextField leftLCRotationField;
  @FXML
  private JFXSlider leftLCSlider;

  @FXML
  private JFXSlider rightLCSlider;
  @FXML
  private TextField rightLCRotationField;

  @FXML
  private JFXSlider topLipSlider;
  @FXML
  private TextField topLipRotationField;

  @FXML
  private JFXSlider bottomLipSlider;
  @FXML
  private TextField bottomLipRotationField;

  @FXML
  private JFXToggleButton cameraToogleButton;
  @FXML
  private JFXSlider camera_X_Rotation;
  @FXML
  private JFXSlider camera_Y_Rotation;
  @FXML
  private JFXSlider camera_Z_Rotation;
  @FXML
  private JFXSlider camera_X_Translation;
  @FXML
  private JFXSlider camera_Y_Translation;
  @FXML
  private JFXSlider camera_Z_Translation;
  @FXML
  private JFXButton nearClipMinus;
  @FXML
  private JFXButton nearClipPlus;
  @FXML
  private TextField nearClipField;
  @FXML
  private JFXButton farClipMinus;
  @FXML
  private JFXButton farClipPlus;
  @FXML
  private TextField farClipField;
  @FXML
  private JFXButton fieldOfViewMinus;
  @FXML
  private JFXButton fieldOfViewPlus;
  @FXML
  private TextField fieldOfViewField;
  @FXML
  private JFXButton cameraResetButton;

  @FXML
  private JFXButton exitButton;

  private Reeti reeti;

  public void initialize() {
    fillExpressionListView();
    fillEnvironmentListView();

    cameraToogleButton.selectedProperty().addListener((p, o, n) -> {
      if (p.getValue()) {
        CameraMovement.startCamera();
      } else {
        CameraMovement.stopCamera();
      }
    });
    CameraMovement.rotateCamera(camera_X_Rotation, Rotate.X_AXIS);
    CameraMovement.rotateCamera(camera_Y_Rotation, Rotate.Y_AXIS);
    CameraMovement.rotateCamera(camera_Z_Rotation, Rotate.Z_AXIS);
    CameraMovement.translateCamera(camera_X_Translation, Rotate.X_AXIS);
    CameraMovement.translateCamera(camera_Y_Translation, Rotate.Y_AXIS);
    CameraMovement.translateCamera(camera_Z_Translation, Rotate.Z_AXIS);
    //Setze Camera Position und alle Camera Sliders auf den Defaultpunkt
    cameraResetButton.setOnAction((event) -> CameraMovement.resetCameraPosition(new ArrayList<>(
        Arrays.asList(camera_X_Rotation, camera_Y_Rotation, camera_Z_Rotation,
            camera_X_Translation, camera_Y_Translation, camera_Z_Translation))));

    BodyPartsMovement
        .rotateHead(reeti.getHead(), head_X_Slider, head_X_RotationField, Rotate.X_AXIS);
    BodyPartsMovement
        .rotateHead(reeti.getHead(), head_Y_Slider, head_Y_RotationField, Rotate.Y_AXIS);
    BodyPartsMovement
        .rotateHead(reeti.getHead(), head_Z_Slider, head_Z_RotationField, Rotate.Z_AXIS);

    BodyPartsMovement.rotateLeftEye(reeti.getLeftEye(), leftEye_X_RotationFiled, leftEye_X_Slider,
        Rotate.X_AXIS);
    BodyPartsMovement.rotateLeftEye(reeti.getLeftEye(), leftEye_Y_RotationFiled, leftEye_Y_Slider,
        Rotate.Y_AXIS);
    BodyPartsMovement
        .rotateRightEye(reeti.getRightEye(), rightEye_X_RotationFiled, rightEye_X_Slider,
            Rotate.X_AXIS);
    BodyPartsMovement
        .rotateRightEye(reeti.getRightEye(), rightEye_Y_RotationFiled, rightEye_Y_Slider,
            Rotate.Y_AXIS);

    BodyPartsMovement
        .rotateEyeLid(reeti.getLeftEyelid(), leftEyeLid_X_RotationField, leftEyeLid_X_Slider,
            Rotate.X_AXIS);
    BodyPartsMovement
        .rotateEyeLid(reeti.getRightEyelid(), rightEyeLid_X_RotationField, rightEyeLid_X_Slider,
            Rotate.X_AXIS);

    BodyPartsMovement
        .rotateEar(reeti.getLeftEar(), leftEarRotationField, leftEarSlider, Rotate.Z_AXIS);
    BodyPartsMovement
        .rotateEar(reeti.getRightEar(), rightEarRotationField, rightEarSlider, Rotate.Z_AXIS);

    BodyPartsMovement
        .moveMouthLeftCorner(reeti.getMouthLeftCorner(), leftLCSlider, leftLCRotationField);
    BodyPartsMovement
        .moveMouthRightCorner(reeti.getMouthRightCorner(), rightLCSlider, rightLCRotationField);
    BodyPartsMovement
        .moveMouthUpperLip(reeti.getMouthUpperLip(), topLipSlider, topLipRotationField);
    BodyPartsMovement
        .moveMouthBottomLip(reeti.getMouthDownLip(), bottomLipSlider, bottomLipRotationField);

    expressionListView.getStylesheets()
        .add(this.getClass().getResource("listView.css").toExternalForm());
    environmentListView.getStylesheets()
        .add(this.getClass().getResource("listView.css").toExternalForm());

    leftLedColorPicker
        .setOnAction(event -> reeti.ledON(leftLedColorPicker.getValue(), Led.LEFT));
    rightLedColorPicker
        .setOnAction(event -> reeti.ledON(rightLedColorPicker.getValue(), Led.RIGHT));
    bothLedColorPicker
        .setOnAction(event -> reeti.ledON(bothLedColorPicker.getValue(), Led.BOTH));
    ledOffButton.setOnAction(event -> reeti.ledOFF());

    exitButton.setOnAction((event) -> System.exit(0));

  }

//  private ReetiStage stage3D;
//    @FXML
//    private void handleTimelineButton() {
//      TimelineStart timelineStart = new TimelineStart(reeti);
//      timelineStart.setOwnerStage(this.stage3D.getMainStage());
//      try {
//        timelineStart.show();
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//  }

  private void fillExpressionListView() {
    handleClickedLabels(getClassNames(Constants.BASE_ANIMATIONPATH + ".expression"),
        expressionListView);
  }

  private void fillEnvironmentListView() {
    handleClickedLabels(getClassNames(Constants.BASE_ANIMATIONPATH + ".blink"),
        environmentListView);
  }

  private List<String> getClassNames(String packageName) {
    Packageparser packageparser = new Packageparser(packageName);
    List<String> classNamesList = packageparser.getClassNameList();
    ObservableList<String> classNamesObservableList = FXCollections.observableArrayList();
    classNamesObservableList.addAll(new ArrayList<>(classNamesList));
    return classNamesList;
  }

  @SuppressWarnings("unchecked")
  private void handleClickedLabels(List<String> classNamesList,
      JFXListView listView) {

    for (int i = 0; i < classNamesList.size(); i++) {
      Label label = new Label(classNamesList.get(i));
      listView.getItems().add(getDecoratedLabel(label));
      listView.setOnMouseClicked(event -> {
        int index = listView.getSelectionModel().getSelectedIndex();
        reeti.doAnimation(classNamesList.get(index), 500, true);
      });
    }
  }

  private Label getDecoratedLabel(Label label) {
    DropShadow ds = new DropShadow();
    ds.setOffsetY(3.0f);
    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

    label.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
    label.setEffect(ds);
    label.setCache(true);

    return label;
  }

  public Reeti getReeti() {
    return reeti;
  }

  public void setReeti(Reeti reeti) {
    this.reeti = reeti;
  }
}
