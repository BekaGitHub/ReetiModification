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
import de.dfki.reeti.util.CameraMovement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

/**
 * @author Beka
 */
public class ReetiController extends AReetiStageController implements ViewController {

  private static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.reeti.animation.face";
  private static final String PACKAGE_ENVIRONMENT = "de.dfki.reeti.animation.environment";
  public static RadioButton currentRadioButton;

  @FXML
  public HBox root;
  @FXML
  public VBox controlPanelBox;

  @FXML
  public JFXListView<?> expressionListView;
  @FXML
  public JFXListView<?> environmentListView;

  @FXML
  public JFXColorPicker leftLedColorPicker;
  @FXML
  public JFXColorPicker rightLedColorPicker;
  @FXML
  public JFXColorPicker bothLedColorPicker;
  @FXML
  public JFXButton ledOffButton;

  @FXML
  public JFXSlider head_X_Slider;
  @FXML
  public JFXSlider head_Y_Slider;
  @FXML
  public JFXSlider head_Z_Slider;
  @FXML
  public TextField head_X_RotationField;
  @FXML
  public TextField head_Y_RotationField;
  @FXML
  public TextField head_Z_RotationField;

  @FXML
  public JFXSlider leftEye_X_Slider;
  @FXML
  public JFXSlider leftEye_Y_Slider;
  @FXML
  public TextField leftEye_X_RotationFiled;
  @FXML
  public TextField leftEye_Y_RotationFiled;

  @FXML
  public JFXSlider rightEye_X_Slider;
  @FXML
  public JFXSlider rightEye_Y_Slider;
  @FXML
  public TextField rightEye_X_RotationFiled;
  @FXML
  public TextField rightEye_Y_RotationFiled;

  @FXML
  public JFXSlider leftEyeLid_X_Slider;
  @FXML
  public TextField leftEyeLid_X_RotationField;

  @FXML
  public JFXSlider rightEyeLid_X_Slider;
  @FXML
  public TextField rightEyeLid_X_RotationField;

  @FXML
  public JFXSlider leftEarSlider;
  @FXML
  public TextField leftEarRotationField;

  @FXML
  public JFXSlider rightEarSlider;
  @FXML
  public TextField rightEarRotationField;

  @FXML
  public TextField leftLCRotationField;
  @FXML
  public JFXSlider leftLCSlider;

  @FXML
  public JFXSlider rightLCSlider;
  @FXML
  public TextField rightLCRotationField;

  @FXML
  public JFXSlider topLipSlider;
  @FXML
  public TextField topLipRotationField;

  @FXML
  public JFXSlider bottomLipSlider;
  @FXML
  public TextField bottomLipRotationField;

  @FXML
  public JFXToggleButton cameraToogleButton;
  @FXML
  public JFXSlider camera_X_Rotation;
  @FXML
  public JFXSlider camera_Y_Rotation;
  @FXML
  public JFXSlider camera_Z_Rotation;
  @FXML
  public JFXSlider camera_X_Translation;
  @FXML
  public JFXSlider camera_Y_Translation;
  @FXML
  public JFXSlider camera_Z_Translation;
  @FXML
  public JFXButton nearClipMinus;
  @FXML
  public JFXButton nearClipPlus;
  @FXML
  public TextField nearClipField;
  @FXML
  public JFXButton farClipMinus;
  @FXML
  public JFXButton farClipPlus;
  @FXML
  public TextField farClipField;
  @FXML
  public JFXButton fieldOfViewMinus;
  @FXML
  public JFXButton fieldOfViewPlus;
  @FXML
  public TextField fieldOfViewField;
  @FXML
  public JFXButton cameraResetButton;

  @FXML
  public JFXButton exitButton;

  private Reeti reeti;

  public void initialize() {
    //Select a stickmanSwing

//    fillEmotionScrollPane();
//    fillEnvironmentScrollPane();
//
//
//    SliderHelper.handleHeadSlider(this, head_X_Slider, "X");
//    SliderHelper.handleHeadSlider(this, head_Y_Slider, "Y");
//    SliderHelper.handleHeadSlider(this, head_Z_Slider, "Z");
//    SliderHelper.handleLeftEyeXSlider(this);
//    SliderHelper.handleLeftEyeYSlider(this);
//    SliderHelper.handleRightEyeXSlider(this);
//    SliderHelper.handleRightEyeYSlider(this);
//    SliderHelper.handleLeftEyeLidXSlider(this);
//    SliderHelper.handleRightEyeLidXSlider(this);
//    SliderHelper.handleLeftEarSlider(this);
//    SliderHelper.handleRightEarSlider(this);
//    SliderHelper.handleLeftLCSlider(this);
//    SliderHelper.handleRightLCSlider(this);
//    SliderHelper.handleTopLipSlider(this);
//    SliderHelper.handleBottomLipSlider(this);
//
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

    exitButton.setOnAction((event) -> System.exit(0));
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

  private void fillEmotionScrollPane() {
    ArrayList<String> getClassesNames;
    Packageparser parser = new Packageparser(PACKAGE_EMOTIONEXPRESSION);
    getClassesNames = parser.getClassNameList();
    ObservableList<String> classNames = FXCollections.observableArrayList();
    classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

    createAndHandleRadioButtons(getClassesNames, expressionListView);
  }

  private void fillEnvironmentScrollPane() {
    ArrayList<String> getClassesNames;
    Packageparser parser = new Packageparser(PACKAGE_ENVIRONMENT);
    getClassesNames = parser.getClassNameList();
    ObservableList<String> classNames = FXCollections.observableArrayList();
    classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

    createAndHandleRadioButtons(getClassesNames, environmentListView);
  }

  private void createAndHandleRadioButtons(ArrayList<String> getClassesNames,
      JFXListView container) {
//    GridPane gridPane = new GridPane();
//    container.setContent(gridPane);
//    ToggleGroup toggleGroup = new ToggleGroup();
//
//    int startIndex = 0;
//    int endIndex = 0;
//
//    gridPane.setHgap(10);
//    gridPane.setVgap(10);
//    gridPane.setPadding(new Insets(10, 10, 10, 10));
//
//    for (int i = 0; i < getClassesNames.size(); i++) {
//      RadioButton button = new RadioButton(getClassesNames.get(i));
//      button.setToggleGroup(toggleGroup);
//      button.getStylesheets()
//          .add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());
//      button.setFont(Font.font("Arial", 15));
//
//      button.setOnAction((event) ->
//      {
//        currentRadioButton = (RadioButton) event.getSource();
//        currentReeti.doAnimation(button.getText(), 500, true);
//      });
//      if (i % 3 == 2) {
//        gridPane.add(button, startIndex, endIndex);
//        endIndex++;
//        startIndex = 0;
//      } else {
//        gridPane.add(button, startIndex, endIndex);
//        startIndex++;
//      }
//    }
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
