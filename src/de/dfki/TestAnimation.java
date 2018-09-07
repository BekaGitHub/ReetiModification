package de.dfki;

import de.dfki.agent.Reeti;
import de.dfki.animation.AgentAnimationTimer;
import javafx.scene.transform.Rotate;

public class TestAnimation extends AgentAnimationTimer {

  double movementStep;

  public TestAnimation(Reeti reeti, int movement, int duration) {
    super(reeti, movement, duration);
  }
  @Override
  public void doAnimation() {
    if (movementStep <= TOTAL_ANIMATION_STEPS) {
      movementStep += movement / TOTAL_ANIMATION_STEPS;
      calculateMovement(movementStep);
    }
  }

    private void calculateMovement(double movementStep) {
      Reeti reeti = (Reeti) agent;
      Rotate rx = new Rotate(0, 0, 25, -25, Rotate.X_AXIS);
      Rotate ry = new Rotate(0, 0, 25, -25, Rotate.Y_AXIS);
      Rotate rz = new Rotate(movementStep, 0, 25, -25, Rotate.Z_AXIS);

      reeti.getHead().getHeadGroup().getTransforms().clear();
      reeti.getHead().getHeadGroup().getTransforms().addAll(rz, ry, rx);
    }

  private double getMovementStep(double duration) {
    return  TOTAL_ANIMATION_STEPS / duration;
  }
}
