package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import de.dfki.reader.DaeFile;
import de.dfki.main.Constants;
import java.util.logging.Level;
import javafx.animation.Timeline;
import javafx.scene.shape.MeshView;

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
  public Timeline onAnimation(AnimationContent AnimationContent) {
    return null;
  }
}
