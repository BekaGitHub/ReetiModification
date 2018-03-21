package de.dfki.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.util.Constants;
import java.net.URL;
import java.util.logging.Level;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/**
 * @author Beka Aptsiauri
 */
public class Body extends ReetiBodyPart {

  public Body() {
    color = Color.WHITE;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiBody.dae");

    importer.read(url);
    MeshView mBodyMeshView = (MeshView) importer.getImport()[0];
    mBodyMeshView.setTranslateY(Constants.BODY_Y_POSITION);
    mBodyMeshView.setTranslateZ(Constants.BODY_Z_TRANSLATION);
    this.getChildren().addAll(mBodyMeshView);

    init();
    LOGGER.log(Level.INFO, "Body wurde erzeugt");
  }

  @Override
  public void init() {
    super.init();
  }
}
