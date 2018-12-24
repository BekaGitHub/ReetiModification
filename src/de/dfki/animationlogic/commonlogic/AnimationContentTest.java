package de.dfki.animationlogic.commonlogic;

import javafx.scene.Node;

/**
 * Die Klasse hält die Daten, die zur Ausführung einer Animation nötig sind.
 */
public class AnimationContentTest {

  private int animationsDauerInMillisekunden;
  private int animationCycleCounter = -1;

  private double rotationsGradAufXAxis;
  private double rotationsGradAufYAxis;
  private double rotationsGradAufZAxis;

  private double position;

  private double pivotX;
  private double pivotY;
  private double pivotZ;

  private Node koerperteil;
  private MouthPart mouthPart;

  public AnimationContentTest(Node koerperteil) {
    this.koerperteil = koerperteil;
  }

  public int getAnimationsDauerInMillisekunden() {
    return animationsDauerInMillisekunden;
  }

  public void setAnimationsDauerInMillisekunden(int animationsDauerInMillisekunden) {
    this.animationsDauerInMillisekunden = animationsDauerInMillisekunden;
  }

  public double getRotationsGradAufXAxis() {
    return rotationsGradAufXAxis;
  }

  public void setRotationsGradAufXAxis(double rotationsGradAufXAxis) {
    this.rotationsGradAufXAxis = rotationsGradAufXAxis;
  }

  public double getRotationsGradAufYAxis() {
    return rotationsGradAufYAxis;
  }

  public void setRotationsGradAufYAxis(double rotationsGradAufYAxis) {
    this.rotationsGradAufYAxis = rotationsGradAufYAxis;
  }

  public double getRotationsGradAufZAxis() {
    return rotationsGradAufZAxis;
  }

  public void setRotationsGradAufZAxis(double rotationsGradAufZAxis) {
    this.rotationsGradAufZAxis = rotationsGradAufZAxis;
  }

  public double getPivotX() {
    return pivotX;
  }

  public void setPivotX(double pivotX) {
    this.pivotX = pivotX;
  }

  public double getPivotY() {
    return pivotY;
  }

  public void setPivotY(double pivotY) {
    this.pivotY = pivotY;
  }

  public double getPivotZ() {
    return pivotZ;
  }

  public void setPivotZ(double pivotZ) {
    this.pivotZ = pivotZ;
  }

  public Node getKoerperteil() {
    return koerperteil;
  }

  public void setKoerperteil(Node koerperteil) {
    this.koerperteil = koerperteil;
  }

  public int getAnimationCycleCounter() {
    return animationCycleCounter;
  }

  public void setAnimationCycleCounter(int animationCycleCounter) {
    this.animationCycleCounter = animationCycleCounter;
  }

  public double getPosition() {
    return position;
  }

  public void setPosition(double position) {
    this.position = position;
  }

  public MouthPart getMouthPart() {
    return mouthPart;
  }

  public void setMouthPart(MouthPart mouthPart) {
    this.mouthPart = mouthPart;
  }
}
