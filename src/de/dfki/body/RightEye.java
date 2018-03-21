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
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class RightEye extends ReetiBodyPart {

  private Group mRightEarMesh;

  public RightEye(Head head) {
    x_Rotation = 5;

    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");
    ColModelImporter importer = new ColModelImporter();
    importer.read(url);
    mRightEarMesh = (Group) importer.getImport()[0];

    init();

    head.getHeadGroup().getChildren().add(mRightEarMesh);
    LOGGER.log(Level.INFO, "Right Eye wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    mRightEarMesh.setTranslateX(Constants.RIGHT_EYE_X_POSITION);
    mRightEarMesh.setTranslateY(Constants.EYE_Y_POSITION);
    mRightEarMesh.setTranslateZ(Constants.EYE_Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {

    Rotate rx = new Rotate(x_Rotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, Rotate.Z_AXIS);

    mRightEarMesh.getTransforms().clear();
    mRightEarMesh.getTransforms().addAll(rz, ry, rx);

  }
}
