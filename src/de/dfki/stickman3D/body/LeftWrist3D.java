/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import java.awt.Dimension;
import java.net.URL;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * @author Beka
 */
public class LeftWrist3D extends Stickman3DParts {

  private static final int ARMLENGTH = 80;
  public LeftWrist3D.SHAPE mShape = LeftWrist3D.SHAPE.DEFAULT;
  private MeshView mLeftWristMesh;
  private PhongMaterial material;
  private Group leftWristGroup;

  public LeftWrist3D(LeftForeArm3D leftForeArmFX) {
    mSize = new Dimension(ARMLENGTH, ARMLENGTH);
    color = Color.rgb(242, 227, 217, 1);
    mToDegreeX = mDefaultRotation;
    mZRotation = 0;
    mYRotation = -50;

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/LeftWrist.dae");
    importer.read(url);
    mLeftWristMesh = (MeshView) importer.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mLeftWristMesh.setMaterial(material);

    leftWristGroup = new Group();
    leftWristGroup.getChildren().add(mLeftWristMesh);

    leftForeArmFX.getLeftForeArmGroup().getChildren().add(leftWristGroup);

    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = LeftWrist3D.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

    leftWristGroup.setTranslateX(mStart.x);
    leftWristGroup.setTranslateY(mStart.y + 70);
    leftWristGroup.setTranslateZ(0);

    leftWristGroup.getTransforms().clear();
    leftWristGroup.getTransforms().addAll(rx, ry, rz);

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mLeftWristMesh.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mLeftWristMesh.setVisible(true);

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
    mLeftWristMesh.setMaterial(material);
  }

  public MeshView getLeftWristMesh() {
    return mLeftWristMesh;
  }

  public Group getLeftWristGroup() {
    return leftWristGroup;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }
}
