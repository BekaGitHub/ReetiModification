/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.movement.bodyparts.Rotation;
import de.dfki.reader.DaeFile;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.Group;

/**
 * @author Beka Aptsiauri
 */
public class RightEye extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;
  private Group rightEyeGroup;

  public RightEye(Head head) {
    x_Rotation = 5;

    rightEyeGroup = (Group) new DaeFile().read("BodyParts/Reeti/ReetiEye.dae");

    rightEyeGroup.setTranslateX(Constants.RIGHT_EYE_X_POSITION);
    rightEyeGroup.setTranslateY(Constants.EYE_Y_POSITION);
    rightEyeGroup.setTranslateZ(Constants.EYE_Z_TRANSLATION);

    head.getHeadGroup().getChildren().add(rightEyeGroup);
    LOGGER.log(Level.INFO, "Right Eye wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(rightEyeGroup, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
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

  public Group getRightEyeGroup() {
    return rightEyeGroup;
  }
}
