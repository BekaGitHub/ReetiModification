package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.util.Constants;
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
public class Body extends BodyPart {

  private MeshView bodyMeshView;

  public Body() {
    color = Color.WHITE;

    bodyMeshView = readDaeFile("BodyParts/Reeti/ReetiBody.dae", 0);
    this.getChildren().addAll(bodyMeshView);
    init();
    LOGGER.log(Level.INFO, "Body wurde erzeugt");
  }

  @Override
  public void init() {
    bodyMeshView.setTranslateY(Constants.BODY_Y_POSITION);
    bodyMeshView.setTranslateZ(Constants.BODY_Z_TRANSLATION);
  }

  @Override
  public void onAnimation(AnimationContentTest AnimationContentTest) {

  }
}
