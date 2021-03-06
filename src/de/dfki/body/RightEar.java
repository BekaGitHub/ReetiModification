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
public class RightEar extends ReetiBodyPart {

  private MeshView mRightEarMesh;

  private int regulator;

  public RightEar(Head head) {
    color = Color.WHITE;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiRightEar.dae");

    importer.read(url);
    mRightEarMesh = (MeshView) importer.getImport()[0];
    mRightEarMesh.setMaterial(getMaterial());

    init();

    head.getHeadGroup().getChildren().add(mRightEarMesh);
  }

  @Override
  public void init() {
    super.init();
    mRightEarMesh.setTranslateX(Constants.RIGHT_EAR_X_POSITION);
    mRightEarMesh.setTranslateY(Constants.EAR_Y_POSITION);
    LOGGER.log(Level.INFO, "Right Ear wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    transformate(mRightEarMesh, 0, 0, 0);
  }
}
