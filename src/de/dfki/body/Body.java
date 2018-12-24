package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.reader.DaeFile;
import de.dfki.main.Constants;
import java.util.logging.Level;
import javafx.scene.shape.MeshView;

/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/**
 * @author Beka Aptsiauri
 */
public class Body extends BodyPart {

  private MeshView bodyMeshView;

  public Body() {
    bodyMeshView = (MeshView) new DaeFile().read("BodyParts/Reeti/ReetiBody.dae");
    this.getChildren().addAll(bodyMeshView);

    bodyMeshView.setTranslateY(Constants.BODY_Y_POSITION);
    bodyMeshView.setTranslateZ(Constants.BODY_Z_TRANSLATION);
    LOGGER.log(Level.INFO, "Body wurde erzeugt");
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }
}
