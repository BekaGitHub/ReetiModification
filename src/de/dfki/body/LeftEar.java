/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.util.Constants;
import java.net.URL;
import java.util.logging.Level;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class LeftEar extends ReetiParts {

  private MeshView leftEarMesh;

  public LeftEar(Head head) {
    color = Color.WHITE;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiLeftEar.dae");

    importer.read(url);
    leftEarMesh = (MeshView) importer.getImport()[0];
    leftEarMesh.setMaterial(getMaterial());

    init();

    head.getHeadGroup().getChildren().add(leftEarMesh);
    LOGGER.log(Level.INFO,"Left Ear wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    leftEarMesh.setTranslateX(Constants.LEFT_EAR_X_POSITION);
    leftEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, Rotate.Z_AXIS);

    leftEarMesh.getTransforms().clear();
    leftEarMesh.getTransforms().addAll(rz, ry, rx);
  }
}
