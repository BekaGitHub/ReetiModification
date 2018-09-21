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
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class LeftEyelid extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;
  private MeshView leftEyeLidMesh;

  public LeftEyelid(Head head) {
    z_Rotation = 30;
    y_Rotation = -10;
    color = Color.WHITE;

    leftEyeLidMesh = readDaeFile("BodyParts/Reeti/ReetiEyelid.dae", 0);
    leftEyeLidMesh.setMaterial(getMaterial());

    init();

    head.getHeadGroup().getChildren().add(leftEyeLidMesh);
    LOGGER.log(Level.INFO, "Left Eyelid wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    leftEyeLidMesh.setTranslateX(Constants.LEFT_EYE_LID_X_POSITION);
    leftEyeLidMesh.setTranslateY(Constants.EYE_LID_Y_POSITION);
    leftEyeLidMesh.setTranslateZ(Constants.EYE_LID_Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {
    transformate(leftEyeLidMesh, 0, 0, 0);
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

  public MeshView getLeftEyeLidMesh() {
    return leftEyeLidMesh;
  }
}
