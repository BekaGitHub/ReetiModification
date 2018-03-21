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
public class LeftEyelid extends ReetiBodyPart {

  private MeshView leftEyeLidMesh;

  public LeftEyelid(Head head) {
    z_Rotation = 30;
    y_Rotation = -10;
    color = Color.WHITE;

    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid.dae");
    ColModelImporter importer = new ColModelImporter();
    importer.read(url);
    leftEyeLidMesh = (MeshView) importer.getImport()[0];

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

    Rotate rx = new Rotate(x_Rotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, Rotate.Z_AXIS);

    leftEyeLidMesh.getTransforms().clear();
    leftEyeLidMesh.getTransforms().addAll(rz, ry, rx);

  }
}
