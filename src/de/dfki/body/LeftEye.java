/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.animationlogic.commonlogic.Animation;
import de.dfki.movement.bodyparts.Rotation;
import de.dfki.reader.DaeFile;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.Group;

/**
 * @author Beka Aptsiauri
 */
public class LeftEye extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private Animation animation;
  private Group leftEyeGroup;

  public LeftEye(Head head) {
    x_Rotation = 5;

    leftEyeGroup = (Group) new DaeFile().read("BodyParts/Reeti/ReetiEye.dae");

    leftEyeGroup.setTranslateX(Constants.LEFT_EYE_X_POSITION);
    leftEyeGroup.setTranslateY(Constants.EYE_Y_POSITION);
    leftEyeGroup.setTranslateZ(Constants.EYE_Z_TRANSLATION);

    head.getHeadGroup().getChildren().add(leftEyeGroup);
    LOGGER.log(Level.INFO, "Left Eye wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(leftEyeGroup, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
  }

  @Override
  public void onAnimation(AnimationContent animationContent) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    animation = new Animation();
    animation.onAnimation(animationContent);
    SEMAPHORE.release();
  }

  public Group getLeftEyeGroup() {
    return leftEyeGroup;
  }
}
