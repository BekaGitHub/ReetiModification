package de.dfki.controllers;

import com.jfoenix.controls.JFXButton;
import de.dfki.agent.Reeti;
import de.dfki.animation.expression.Test;
import de.dfki.animation.faceparts.BlinkLeftEyelid;
import de.dfki.animation.faceparts.BlinkRightEyelid;
import de.dfki.animation.faceparts.LipDown;
import de.dfki.animation.faceparts.NeckPan;

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

}
