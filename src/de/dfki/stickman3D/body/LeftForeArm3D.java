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
public class LeftForeArm3D extends Stickman3DParts {

  private static final int ARMLENGTH = 80;
  public LeftForeArm3D.SHAPE mShape = LeftForeArm3D.SHAPE.DEFAULT;

  private LeftUpperArm3D mLeftUpperArm;
  private MeshView mLeftForeArmMesh;
  private PhongMaterial material;
  private Group leftForeArmGroup;
  public LeftForeArm3D(LeftUpperArm3D arm) {
    mLeftUpperArm = arm;
    mSize = new Dimension(ARMLENGTH, ARMLENGTH);
    color = Color.rgb(242, 227, 217, 1);

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/ForeArm.dae");

    xRotation = -15;
    mZRotation = 10;
    mToDegreeX = mDefaultRotation;

    importer.read(url);
    mLeftForeArmMesh = (MeshView) importer.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mLeftForeArmMesh.setMaterial(material);

    leftForeArmGroup = new Group();
    leftForeArmGroup.getChildren().add(mLeftForeArmMesh);

    mLeftUpperArm.getLeftUpperArmGroup().getChildren().add(leftForeArmGroup);

    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = LeftForeArm3D.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {
    Rotate rx = new Rotate(xRotation, Rotate.X_AXIS);
    Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
    Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

    leftForeArmGroup.setTranslateX(mStart.x);
    leftForeArmGroup.setTranslateY(mStart.y + 60);
    leftForeArmGroup.setTranslateZ(0);

    leftForeArmGroup.getTransforms().clear();
    leftForeArmGroup.getTransforms().addAll(rx, ry, rz);

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mLeftForeArmMesh.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mLeftForeArmMesh.setVisible(true);

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
    mLeftForeArmMesh.setMaterial(material);
  }

  public LeftUpperArm3D getLeftUpperArm() {
    return mLeftUpperArm;
  }

  public MeshView getLeftForeArmMesh() {
    return mLeftForeArmMesh;
  }

  public Group getLeftForeArmGroup() {
    return leftForeArmGroup;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }
}
