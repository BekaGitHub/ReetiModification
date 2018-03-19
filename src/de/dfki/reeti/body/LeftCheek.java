/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import de.dfki.reeti.util.Constants;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class LeftCheek extends ReetiParts {

  private static final int SIZE = 70;
  private final Circle led;
  private final Group ledGroup;

  public LeftCheek(Head head) {
    led = new Circle(SIZE);
    led.setStyle("-fx-background-color: black");
    ledGroup = new Group();

    y_Rotation = -25;
    xRotation = -10;
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    ledGroup.getTransforms().addAll(rx, ry);

    ledGroup.getChildren().add(led);

    ledGroup.setVisible(false);
    init();

    head.getHeadGroup().getChildren().add(ledGroup);
  }

  @Override
  public void init() {
    super.init();
    led.setTranslateX(Constants.LED_X_POSITION);
    led.setTranslateZ(Constants.LEFT_LED_Z_POSITION);
  }

  public int getSize() {
    return SIZE;
  }

  public Circle getLed() {
    return led;
  }

  public Group getLedGroup() {
    return ledGroup;
  }
}
