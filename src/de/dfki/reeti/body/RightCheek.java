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
public class RightCheek extends ReetiParts {

  private static final int SIZE = 70;
  private final Circle mLed;
  private final Group mLedGroup;

  public RightCheek(Head head) {
    mLed = new Circle(SIZE);
    mLedGroup = new Group();

    mYRotation = 25;
    xRotation = -10;
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    mLedGroup.getTransforms().addAll(rx, ry);

    mLedGroup.getChildren().add(mLed);

    mLedGroup.setVisible(false);
    init();

    head.getHeadGroup().getChildren().add(mLedGroup);
  }

  @Override
  public void init() {
    super.init();
    mLed.setTranslateX(Constants.LED_X_POSITION);
    mLed.setTranslateZ(Constants.LEFT_LED_Z_POSITION);
  }

  public Circle getLed() {
    return mLed;
  }

  public Group getLedGroup() {
    return mLedGroup;
  }
}
