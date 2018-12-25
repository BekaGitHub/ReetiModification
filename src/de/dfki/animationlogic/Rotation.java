package de.dfki.animationlogic;

import javafx.scene.transform.Rotate;

/**
 * Die Klasse wird verwendet, um Rotationsobekt mit Pivot Elementen und mit X, Y und
 * Z Axis zu erstellen
 */
public class Rotation {

  public Rotate createXRotation(AnimationContent animationContent) {
    Rotate rx = new Rotate();
    rx.setAxis(Rotate.X_AXIS);
    setPivotElement(animationContent, rx);
//    rx.pivotXProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    rx.pivotYProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    rx.pivotZProperty().bind(animationContent.getKoerperteil().rotateProperty());

    return rx;
  }

  public Rotate createYRotation(AnimationContent animationContent) {
    Rotate ry = new Rotate();
    ry.setAxis(Rotate.Y_AXIS);
    setPivotElement(animationContent, ry);
//    ry.pivotXProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    ry.pivotYProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    ry.pivotZProperty().bind(animationContent.getKoerperteil().rotateProperty());

    return ry;
  }

  public Rotate createZRotation(AnimationContent animationContent) {
    Rotate rz = new Rotate();
    rz.setAxis(Rotate.Z_AXIS);
    setPivotElement(animationContent, rz);
//    rz.pivotXProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    rz.pivotYProperty().bind(animationContent.getKoerperteil().rotateProperty());
//    rz.pivotZProperty().bind(animationContent.getKoerperteil().rotateProperty());

    return rz;
  }

  private void setPivotElement(AnimationContent animationContent, Rotate rotation) {
    double pivotX = animationContent.getPivotX();
    double pivotY = animationContent.getPivotY();
    double pivotZ = animationContent.getPivotZ();

    rotation.pivotXProperty().bind(animationContent.getKoerperteil().rotateProperty().add(pivotX));
    rotation.pivotYProperty().bind(animationContent.getKoerperteil().rotateProperty().add(pivotY));
    rotation.pivotZProperty().bind(animationContent.getKoerperteil().rotateProperty().add(pivotZ));
  }
}
