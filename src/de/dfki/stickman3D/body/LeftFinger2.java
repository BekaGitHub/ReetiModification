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
public class LeftFinger2 extends Stickman3DParts {

  private static final int ARMLENGTH = 80;
  public LeftFinger2.SHAPE mShape = LeftFinger2.SHAPE.DEFAULT;
  private MeshView mLeftFinger2;
  private PhongMaterial material;
  public LeftFinger2(LeftWrist3D leftWrist) {
    mSize = new Dimension(ARMLENGTH, ARMLENGTH);
    color = Color.rgb(242, 227, 217, 1);
    mDefaultRotation = -20;
    mZRotation = 0;
    mToDegreeX = mDefaultRotation;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger2_3_4.dae");
    importer.read(url);
    mLeftFinger2 = (MeshView) importer.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mLeftFinger2.setMaterial(material);

    leftWrist.getLeftWristGroup().getChildren().add(mLeftFinger2);

    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = LeftFinger2.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

    mLeftFinger2.setTranslateX(mStart.x - 3);
    mLeftFinger2.setTranslateY(mStart.y + 17);
    mLeftFinger2.setTranslateZ(0);

    mLeftFinger2.getTransforms().clear();
    mLeftFinger2.getTransforms().addAll(rx, ry, rz);

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mLeftFinger2.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mLeftFinger2.setVisible(true);

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
    mLeftFinger2.setMaterial(material);
  }

  public MeshView getLeftFinger2() {
    return mLeftFinger2;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }

}
