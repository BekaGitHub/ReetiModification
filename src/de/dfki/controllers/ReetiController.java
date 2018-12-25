package de.dfki.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXToggleButton;
import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.movement.bodyparts.mouth.MouthBottomLipMovement;
import de.dfki.movement.bodyparts.mouth.MouthLeftCornerMovement;
import de.dfki.movement.bodyparts.mouth.MouthRightCornerMovement;
import de.dfki.movement.bodyparts.mouth.MouthUpperLipMovement;
import de.dfki.speaking.Speak;
import de.dfki.movement.CameraMovement;
import de.dfki.main.Constants;
import de.dfki.movement.bodyparts.EarMovement;
import de.dfki.movement.bodyparts.EyeLidMovement;
import de.dfki.movement.bodyparts.HeadMovement;
import de.dfki.animation.Led;
import de.dfki.movement.bodyparts.LeftEyeMovement;
import de.dfki.reader.Packageparser;
import de.dfki.movement.bodyparts.RightEyeMovement;
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
  private JFXListView<JFXButton> expressionListView;
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
  @FXML
  private JFXTextArea speakTextArea;
  @FXML
  private JFXButton speakButton;

  private Reeti reeti;

  public void initialize() {
    ButtonContainer buttonContainer = new ButtonContainer(expressionListView, reeti);
//    JFXButton jfxButton = new JFXButton("TESTING");
//    jfxButton = getDecoratedLabel(jfxButton);
//    expressionListView.getItems().add(jfxButton);
//    Test test = new Test();
//    jfxButton.setOnMouseEntered(event -> {
////      AnimationContent animationContentTest = new AnimationContent(reeti.getHead());
////      animationContentTest.setAnimationsDauerInMillisekunden(500);
////      animationContentTest.setPosition(2);
////      animationContentTest.setMouthPart(MouthPart.RIGHT_CORNER);
//      test.playAnimation(reeti);
////      reeti.getMouth().onAnimation(animationContentTest);
//    });

//    jfxButton.setOnMouseExited(event -> {
//      test.pauseAnimation(reeti);
//    });

//    fillExpressionListView();
    fillEnvironmentListView();

    setCameraToggleButton();
    initializeCameraMovement();

    initializeHeadMovement();
    initializeLeftEyeMovement();
    initializeRightEyeMovement();
    initializeEyeLidMovement();
    initializeEarMovement();

    initializeMouthLeftCornerMovement();
    initializeMouthRightCornerMovement();
    initializeMouthUpperLipMovement();
    initializeMouthBottomLipMovement();

    expressionListView.getStylesheets()
        .add(this.getClass().getResource("/de/dfki/style/listView.css").toExternalForm());
    environmentListView.getStylesheets()
        .add(this.getClass().getResource("/de/dfki/style/listView.css").toExternalForm());

    leftLedColorPicker.setOnAction(event -> reeti.ledON(leftLedColorPicker.getValue(), Led.LEFT));
    rightLedColorPicker.setOnAction(event -> reeti.ledON(rightLedColorPicker.getValue(), Led.RIGHT));
    bothLedColorPicker.setOnAction(event -> reeti.ledON(bothLedColorPicker.getValue(), Led.BOTH));
    ledOffButton.setOnAction(event -> reeti.ledOFF());

    speakButton.setOnAction((event) -> {
      String speakText = speakTextArea.getText();
      if (speakText != "" || speakText != null) {
        Speak speak = new Speak(reeti);
        speak.setText(speakText);
//        speak.setTextFromFile("C:\\Users\\Beka\\Desktop\\test.txt");
        speak.start();
      }
    });

//    exitButton.setOnAction((event) -> System.exit(0));
    exitButton.setOnAction((event) -> {
//      reeti.agentAnimationTimer.start();
      AnimationContent animationContent = new AnimationContent(reeti.getRightEar().getRightEarMesh());
    animationContent.setAnimationsDauerInMillisekunden(2000);
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    animationContent.setRotationsGradAufXAxis(0);
    animationContent.setRotationsGradAufYAxis(0);
    animationContent.setRotationsGradAufZAxis(360);

    animationContent.setAnimationCycleCounter(20);
      reeti.getRightEar().onAnimation(animationContent);
    });

  }

  private void initializeMouthBottomLipMovement() {
    MouthBottomLipMovement mouthBottomLipMovement = new MouthBottomLipMovement();
    mouthBottomLipMovement.execute(reeti.getMouthDownLip(), bottomLipSlider, bottomLipRotationField, null);
  }

  private void initializeMouthUpperLipMovement() {
    MouthUpperLipMovement mouthUpperLipMovement = new MouthUpperLipMovement();
    mouthUpperLipMovement.execute(reeti.getMouthUpperLip(), topLipSlider, topLipRotationField, null);
  }

  private void initializeMouthRightCornerMovement() {
    MouthRightCornerMovement mouthRightCornerMovement = new MouthRightCornerMovement();
    mouthRightCornerMovement.execute(reeti.getMouthRightCorner(), rightLCSlider, rightLCRotationField, null);
  }

  private void initializeMouthLeftCornerMovement() {
    MouthLeftCornerMovement mouthLeftCornerMovement = new MouthLeftCornerMovement();
    mouthLeftCornerMovement.execute(reeti.getMouthLeftCorner(), leftLCSlider, leftLCRotationField, null);
  }

  private void initializeEarMovement() {
    EarMovement earMovement = new EarMovement();
    earMovement.execute(reeti.getLeftEar(), leftEarSlider, leftEarRotationField, Rotate.Z_AXIS);
    earMovement.execute(reeti.getRightEar(), rightEarSlider, rightEarRotationField, Rotate.Z_AXIS);
  }

  private void initializeEyeLidMovement() {
    EyeLidMovement eyeLidMovement = new EyeLidMovement();
    eyeLidMovement.execute(reeti.getLeftEyelid(), leftEyeLid_X_Slider, leftEyeLid_X_RotationField, Rotate.X_AXIS);
    eyeLidMovement.execute(reeti.getRightEyelid(), rightEyeLid_X_Slider, rightEyeLid_X_RotationField, Rotate.X_AXIS);
  }

  private void initializeRightEyeMovement() {
    RightEyeMovement rightEyeMovement = new RightEyeMovement();
    rightEyeMovement.execute(reeti.getRightEye(), rightEye_X_Slider, rightEye_X_RotationFiled, Rotate.X_AXIS);
    rightEyeMovement.execute(reeti.getRightEye(), rightEye_Y_Slider, rightEye_Y_RotationFiled, Rotate.Y_AXIS);
  }

  private void initializeLeftEyeMovement() {
    LeftEyeMovement leftEyeMovement = new LeftEyeMovement();
    leftEyeMovement.execute(reeti.getLeftEye(), leftEye_X_Slider, leftEye_X_RotationFiled, Rotate.X_AXIS);
    leftEyeMovement.execute(reeti.getLeftEye(), leftEye_Y_Slider, leftEye_Y_RotationFiled, Rotate.Y_AXIS);
  }

  private void initializeHeadMovement() {
    HeadMovement headMovement = new HeadMovement();
    headMovement.execute(reeti.getHead(), head_Z_Slider, head_Z_RotationField, Rotate.Z_AXIS);
    headMovement.execute(reeti.getHead(), head_X_Slider, head_X_RotationField, Rotate.X_AXIS);
    headMovement.execute(reeti.getHead(), head_Y_Slider, head_Y_RotationField, Rotate.Y_AXIS);
  }

  private void setCameraToggleButton() {
    cameraToogleButton.selectedProperty().addListener((p, o, n) -> {
      if (p.getValue()) {
        CameraMovement.startCamera();
      } else {
        CameraMovement.stopCamera();
      }
    });
  }

  private void initializeCameraMovement() {
    CameraMovement cameraMovement = new CameraMovement();
    cameraMovement.rotateCamera(camera_X_Rotation, Rotate.X_AXIS);
    cameraMovement.rotateCamera(camera_Y_Rotation, Rotate.Y_AXIS);
    cameraMovement.rotateCamera(camera_Z_Rotation, Rotate.Z_AXIS);
    cameraMovement.translateCamera(camera_X_Translation, Rotate.X_AXIS);
    cameraMovement.translateCamera(camera_Y_Translation, Rotate.Y_AXIS);
    cameraMovement.translateCamera(camera_Z_Translation, Rotate.Z_AXIS);
    //Setze Camera Position und alle Camera Sliders auf den Defaultpunkt
    cameraResetButton.setOnAction((event) -> cameraMovement.resetCameraPosition(new ArrayList<>(
        Arrays.asList(camera_X_Rotation, camera_Y_Rotation, camera_Z_Rotation,
            camera_X_Translation, camera_Y_Translation, camera_Z_Translation))));
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
//        reeti.doAnimation(classNamesList.get(index), 500, true);
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

  private JFXButton getDecoratedLabel(JFXButton label) {
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
