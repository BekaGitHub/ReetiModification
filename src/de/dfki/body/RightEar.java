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
import de.dfki.style.Material;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class RightEar extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private MeshView rightEarMesh;
  private AnimationTest animationTest;

  public RightEar(Head head) {

    rightEarMesh = (MeshView) new DaeFile().read("BodyParts/Reeti/ReetiRightEar.dae");
    rightEarMesh.setMaterial(Material.getInstance().getMaterial());

    rightEarMesh.setTranslateX(Constants.RIGHT_EAR_X_POSITION);
    rightEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
    calculate(0);

    head.getHeadGroup().getChildren().add(rightEarMesh);
    LOGGER.log(Level.INFO, "Right Ear wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(rightEarMesh, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
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
