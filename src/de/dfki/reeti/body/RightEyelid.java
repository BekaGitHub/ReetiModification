/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.reeti.util.Constants;
import java.net.URL;
import java.util.logging.Level;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class RightEyelid extends ReetiParts {

  private MeshView mLeftEyeMesh;

  public RightEyelid(Head head) {
    z_Rotation = -30;
    y_Rotation = 15;
    color = Color.WHITE;

    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid.dae");
    ColModelImporter imorter = new ColModelImporter();
    imorter.read(url);
    mLeftEyeMesh = (MeshView) imorter.getImport()[0];

    mLeftEyeMesh.setMaterial(getMaterial());

    init();

    head.getHeadGroup().getChildren().add(mLeftEyeMesh);
    LOGGER.log(Level.INFO,"Right Eyelid wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    mLeftEyeMesh.setTranslateX(Constants.RIGHT_EYE_LID_X_POSITION);
    mLeftEyeMesh.setTranslateY(Constants.EYE_LID_Y_POSITION);
    mLeftEyeMesh.setTranslateZ(Constants.EYE_LID_Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {

    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, Rotate.Z_AXIS);

    mLeftEyeMesh.getTransforms().clear();
    mLeftEyeMesh.getTransforms().addAll(rz, ry, rx);

  }

}
