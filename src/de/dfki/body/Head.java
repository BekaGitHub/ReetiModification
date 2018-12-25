package de.dfki.body;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.animationlogic.commonlogic.Animation;
import de.dfki.movement.bodyparts.Rotation;
import de.dfki.reader.StlFile;
import de.dfki.main.Constants;
import java.util.logging.Level;
import javafx.scene.Group;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class Head extends BodyPart {

  private static final int START_ROTATION_GRAD = -92;

  private Group headGroup;

  public Head(Reeti reeti) {

    MeshView headMeshView = new StlFile().read("BodyParts/Reeti/v1.stl");
    headMeshView.setRotate(START_ROTATION_GRAD);
    headGroup = new Group();
    headGroup.getChildren().add(headMeshView);

    headGroup.setTranslateY(Constants.HEAD_Y_POSITION);
    headGroup.setTranslateZ(Constants.Z_TRANSLATION);
    getChildren().add(headGroup);
    LOGGER.log(Level.INFO, "Head wurde erzeugt");
  }

  @Override
  public void calculate(int step) {
    new Rotation().execute(headGroup, 0, 25, -25, x_Rotation, y_Rotation, z_Rotation);
  }

  @Override
  public void onAnimation(AnimationContent animationContent) {
    new Animation().onAnimation(animationContent);
  }

  public Group getHeadGroup() {
    return headGroup;
  }
}
