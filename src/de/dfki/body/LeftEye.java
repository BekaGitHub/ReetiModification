/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.util.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.Group;

/**
 * @author Beka Aptsiauri
 */
public class LeftEye extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;
  private Group leftEyeGroup;

  public LeftEye(Head head) {
    x_Rotation = 5;

    leftEyeGroup = readDaeFile("BodyParts/Reeti/ReetiEye.dae");
    init();

    head.getHeadGroup().getChildren().add(leftEyeGroup);
    LOGGER.log(Level.INFO, "Left Eye wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    leftEyeGroup.setTranslateX(Constants.LEFT_EYE_X_POSITION);
    leftEyeGroup.setTranslateY(Constants.EYE_Y_POSITION);
    leftEyeGroup.setTranslateZ(Constants.EYE_Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {
    transformate(leftEyeGroup, 0, 0, 0);
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    animationTest = new AnimationTest();
    animationTest.onAnimation(animationContentTest);
    SEMAPHORE.release();
  }

  public Group getLeftEyeGroup() {
    return leftEyeGroup;
  }
}
