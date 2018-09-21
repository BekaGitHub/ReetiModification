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
public class RightEar extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private MeshView rightEarMesh;
  private AnimationTest animationTest;

  public RightEar(Head head) {
    color = Color.WHITE;

    rightEarMesh = readDaeFile("BodyParts/Reeti/ReetiRightEar.dae", 0);
    rightEarMesh.setMaterial(getMaterial());

    init();

    head.getHeadGroup().getChildren().add(rightEarMesh);
    LOGGER.log(Level.INFO, "Right Ear wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    rightEarMesh.setTranslateX(Constants.RIGHT_EAR_X_POSITION);
    rightEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
  }

  @Override
  public void calculate(int step) {
    transformate(rightEarMesh, 0, 0, 0);
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

  public MeshView getRightEarMesh() {
    return rightEarMesh;
  }
}
