package de.dfki.movement;

import de.dfki.agent.Agent;
import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationLoaderReeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.Constants;

public class MoveReetiPart {

  private double upperLipOldPos = 0;
  private double downLipOldPos = 20;
  private double leftCornerOldPos = 8;
  private double rightCornerOldPos = 8;
  private double leftEyelidOldPos = 100;
  private double rightEyelidOldPos = 100;
  private double leftEye_X_OldPos = 40;
  private double leftEye_Y_OldPos = 42;
  private double rightEye_X_OldPos = 60;
  private double rightEye_Y_OldPos = 42;
  private double leftEarOldPos = 80;
  private double rightEarOldPos = 80;
  private double neckRotatOldPos = 50;
  private double neckPanOldPos = 50;
  private double neckTiltOldPos = 50;

  public void movePart(Agent agent, String moveCommand, int position, int positionCorrection,
      double duration) {
    double dur = 0;
    if (duration <= 0) {
      dur = 500;
    } else {
      dur = duration;
    }

    double movementFactor = position;
    if (movementFactor > 100) {
      movementFactor = 100;
    }

    if (moveCommand.equals(Constants.RIGHT_LC)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = rightCornerOldPos - movementFactor;
      ((Reeti) agent).getMouthRightCorner().setRightCornerRegulator(distance);
      rightCornerOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.LEFT_LC)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = leftCornerOldPos - movementFactor;
      ((Reeti) agent).getMouthLeftCorner().setLeftCornerRegulator(distance);
      leftCornerOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.UPPER_LIP)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = upperLipOldPos - movementFactor;
      ((Reeti) agent).getMouthUpperLip().setUpperLipRegulator(distance);
      upperLipOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.DOWN_LIP)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = movementFactor - downLipOldPos;
      ((Reeti) agent).getMouthDownLip().setDownLipRegulator(-distance);
      downLipOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.LEFT_EYE_X)) {
      if (movementFactor < positionCorrection) {
        movementFactor = positionCorrection;
      }
      movementFactor = leftEye_Y_OldPos - movementFactor;
      leftEye_Y_OldPos = movementFactor;
    } else if (moveCommand.equals(Constants.LEFT_EYE_Y)) {
      movementFactor = leftEye_X_OldPos - movementFactor;
      leftEye_X_OldPos = movementFactor;
    } else if (moveCommand.equals(Constants.RIGHT_EYE_X)) {
      if (movementFactor < positionCorrection) {
        movementFactor = positionCorrection;
      }
      movementFactor = rightEye_Y_OldPos - movementFactor;
      rightEye_Y_OldPos = movementFactor;
    } else if (moveCommand.equals(Constants.RIGHT_EYE_Y)) {
      movementFactor = rightEye_X_OldPos - movementFactor;
      rightEye_X_OldPos = movementFactor;
    } else if (moveCommand.equals(Constants.BLINK_LEFT_EYELID)) {
      movementFactor = leftEyelidOldPos - movementFactor;
      leftEyelidOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.BLINK_RIGHT_EYELID)) {
      movementFactor = rightEyelidOldPos - movementFactor;
      rightEyelidOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.LEFT_EAR_MOVEMENT)) {
      movementFactor = leftEarOldPos - movementFactor;
      leftEarOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.RIGHT_EAR_MOVEMENT)) {
      movementFactor = (rightEarOldPos - movementFactor) * -1;
      rightEarOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.NECK_ROTATION)) {
      movementFactor = neckRotatOldPos - movementFactor;
      neckRotatOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.NECK_PAN)) {
      movementFactor = ((neckPanOldPos - movementFactor) * positionCorrection) / 100;
      neckPanOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.NECK_TILT)) {
      movementFactor = -1 * ((neckTiltOldPos - movementFactor) * positionCorrection) / 100;
      neckTiltOldPos = movementFactor;
    }

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(agent, moveCommand, (int) dur, (int) movementFactor, false);
    a.start();
  }


}
