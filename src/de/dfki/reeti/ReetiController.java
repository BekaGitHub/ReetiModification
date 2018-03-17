package de.dfki.reeti;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import de.dfki.common.AgentsOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.reeti.controllerhelper.ColorHelper;
import de.dfki.reeti.stage.ReetiStage;
import de.dfki.reeti.timeline.TimelineStart;
import de.dfki.reeti.util.BodyPartsMovement;
import de.dfki.reeti.util.CameraMovement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

/**
 * @author Beka
 */
public class ReetiController extends AReetiStageController implements ViewController {

  private static final String PACKAGE_EXPRESSION = "de.dfki.reeti.animation.face";
  private static final String PACKAGE_ENVIRONMENT = "de.dfki.reeti.animation.environment";
  public static RadioButton currentRadioButton;

  @FXML
  private HBox root;
  @FXML
  private VBox controlPanelBox;

  @FXML
  private JFXListView<?> expressionListView;
  @FXML
  private JFXListView<?> environmentListView;

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

//    ledOffButton.setOnAction((event) ->
//    {
//      currentReeti.leftCheek.getLedGroup().setVisible(false);
//      currentReeti.rightCheek.getLedGroup().setVisible(false);
//    });
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
    exitButton.setOnAction((event) -> {
      System.exit(0);
    });
  }

  public Reeti getStickmanAs3D(String mStickmancombobox) {
    return (Reeti) mStickmanOnstage.getAgent(mStickmancombobox);
  }

  /**
   * @param commonStickmansOnStage
   */
  @Override
  public void setStickamnOnStage(AgentsOnStage commonStickmansOnStage) {
    this.mStickmanOnstage = commonStickmansOnStage;
    fillComboForStickman();

  }

  @FXML
  private void handleTimelineButton() {
    TimelineStart timelineStart = new TimelineStart(this.currentReeti);
    timelineStart.setOwnerStage(this.stage3D.getMainStage());
    try {
      timelineStart.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void handleStopCamera() {
    if (isCameraStarted) {
      stage3D.getSubScene().setCamera(null);
      isCameraStarted = false;
    }
  }

  @FXML
  public void handleStartCamera() {
    if (!isCameraStarted) {
      stage3D.getSubScene().setCamera(stage3D.getCamera());
      isCameraStarted = true;
    }
  }

  @FXML
  public void handleResetCamera() {

    stage3D.getCamera().setTranslateX(stage3D.getRecordCameraXPosition());
    stage3D.getCamera().setTranslateY(stage3D.getRecordCameraYPosition());
    stage3D.getCamera().setTranslateZ(stage3D.getRecordCameraZPosition());

    camera_X_Rotation.setValue(0);
    camera_Y_Rotation.setValue(0);
    camera_Z_Rotation.setValue(0);
    stage3D.getCamera().setNearClip(0.8);
    stage3D.getCamera().setFarClip(3000);
    stage3D.getCamera().setFieldOfView(30);
    nearClipField.setText("0.8");
    farClipField.setText("3000");
    fieldOfViewField.setText("30");
    stage3D.getCamera().getTransforms().clear();
  }

  @FXML
  public void handleCameraXTranslation(MouseEvent event) {
//    if (event.getSource().equals(cameraXPlusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraXTranslationField.getText());
//      currentValue += 50;
//      stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() + 50);
//      cameraXTranslationField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(cameraXMinusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraXTranslationField.getText());
//      currentValue -= 50;
//      stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() - 50);
//      cameraXTranslationField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleCameraYTranslation(MouseEvent event) {
//    if (event.getSource().equals(cameraYPlusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraYTranslationField.getText());
//      currentValue += 50;
//      stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() + 50);
//      cameraYTranslationField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(cameraYMinusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraYTranslationField.getText());
//      currentValue -= 50;
//      stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() - 50);
//      cameraYTranslationField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleCameraZTranslation(MouseEvent event) {
//    if (event.getSource().equals(cameraZPlusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraZTranslationField.getText());
//      currentValue += 10;
//      stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() + 10);
//      cameraZTranslationField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(cameraZMinusTranslationButton)) {
//      double currentValue = Double.parseDouble(cameraZTranslationField.getText());
//      currentValue -= 10;
//      stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() - 10);
//      cameraZTranslationField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleNearClip(MouseEvent event) {
//    if (event.getSource().equals(nearClipPlusButton)) {
//      double currentValue = Double.parseDouble(nearClipField.getText());
//      if (currentValue >= 1.0) {
//        currentValue = 1.0;
//      } else {
//        currentValue += 0.1;
//        currentValue = Math.round(currentValue * 100.0) / 100.0;
//      }
//      stage3D.getCamera().setNearClip(currentValue);
//      nearClipField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(nearClipMinusButton)) {
//      double currentValue = Double.parseDouble(nearClipField.getText());
//      if (currentValue <= 0.0) {
//        currentValue = 0.0;
//      } else {
//        currentValue -= 0.1;
//        currentValue = Math.round(currentValue * 100.0) / 100.0;
//      }
//      stage3D.getCamera().setNearClip(currentValue);
//      nearClipField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleFarClip(MouseEvent event) {
//    if (event.getSource().equals(farClipPlusButton)) {
//      double currentValue = Double.parseDouble(farClipField.getText());
//      currentValue += 50;
//
//      stage3D.getCamera().setFarClip(currentValue);
//      farClipField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(farClipMinusButton)) {
//      double currentValue = Double.parseDouble(farClipField.getText());
//      currentValue -= 50;
//
//      stage3D.getCamera().setFarClip(currentValue);
//      farClipField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleFieldOfView(MouseEvent event) {
//    if (event.getSource().equals(fieldOfViewPlusButton)) {
//      double currentValue = Double.parseDouble(fieldOfViewField.getText());
//      currentValue += 1;
//
//      stage3D.getCamera().setFieldOfView(currentValue);
//      fieldOfViewField.setText(Double.toString(currentValue));
//    } else if (event.getSource().equals(fieldOfViewMinusButton)) {
//      double currentValue = Double.parseDouble(fieldOfViewField.getText());
//      currentValue -= 1;
//
//      stage3D.getCamera().setFieldOfView(currentValue);
//      fieldOfViewField.setText(Double.toString(currentValue));
//    }
  }

  @FXML
  public void handleLeftLedColor() {
    ColorHelper.leftLedColorChanger(this);
  }

  @FXML
  public void handleRightLedColor() {
    ColorHelper.rightLedColorChanger(this);
  }

  @FXML
  public void handleBothLedColor() {
    ColorHelper.bothLedColorChanger(this);
  }

  private void fillExpressionListView() {
    createAndHandleRadioButtons(getClassNames(PACKAGE_EXPRESSION), expressionListView);
  }

  private void fillEnvironmentListView() {
    createAndHandleRadioButtons(getClassNames(PACKAGE_ENVIRONMENT), environmentListView);
  }

  private List<String> getClassNames(String packageName) {
    Packageparser packageparser = new Packageparser(packageName);
    ArrayList<String> classNamesList = packageparser.getClassNameList();
    ObservableList<String> classNamesObservableList = FXCollections.observableArrayList();
    classNamesObservableList.addAll(classNamesList.stream().collect(Collectors.toList()));
    return classNamesList;
  }

  private void createAndHandleRadioButtons(List<String> classNamesList,
      JFXListView listView) {

    for (int i = 0; i < classNamesList.size(); i++) {
      Label label = new Label(classNamesList.get(i));

      DropShadow ds = new DropShadow();
      ds.setOffsetY(3.0f);
      ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

      label.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
      label.setEffect(ds);
      label.setCache(true);
      listView.getItems().add(label);
      listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            reeti.doAnimation(classNamesList.get(index), 500, true);
          });
    }
  }

  public void fillComboForStickman() {
    ObservableList<String> stickmanNames = FXCollections.observableArrayList();
    stickmanNames.addAll(mStickmanOnstage.getStickmanNames().stream().collect(Collectors.toList()));
    if (!stickmanNames.isEmpty()) {
      currentReeti = (Reeti) mStickmanOnstage.getAgent(stickmanNames.get(0));
      setComboboxValue((Reeti) mStickmanOnstage.getAgent(stickmanNames.get(0)));
    }
//    mReetiComboList.clear();
//    mReetiComboList.addAll(stickmanNames);
  }

  // set the setValue of combobox
  private void setComboboxValue(Reeti mStick) {
    bothLedColorPicker.setValue(colorWithoutOpacity(mStick.body.color));
    leftLedColorPicker.setValue(colorWithoutOpacity(mStick.head.color));
  }

//  @FXML
//  private void handleWithPerlinNoise() {
//
//    currentReeti.doAnimation("StartIdle", 1000, true);
//  }

//  @FXML
//  private void handleWithoutPerlinNoise() {
//
//    currentReeti.doAnimation("StopIdle", 1000, true);
//  }

  public ReetiStage getStage3D() {
    return stage3D;
  }

  public void setStage3D(ReetiStage stage3D) {
    this.stage3D = stage3D;
  }

  // convert color to hex
  private String toHexCode(Color color) {
    return String
        .format("#%02X%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255),
            (int) (color.getBlue() * 255), (int) (color.getOpacity() * 100));
  }

  private Color colorWithoutOpacity(Color color) {
    return new Color(color.getRed(), color.getGreen(), color.getBlue(), 1);
  }

  public Reeti getReeti() {
    return reeti;
  }

  public void setReeti(Reeti reeti) {
    this.reeti = reeti;
  }
}
