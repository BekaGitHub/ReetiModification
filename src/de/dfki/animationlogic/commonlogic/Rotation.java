package de.dfki.animationlogic.commonlogic;

import javafx.scene.transform.Rotate;

/**
 * Die Klasse wird verwendet, um Rotationsobekt mit Pivot Elementen und mit X, Y und
 * Z Axis zu erstellen
 */
public class Rotation {

  public Rotate createXRotation(AnimationContentTest animationContentTest) {
    Rotate rx = new Rotate();
    rx.setAxis(Rotate.X_AXIS);
    setPivotElement(animationContentTest, rx);
//    rx.pivotXProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    rx.pivotYProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    rx.pivotZProperty().bind(animationContentTest.getKoerperteil().rotateProperty());

    return rx;
  }

  public Rotate createYRotation(AnimationContentTest animationContentTest) {
    Rotate ry = new Rotate();
    ry.setAxis(Rotate.Y_AXIS);
    setPivotElement(animationContentTest, ry);
//    ry.pivotXProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    ry.pivotYProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    ry.pivotZProperty().bind(animationContentTest.getKoerperteil().rotateProperty());

    return ry;
  }

  public Rotate createZRotation(AnimationContentTest animationContentTest) {
    Rotate rz = new Rotate();
    rz.setAxis(Rotate.Z_AXIS);
    setPivotElement(animationContentTest, rz);
//    rz.pivotXProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    rz.pivotYProperty().bind(animationContentTest.getKoerperteil().rotateProperty());
//    rz.pivotZProperty().bind(animationContentTest.getKoerperteil().rotateProperty());

    return rz;
  }

  private void setPivotElement(AnimationContentTest animationContentTest, Rotate rotation) {
    double pivotX = animationContentTest.getPivotX();
    double pivotY = animationContentTest.getPivotY();
    double pivotZ = animationContentTest.getPivotZ();

    rotation.pivotXProperty().bind(animationContentTest.getKoerperteil().rotateProperty().add(pivotX));
    rotation.pivotYProperty().bind(animationContentTest.getKoerperteil().rotateProperty().add(pivotY));
    rotation.pivotZProperty().bind(animationContentTest.getKoerperteil().rotateProperty().add(pivotZ));
  }
}
