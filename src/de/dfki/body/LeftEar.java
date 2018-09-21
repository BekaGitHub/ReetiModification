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
public class LeftEar extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private MeshView leftEarMesh;
  private AnimationTest animationTest;

  public LeftEar(Head head) {
    color = Color.WHITE;

    leftEarMesh = readDaeFile("BodyParts/Reeti/ReetiLeftEar.dae", 0);
    leftEarMesh.setMaterial(getMaterial());
    init();

    head.getHeadGroup().getChildren().add(leftEarMesh);
    LOGGER.log(Level.INFO, "Left Ear wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    leftEarMesh.setTranslateX(Constants.LEFT_EAR_X_POSITION);
    leftEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
  }

  @Override
  public void calculate(int step) {
    transformate(leftEarMesh, 0, 0, 0);
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

  public MeshView getLeftEarMesh() {
    return leftEarMesh;
  }
}
