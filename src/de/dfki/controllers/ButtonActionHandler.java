package de.dfki.controllers;

import com.jfoenix.controls.JFXButton;
import de.dfki.agent.Reeti;
import de.dfki.animation.expression.Test;
import de.dfki.animation.faceparts.BlinkLeftEyelid;
import de.dfki.animation.faceparts.BlinkRightEyelid;
import de.dfki.animation.faceparts.CloseMouth;
import de.dfki.animation.faceparts.LipDown;
import de.dfki.animation.faceparts.NeckPan;
import de.dfki.animation.faceparts.NeckRotation;
import de.dfki.animation.faceparts.NeckTilt;
import de.dfki.animation.faceparts.OpenMouth;

public class ButtonActionHandler {

  private Reeti reeti;

  public ButtonActionHandler(Reeti reeti) {
    this.reeti = reeti;
  }

  public void handleTestButton(JFXButton button) {
    Test test = new Test();
    button.setOnMouseEntered(event -> test.playAnimation(reeti));
  }

  public void handleBlinkLeftEyeLidButton(JFXButton button) {
    BlinkLeftEyelid blinkLeftEyelid = new BlinkLeftEyelid();
    button.setOnMouseClicked(event -> blinkLeftEyelid.playAnimation(reeti));
  }

  public void handleBlinkRightEyeLidButton(JFXButton button) {
    BlinkRightEyelid blinkRightEyelid = new BlinkRightEyelid();
    button.setOnMouseClicked(event -> blinkRightEyelid.playAnimation(reeti));
  }

  public void handleLipDownButton(JFXButton button) {
    LipDown lipDown = new LipDown();
    button.setOnMouseClicked(event -> lipDown.playAnimation(reeti));
  }

  public void handleNeckPanButton(JFXButton button) {
    NeckPan neckPan = new NeckPan();
    button.setOnMouseClicked(event -> neckPan.playAnimation(reeti));
  }

  public void handleNeckRotationButton(JFXButton button) {
    NeckRotation neckRotation = new NeckRotation();
    button.setOnMouseClicked(event -> neckRotation.playAnimation(reeti));
  }

  public void handleNeckTiltButton(JFXButton button) {
    NeckTilt neckTilt = new NeckTilt();
    button.setOnMouseClicked(event -> neckTilt.playAnimation(reeti));
  }

  public void handleOpenMouthButton(JFXButton button) {
    OpenMouth openMouth = new OpenMouth();
    button.setOnMouseClicked(event -> openMouth.playAnimation(reeti));
  }

  public void handleCloseMouthButton(JFXButton button) {
    CloseMouth closeMouth = new CloseMouth();
    button.setOnMouseClicked(event -> closeMouth.playAnimation(reeti));
  }

}
