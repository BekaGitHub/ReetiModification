/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import de.dfki.main.Constants;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class LeftCheek extends BodyPart {

  private static final int SIZE = 70;
  private final Circle led;
  private final Group ledGroup;

  public LeftCheek(Head head) {
    led = new Circle(SIZE);
    led.setStyle("-fx-background-color: black");
    ledGroup = new Group();

    y_Rotation = -25;
    x_Rotation = -10;
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rx = new Rotate(x_Rotation, Rotate.X_AXIS);
    ledGroup.getTransforms().addAll(rx, ry);

    ledGroup.getChildren().add(led);

    ledGroup.setVisible(false);

    led.setTranslateX(Constants.LED_X_POSITION);
    led.setTranslateZ(Constants.LEFT_LED_Z_POSITION);
    head.getHeadGroup().getChildren().add(ledGroup);
  }

  @Override
  public Timeline onAnimation(AnimationContent AnimationContent) {
    return null;
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
