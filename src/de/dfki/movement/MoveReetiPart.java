package de.dfki.movement;

import de.dfki.agent.Agent;
import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.util.Constants;
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
    AnimationContentTest animationContentTest = new AnimationContentTest(leftEyeGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    if (movementFactor < positionCorrection) {
      movementFactor = positionCorrection;
    }
    int movement = (int) leftEye_Y_OldPos - movementFactor;
    leftEye_Y_OldPos = position;
    animationContentTest.setRotationsGradAufXAxis(movement);
    reeti.getLeftEye().onAnimation(animationContentTest);
  }

  public void leftEyePan(Reeti reeti, int position, int duration) {
    Group leftEyeGroup = reeti.getLeftEye().getLeftEyeGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(leftEyeGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) leftEye_X_OldPos - movementFactor;
    leftEye_X_OldPos = position;
    animationContentTest.setRotationsGradAufYAxis(movement);
    reeti.getLeftEye().onAnimation(animationContentTest);
  }

  public void rightEyeTilt(Reeti reeti, int position, int positionCorrection, int duration) {
    Group rightEyeGroup = reeti.getRightEye().getRightEyeGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(rightEyeGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    if (movementFactor < positionCorrection) {
      movementFactor = positionCorrection;
    }
    int movement = (int) rightEye_Y_OldPos - movementFactor;
    rightEye_Y_OldPos = position;
    animationContentTest.setRotationsGradAufXAxis(movement);
    reeti.getRightEye().onAnimation(animationContentTest);
  }

  public void rightEyePan(Reeti reeti, int position, int duration) {
    Group rightEyeGroup = reeti.getRightEye().getRightEyeGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(rightEyeGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) rightEye_X_OldPos - movementFactor;;
    rightEye_X_OldPos = position;
    animationContentTest.setRotationsGradAufYAxis(movement);
    reeti.getRightEye().onAnimation(animationContentTest);
  }

  public void blinkLeftEyelid(Reeti reeti, int position, int duration) {
    MeshView leftEyelidMeshView = reeti.getLeftEyelid().getLeftEyeLidMesh();
    AnimationContentTest animationContentTest = new AnimationContentTest(leftEyelidMeshView);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) leftEyelidOldPos - movementFactor;
    leftEyelidOldPos = position;
    animationContentTest.setRotationsGradAufXAxis(movement);
    reeti.getLeftEyelid().onAnimation(animationContentTest);
  }

  public void blinkRightEyelid(Reeti reeti, int position, int duration) {
    MeshView rightEyelidMeshView = reeti.getRightEyelid().getRightEyelid();
    AnimationContentTest animationContentTest = new AnimationContentTest(rightEyelidMeshView);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) rightEyelidOldPos - movementFactor;
    rightEyelidOldPos = position;
    animationContentTest.setRotationsGradAufXAxis(movement);
    reeti.getRightEyelid().onAnimation(animationContentTest);
  }

  public void leftEar(Reeti reeti, int position, int duration){
    MeshView leftEarMeshView = reeti.getLeftEar().getLeftEarMesh();
    AnimationContentTest animationContentTest = new AnimationContentTest(leftEarMeshView);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (leftEarOldPos - movementFactor);
    leftEarOldPos = position;
    animationContentTest.setRotationsGradAufZAxis(movement);
    reeti.getLeftEar().onAnimation(animationContentTest);
  }

  public void rightEar(Reeti reeti, int position, int duration){
    MeshView rightEarMeshView = reeti.getRightEar().getRightEarMesh();
    AnimationContentTest animationContentTest = new AnimationContentTest(rightEarMeshView);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(0);
    animationContentTest.setPivotZ(0);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) ((rightEarOldPos - movementFactor) * -1);
    rightEarOldPos = position;
    animationContentTest.setRotationsGradAufZAxis(movement);
    reeti.getRightEar().onAnimation(animationContentTest);
  }

  public void neckRotation(Reeti reeti, int position, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(headGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(25);
    animationContentTest.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (neckRotatOldPos - movementFactor);
    neckRotatOldPos = position;
    animationContentTest.setRotationsGradAufYAxis(movement);
    reeti.getHead().onAnimation(animationContentTest);
  }

  public void neckPan(Reeti reeti, int position, int positionCorrection, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(headGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(25);
    animationContentTest.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (((neckPanOldPos - movementFactor) * positionCorrection) / 100);
    neckPanOldPos = position;
    animationContentTest.setRotationsGradAufZAxis(movement);
    reeti.getHead().onAnimation(animationContentTest);
  }

  public void neckTild(Reeti reeti, int position, int positionCorrection, int duration) {
    Group headGroup = reeti.getHead().getHeadGroup();
    AnimationContentTest animationContentTest = new AnimationContentTest(headGroup);
    animationContentTest.setAnimationsDauerInMillisekunden(berechneDuration(duration));
    animationContentTest.setPivotX(0);
    animationContentTest.setPivotY(25);
    animationContentTest.setPivotZ(-25);
    int movementFactor = berechneMovementFactor(position);
    int movement = (int) (((neckTiltOldPos - movementFactor) * positionCorrection) / 100);
    neckTiltOldPos = position;
    animationContentTest.setRotationsGradAufXAxis(movement);
    reeti.getHead().onAnimation(animationContentTest);
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
