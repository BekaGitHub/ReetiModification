/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import java.awt.Dimension;
import java.net.URL;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * @author Beka
 */
public class RightFinger1 extends Stickman3DParts {

  private static final int ARMLENGTH = 80;
  public RightFinger1.SHAPE mShape = RightFinger1.SHAPE.DEFAULT;

  private RightWrist3D mRightWrist;
  private MeshView mRightFinger1;
  private PhongMaterial material;
  public RightFinger1(RightWrist3D rightWrist) {
    mRightWrist = rightWrist;
    mSize = new Dimension(ARMLENGTH, ARMLENGTH);
    color = Color.rgb(242, 227, 217, 1);
    mDefaultRotation = -20;
    mZRotation = -20;
    mToDegreeX = mDefaultRotation;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger1.dae");
    importer.read(url);
    mRightFinger1 = (MeshView) importer.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mRightFinger1.setMaterial(material);

    mRightWrist.getRightWristGroup().getChildren().add(mRightFinger1);

    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = RightFinger1.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

    mRightFinger1.setTranslateX(mStart.x + 9);
    mRightFinger1.setTranslateY(mStart.y + 7);
    mRightFinger1.setTranslateZ(0);

    mRightFinger1.getTransforms().clear();
    mRightFinger1.getTransforms().addAll(rx, ry, rz);

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mRightFinger1.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mRightFinger1.setVisible(true);

        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 1.0);
          update();
        } else if (color.getOpacity() != 1.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() + 0.052);
          update();
        }
        break;
    }
  }

  @Override
  public void update() {
    material.setDiffuseColor(color);
    mRightFinger1.setMaterial(material);
  }

  public MeshView getRightFinger1() {
    return mRightFinger1;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }

}
