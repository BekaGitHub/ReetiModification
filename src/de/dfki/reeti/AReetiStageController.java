/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import de.dfki.common.AgentsOnStage;
import de.dfki.reeti.stage.ReetiStage;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author EmpaT
 */
public abstract class AReetiStageController {

  public static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.reeti.animation.face";
  public static final String PACKAGE_ENVIRONMENT = "de.dfki.reeti.animation.environment";
  public static final String PACKAGE_DYNAMIC_CLASSES = "de.dfki.stickman3D.dynamic.classes";
  public static RadioButton currentRadioButton;

  @FXML
  public HBox root;
  @FXML
  public VBox controlPanelBox;
  @FXML
  public StackPane agentStage;

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

  public boolean isCameraStarted = false;
  public String mReetiComboBox = null;
  public ToggleGroup perlinNoiseGroup;
  public AgentsOnStage mStickmanOnstage;
  public static Reeti currentReeti;
  public ReetiStage stage3D;

}
