/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import de.dfki.common.parts.FXParts3D;
import de.dfki.stickman3D.animationlogic.AnimatorStickman3D;
import java.awt.BasicStroke;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri
 */
public abstract class Stickman3DParts extends FXParts3D {

  public Color mColorRecorder = null;
  public double mXRotatationRecorder = 0;
  public double mYRotatationRecorder = 0;
  public double mZRotatationRecorder = 0;

  public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

  @Override
  public void init() {
    super.init();
    mColorRecorder = mColor;
    mXRotatationRecorder = mXRotation;
    mYRotatationRecorder = mYRotation;
    mZRotatationRecorder = mZRotation;
    calculate(0);
  }

  @Override
  public void set_X_Translation(int length) {
    mXTranslationStep = (double) length / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Y_Translation(int length) {
    mYTranslationStep = (double) length / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Z_Translation(int length) {
    mZTranslationStep = (double) length / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public synchronized void calculate_X_Translation(int step) {
    mXTranslation += mXTranslationStep;
    mXTranslation = Math.round(mXTranslation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Y_Translation(int step) {
    mYTranslation += mYTranslationStep;
    mYTranslation = Math.round(mYTranslation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Z_Translation(int step) {
    mZTranslation += mZTranslationStep;
    mZTranslation = Math.round(mZTranslation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public void resetTranslation() {
    mXTranslationStep = 0.0d;
    mYTranslationStep = 0.0d;
    mZTranslationStep = 0.0d;
  }

  public void setDefaulRotation(int degree) {
    mDefaultRotation = degree;
    mXRotation = mDefaultRotation;
    mYRotation = mDefaultRotation;
    mZRotation = mDefaultRotation;

    mToDegreeX = mDefaultRotation;
    mToDegreeY = mDefaultRotation;
    mToDegreeZ = mDefaultRotation;
    mXRotationStep = 0.0f;
  }

  @Override
  public void set_X_Rotation(int degree) {
    mToDegreeX = mXRotation + degree;
    mXRotationStep = (double) degree / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Y_Rotation(int degree) {
    mToDegreeY = mYRotation + degree;
    mYRotationStep = (double) degree / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Z_Rotation(int degree) {
    mToDegreeZ = mZRotation + degree;
    mZRotationStep = (double) degree / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public void setTilt(int degree) {
    mToDegreeX = mXRotation + degree;
    mXRotationStep = (double) degree / AnimatorStickman3D.sMAX_ANIM_STEPS;
  }

  @Override
  public synchronized void calculate_X_Rotation(int step) {
    mXRotation += mXRotationStep;
    mXRotation = (double) Math.round(mXRotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Y_Rotation(int step) {
    mYRotation += mYRotationStep;
    mYRotation = (double) Math.round(mYRotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Z_Rotation(int step) {
    mZRotation += mZRotationStep;
    mZRotation = (double) Math.round(mZRotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));

  }

  @Override
  public void reset_X_Rotation() {
    mXRotation += mXRotationStep;
    Platform.runLater(() -> calculate(1));
    mXRotationStep = 0;
  }

  @Override
  public void reset_Y_Rotation() {
    mYRotation += mYRotationStep;
    Platform.runLater(() -> calculate(1));
    mYRotationStep = 0;
  }

  @Override
  public void reset_Z_Rotation() {
    mZRotation += mZRotationStep;
    Platform.runLater(() -> calculate(1));
    mZRotationStep = 0;
  }

  public void createShape() {
    // create the shape
  }

  @Override
  public synchronized void calculateShape(int step) {
    mShapeAnimationStep = step;
    Platform.runLater(() -> calculate(step));
  }

  public void resetShape() {
    mShapeAnimationStep = 0;
  }

  public void clearChildren(Stickman3DParts bodyPartFX) {
    bodyPartFX.getChildren().clear();
  }

  public synchronized void calculate(int step) {
    createShape();
  }

  public void update() {
    recordColor();
  }

  protected void recordColor() {

  }

  public void rotatePerlinNoise(double mWobble, int x, int y) {
    Affine af = new Affine();
    // Out put perlin noise
    af.appendRotation(Math.toRadians(mWobble), x, y);
    this.getTransforms().clear();
    this.getTransforms().add(af);
  }
}
