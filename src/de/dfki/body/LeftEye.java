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
public class LeftEye extends ReetiBodyPart {

  private Group leftEyeGroup;

  public LeftEye(Head head) {
    x_Rotation = 5;

    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");
    ColModelImporter importer = new ColModelImporter();
    importer.read(url);
    leftEyeGroup = (Group) importer.getImport()[0];

    init();

    head.getHeadGroup().getChildren().add(leftEyeGroup);
    LOGGER.log(Level.INFO, "Left Eye wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
    leftEyeGroup.setTranslateX(Constants.LEFT_EYE_X_POSITION);
    leftEyeGroup.setTranslateY(Constants.EYE_Y_POSITION);
    leftEyeGroup.setTranslateZ(Constants.EYE_Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {
    transformate(leftEyeGroup, 0, 0, 0);
  }
}
