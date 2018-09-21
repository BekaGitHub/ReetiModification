package de.dfki.animationlogic.commonlogic;

import javafx.scene.Node;

/**
 * Die Klasse hält die Daten, die zur Ausführung einer Animation nötig sind.
 */
public class AnimationContentTest {

  private int animationsDauerInSekunden;
  private int animationCycleCounter = -1;

  private double rotationsGradAufXAxis;
  private double rotationsGradAufYAxis;
  private double rotationsGradAufZAxis;

  private double pivotX;
  private double pivotY;
  private double pivotZ;

  private Node koerperteil;

  public AnimationContentTest(Node koerperteil) {
    this.koerperteil = koerperteil;
  }

  public int getAnimationsDauerInSekunden() {
    return animationsDauerInSekunden;
  }

  public void setAnimationsDauerInMillisekunden(int animationsDauerInSekunden) {
    this.animationsDauerInSekunden = animationsDauerInSekunden;
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
}
