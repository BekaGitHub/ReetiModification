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
public class RightCheek extends BodyPart {

  private static final int SIZE = 70;
  private final Circle mLed;
  private final Group mLedGroup;

  public RightCheek(Head head) {
    mLed = new Circle(SIZE);
    mLedGroup = new Group();

    y_Rotation = 25;
    x_Rotation = -10;
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rx = new Rotate(x_Rotation, Rotate.X_AXIS);
    mLedGroup.getTransforms().addAll(rx, ry);

    mLedGroup.getChildren().add(mLed);

    mLedGroup.setVisible(false);
    mLed.setTranslateX(Constants.LED_X_POSITION);
    mLed.setTranslateZ(Constants.LEFT_LED_Z_POSITION);

    head.getHeadGroup().getChildren().add(mLedGroup);
  }

  @Override
  public Timeline onAnimation(AnimationContent AnimationContent) {
    return null;
  }

  public Circle getLed() {
    return mLed;
  }

  public Group getLedGroup() {
    return mLedGroup;
  }
}
