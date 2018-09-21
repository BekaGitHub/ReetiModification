package de.dfki.body;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
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
    color = Color.WHITE;

    MeshView headMeshView = readStlFile("BodyParts/Reeti/v1.stl", START_ROTATION_GRAD);
    headGroup = new Group();
    headGroup.getChildren().add(headMeshView);

    init();
    getChildren().add(headGroup);
    LOGGER.log(Level.INFO, "Head wurde erzeugt");
  }

  @Override
  public void init() {
    headGroup.setTranslateY(Constants.HEAD_Y_POSITION);
    headGroup.setTranslateZ(Constants.Z_TRANSLATION);
  }

  @Override
  public void calculate(int step) {
    transformate(headGroup, 0, 25, -25);
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
