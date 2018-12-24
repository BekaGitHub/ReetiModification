package de.dfki.body;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.movement.bodyparts.Rotation;
import de.dfki.reader.StlFile;
import de.dfki.util.Constants;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;

/**
 * @author Beka Aptsiauri
 */
public class Head extends BodyPart {

  private static final Semaphore SEMAPHORE = new Semaphore(1);
  private static final int START_ROTATION_GRAD = -92;

  private Group headGroup;
  private AnimationTest animationTest;

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
  public void onAnimation(AnimationContentTest animationContentTest) {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    animationTest = new AnimationTest();
    animationTest.onAnimation(animationContentTest);
    SEMAPHORE.release();
  }

  public void pauseAnimation() {
    animationTest.pauseAnimation();
  }

  public Group getHeadGroup() {
    return headGroup;
  }
}
