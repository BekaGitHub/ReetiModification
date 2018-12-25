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
import de.dfki.style.Material;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class LeftEyelid extends BodyPart {

  private MeshView leftEyeLidMesh;

  public LeftEyelid(Head head) {
    z_Rotation = 30;
    y_Rotation = -10;

    leftEyeLidMesh = (MeshView) new DaeFile().read("BodyParts/Reeti/ReetiEyelid.dae");
    leftEyeLidMesh.setMaterial(Material.getInstance().getMaterial());

    leftEyeLidMesh.setTranslateX(Constants.LEFT_EYE_LID_X_POSITION);
    leftEyeLidMesh.setTranslateY(Constants.EYE_LID_Y_POSITION);
    leftEyeLidMesh.setTranslateZ(Constants.EYE_LID_Z_TRANSLATION);
    calculate(0);

    head.getHeadGroup().getChildren().add(leftEyeLidMesh);
    LOGGER.log(Level.INFO, "Left Eyelid wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(leftEyeLidMesh, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
  }

  @Override
  public void onAnimation(AnimationContent animationContent) {
    new Animation().onAnimation(animationContent);
  }

  public MeshView getLeftEyeLidMesh() {
    return leftEyeLidMesh;
  }
}
