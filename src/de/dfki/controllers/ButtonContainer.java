package de.dfki.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import de.dfki.agent.Reeti;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonContainer {

  private JFXListView<JFXButton> listView;
  private ButtonActionHandler buttonActionHandler;

  public ButtonContainer(JFXListView<JFXButton> listView, Reeti reeti) {
    this.listView = listView;
    buttonActionHandler = new ButtonActionHandler(reeti);
    listView.getItems().add(createTestButton());
    listView.getItems().add(createBlinkLeftEyeLidButton());
    listView.getItems().add(createBlinkRightEyeLidButton());
    listView.getItems().add(createLipDowndButton());
    listView.getItems().add(createNeckPandButton());
    listView.getItems().add(createNeckRotationdButton());
    listView.getItems().add(createNeckTiltButton());
    listView.getItems().add(createOpenMouthButton());
    listView.getItems().add(createCloseMouthButton());
    listView.getItems().add(createGrimaceButton());
    listView.getItems().add(createRelaxedButton());
    listView.getItems().add(createSadButton());
    listView.getItems().add(createSmileButton());
  }

  private JFXButton createTestButton() {
    JFXButton jfxButton = new JFXButton("Test");
    customizeButton(jfxButton);

    buttonActionHandler.handleTestButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createBlinkLeftEyeLidButton() {
    JFXButton jfxButton = new JFXButton("Blink left eye lid");
    customizeButton(jfxButton);

    buttonActionHandler.handleBlinkLeftEyeLidButton(jfxButton);
    return jfxButton;
  }

  private JFXButton createBlinkRightEyeLidButton() {
    JFXButton jfxButton = new JFXButton("Blink right eye lid");
    customizeButton(jfxButton);

    buttonActionHandler.handleBlinkRightEyeLidButton(jfxButton);
    return jfxButton;
  }

  private JFXButton createLipDowndButton() {
    JFXButton jfxButton = new JFXButton("Lip Down");
    customizeButton(jfxButton);

    buttonActionHandler.handleLipDownButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createNeckPandButton() {
    JFXButton jfxButton = new JFXButton("Neck Pan");
    customizeButton(jfxButton);

    buttonActionHandler.handleNeckPanButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createNeckRotationdButton() {
    JFXButton jfxButton = new JFXButton("Neck Rotation");
    customizeButton(jfxButton);

    buttonActionHandler.handleNeckRotationButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createNeckTiltButton() {
    JFXButton jfxButton = new JFXButton("Neck Tilt");
    customizeButton(jfxButton);

    buttonActionHandler.handleNeckTiltButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createOpenMouthButton() {
    JFXButton jfxButton = new JFXButton("Open Mouth");
    customizeButton(jfxButton);

    buttonActionHandler.handleOpenMouthButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createCloseMouthButton() {
    JFXButton jfxButton = new JFXButton("Close Mouth");
    customizeButton(jfxButton);

    buttonActionHandler.handleCloseMouthButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createGrimaceButton() {
    JFXButton jfxButton = new JFXButton("Grimace");
    customizeButton(jfxButton);

    buttonActionHandler.handleGrimaceButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createRelaxedButton() {
    JFXButton jfxButton = new JFXButton("Relaxed");
    customizeButton(jfxButton);

    buttonActionHandler.handleRelaxedButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createSadButton() {
    JFXButton jfxButton = new JFXButton("Sad");
    customizeButton(jfxButton);

    buttonActionHandler.handleSadButton(jfxButton);

    return jfxButton;
  }

  private JFXButton createSmileButton() {
    JFXButton jfxButton = new JFXButton("Smile");
    customizeButton(jfxButton);

    buttonActionHandler.handleSmileButton(jfxButton);

    return jfxButton;
  }

  private void customizeButton(JFXButton button) {
    DropShadow ds = new DropShadow();
    ds.setOffsetY(3.0f);
    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
    button.setMinWidth(400);
    button.setMaxWidth(400);
    button.setPrefWidth(400);
    button.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
    button.setEffect(ds);
    button.setCache(true);
  }
}
