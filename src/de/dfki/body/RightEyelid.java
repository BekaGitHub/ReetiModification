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
public class RightEyelid extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);

  private AnimationTest animationTest;
  private MeshView rightEyelid;

  public RightEyelid(Head head) {
    z_Rotation = -30;
    y_Rotation = 15;

    rightEyelid = (MeshView) new DaeFile().read("BodyParts/Reeti/ReetiEyelid.dae");
    rightEyelid.setMaterial(Material.getInstance().getMaterial());

    rightEyelid.setTranslateX(Constants.RIGHT_EYE_LID_X_POSITION);
    rightEyelid.setTranslateY(Constants.EYE_LID_Y_POSITION);
    rightEyelid.setTranslateZ(Constants.EYE_LID_Z_TRANSLATION);
    calculate(0);

    head.getHeadGroup().getChildren().add(rightEyelid);
    LOGGER.log(Level.INFO, "Right Eyelid wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(rightEyelid, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
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

  public MeshView getRightEyelid() {
    return rightEyelid;
  }
}
