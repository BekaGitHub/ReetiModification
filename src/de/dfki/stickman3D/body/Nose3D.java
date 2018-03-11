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

/**
 * @author Beka Aptsiauri
 */
public class Nose3D extends Stickman3DParts {

  public Nose3D.SHAPE mShape = Nose3D.SHAPE.DEFAULT;
  private Head3D mHead;
  private MeshView mNose;
  private PhongMaterial material;

  public Nose3D(Head3D head) {
    mHead = head;
    mSize = new Dimension(mLength, mLength);
    color = Color.rgb(242, 227, 217, 1);

    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/nose.dae");
    importer.read(url);
    mNose = (MeshView) importer.getImport()[0];

    material = new PhongMaterial();
    material.setDiffuseColor(color);
    mNose.setMaterial(material);

    mStart = mHead.getLeftEyebrowPostion();

    init();

    mHead.getChildren().add(mNose);
  }

  @Override
  public void init() {
    super.init();
    mNose.setTranslateX(mStart.x);
    mNose.setTranslateY(mStart.y + 110);
    mNose.setTranslateZ(-15);
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = Nose3D.SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : Nose3D.SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = Nose3D.SHAPE.DEFAULT;
  }

  @Override
  public void calculate(int step) {

    switch (mShape) {
      case FADEIN:
        if (step == 2) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.0);
          update();
          mNose.setVisible(false);
        } else if (color.getOpacity() != 0.0) {
          color = new Color(color.getRed(), color.getGreen(), color.getBlue(),
              color.getOpacity() - 0.052);
          update();
        }
        break;

      case FADEOUT:
        mNose.setVisible(true);

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
    mNose.setMaterial(material);
  }

  @Override
  protected void recordColor() {
    if (mHead.getStickman().setCharacterInvisible == false) {
      mColorRecorder = color;
    }
  }

  public MeshView getNose() {
    return mNose;
  }

  public enum SHAPE {
    DEFAULT, FADEIN, FADEOUT
  }
}
