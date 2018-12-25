package de.dfki.movement;

import de.dfki.agent.Agent;
import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.main.Constants;
import javafx.scene.Group;
import javafx.scene.shape.MeshView;

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
      rightCornerOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.LEFT_LC)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = leftCornerOldPos - movementFactor;
      leftCornerOldPos = movementFactor;
    } else if (moveCommand.equals(Constants.UPPER_LIP)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = upperLipOldPos - movementFactor;
      upperLipOldPos = movementFactor;
    }

    else if (moveCommand.equals(Constants.DOWN_LIP)) {
      movementFactor = (movementFactor * positionCorrection) / 100;
      double distance = movementFactor - downLipOldPos;
      downLipOldPos = movementFactor;
    }
  }

  public void leftEyeTilt(Reeti reeti, int position, int positionCorrection, int duration) {
    Group leftEyeGroup = reeti.getLeftEye().getLeftEyeGroup();
    AnimationContent animationContent = new AnimationContent(leftEyeGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    if (movementFactor < positionCorrection) {
      movementFactor = positionCorrection;
    }
    int movement = (int) leftEye_Y_OldPos - movementFactor;
    leftEye_Y_OldPos = position;
    animationContent.setRotationsGradAufXAxis(movement);
    reeti.getLeftEye().onAnimation(animationContent);
  }

  public void leftEyePan(Reeti reeti, int position, int duration) {
    Group leftEyeGroup = reeti.getLeftEye().getLeftEyeGroup();
    AnimationContent animationContent = new AnimationContent(leftEyeGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) leftEye_X_OldPos - movementFactor;
    leftEye_X_OldPos = position;
    animationContent.setRotationsGradAufYAxis(movement);
    reeti.getLeftEye().onAnimation(animationContent);
  }

  public void rightEyeTilt(Reeti reeti, int position, int positionCorrection, int duration) {
    Group rightEyeGroup = reeti.getRightEye().getRightEyeGroup();
    AnimationContent animationContent = new AnimationContent(rightEyeGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    if (movementFactor < positionCorrection) {
      movementFactor = positionCorrection;
    }
    int movement = (int) rightEye_Y_OldPos - movementFactor;
    rightEye_Y_OldPos = position;
    animationContent.setRotationsGradAufXAxis(movement);
    reeti.getRightEye().onAnimation(animationContent);
  }

  public void rightEyePan(Reeti reeti, int position, int duration) {
    Group rightEyeGroup = reeti.getRightEye().getRightEyeGroup();
    AnimationContent animationContent = new AnimationContent(rightEyeGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) rightEye_X_OldPos - movementFactor;;
    rightEye_X_OldPos = position;
    animationContent.setRotationsGradAufYAxis(movement);
    reeti.getRightEye().onAnimation(animationContent);
  }

  public void blinkLeftEyelid(Reeti reeti, int position, int duration) {
    MeshView leftEyelidMeshView = reeti.getLeftEyelid().getLeftEyeLidMesh();
    AnimationContent animationContent = new AnimationContent(leftEyelidMeshView);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) leftEyelidOldPos - movementFactor;
    leftEyelidOldPos = position;
    animationContent.setRotationsGradAufXAxis(movement);
    reeti.getLeftEyelid().onAnimation(animationContent);
  }

  public void blinkRightEyelid(Reeti reeti, int position, int duration) {
    MeshView rightEyelidMeshView = reeti.getRightEyelid().getRightEyelid();
    AnimationContent animationContent = new AnimationContent(rightEyelidMeshView);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) rightEyelidOldPos - movementFactor;
    rightEyelidOldPos = position;
    animationContent.setRotationsGradAufXAxis(movement);
    reeti.getRightEyelid().onAnimation(animationContent);
  }

  public void leftEar(Reeti reeti, int position, int duration){
    MeshView leftEarMeshView = reeti.getLeftEar().getLeftEarMesh();
    AnimationContent animationContent = new AnimationContent(leftEarMeshView);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (leftEarOldPos - movementFactor);
    leftEarOldPos = position;
    animationContent.setRotationsGradAufZAxis(movement);
    reeti.getLeftEar().onAnimation(animationContent);
  }

  public void rightEar(Reeti reeti, int position, int duration){
    MeshView rightEarMeshView = reeti.getRightEar().getRightEarMesh();
    AnimationContent animationContent = new AnimationContent(rightEarMeshView);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(0);
    animationContent.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) ((rightEarOldPos - movementFactor) * -1);
    rightEarOldPos = position;
    animationContent.setRotationsGradAufZAxis(movement);
    reeti.getRightEar().onAnimation(animationContent);
  }

  public void neckRotation(Reeti reeti, int position, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContent animationContent = new AnimationContent(headGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(25);
    animationContent.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (neckRotatOldPos - movementFactor);
    neckRotatOldPos = position;
    animationContent.setRotationsGradAufYAxis(movement);
    reeti.getHead().onAnimation(animationContent);
  }

  public void neckPan(Reeti reeti, int position, int positionCorrection, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContent animationContent = new AnimationContent(headGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(25);
    animationContent.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (((neckPanOldPos - movementFactor) * positionCorrection) / 100);
    neckPanOldPos = position;
    animationContent.setRotationsGradAufZAxis(movement);
    reeti.getHead().onAnimation(animationContent);
  }

  public void neckTild(Reeti reeti, int position, int positionCorrection, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContent animationContent = new AnimationContent(headGroup);
    animationContent.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContent.setPivotX(0);
    animationContent.setPivotY(25);
    animationContent.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (((neckTiltOldPos - movementFactor) * positionCorrection) / 100);
    neckTiltOldPos = position;
    animationContent.setRotationsGradAufXAxis(movement);
    reeti.getHead().onAnimation(animationContent);
  }

  private int berechneMovementFactor(int position) {
    int movementFactor = position;
    if (movementFactor > 100) {
      movementFactor = 100;
    }
    return movementFactor;
  }

  private int berechneDuration(int duration) {
    int dur;
    if (duration <= 0) {
      dur = 500;
    } else {
      dur = duration;
    }
    return dur;
  }
}
