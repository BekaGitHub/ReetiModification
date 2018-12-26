/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import de.dfki.animationlogic.Animation;
import de.dfki.movement.bodyparts.Rotation;
import de.dfki.reader.DaeFile;
import de.dfki.style.Material;
import de.dfki.main.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.animation.Timeline;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class LeftEar extends BodyPart {

  private MeshView leftEarMesh;

  public LeftEar(Head head) {

    leftEarMesh = (MeshView) new DaeFile().read("BodyParts/Reeti/ReetiLeftEar.dae");
    leftEarMesh.setMaterial(Material.getInstance().getMaterial());

    leftEarMesh.setTranslateX(Constants.LEFT_EAR_X_POSITION);
    leftEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
    calculate(0);

    head.getHeadGroup().getChildren().add(leftEarMesh);
    LOGGER.log(Level.INFO, "Left Ear wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(leftEarMesh, 0, 0, 0, x_Rotation, y_Rotation, z_Rotation);
  }

  @Override
  public Timeline onAnimation(AnimationContent animationContent) {
    return new Animation().onAnimation(animationContent);
  }

  public MeshView getLeftEarMesh() {
    return leftEarMesh;
  }
}
