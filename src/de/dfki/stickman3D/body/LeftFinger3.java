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
public class LeftFinger3 extends Stickman3DParts {

  private static final int ARMLENGTH = 80;
  public LeftFinger3.SHAPE mShape = LeftFinger3.SHAPE.DEFAULT;
  private MeshView mLeftFinger3;
  private PhongMaterial material;

  public LeftFinger3(LeftWrist3D leftWrist) {
    mSize = new Dimension(ARMLENGTH, ARMLENGTH);
    color = Color.rgb(242, 227, 217, 1);
    mDefaultRotation = -20;
    mZRotation = 0;
    mToDegreeX = mDefaultRotation;

    ColModelImporter imorter = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger2_3_4.dae");
    imorter.read(url);
    mLeftFinger3 = (MeshView) imorter.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mLeftFinger3.setMaterial(material);

    leftWrist.getLeftWristGroup().getChildren().add(mLeftFinger3);

    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = LeftFinger3.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

    mLeftFinger3.setTranslateX(mStart.x + 1);
    mLeftFinger3.setTranslateY(mStart.y + 17);
    mLeftFinger3.setTranslateZ(0);

    mLeftFinger3.getTransforms().clear();
    mLeftFinger3.getTransforms().addAll(rx, ry, rz);

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mLeftFinger3.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mLeftFinger3.setVisible(true);

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
    mLeftFinger3.setMaterial(material);
  }

  public MeshView getLeftFinger3() {
    return mLeftFinger3;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }

}
