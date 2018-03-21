/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.common.parts.FXParts3D;
import de.dfki.animationlogic.reeti.AnimatorReeti;
import java.net.URL;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.paint.PhongMaterial;

/**
 * @author Beka Aptsiauri
 */
public abstract class ReetiParts extends FXParts3D {

  private static PhongMaterial material = null;
  public static final Logger LOGGER = Logger.getLogger(ReetiParts.class.getName());

  public void init() {
    calculate(0);
  }

  @Override
  public void set_X_Translation(int length) {
    x_TranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Y_Translation(int length) {
    y_TranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Z_Translation(int length) {
    z_TranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public synchronized void calculate_X_Translation(int step) {
    x_Translation += x_TranslationStep;
    x_Translation = Math.round(x_Translation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Y_Translation(int step) {
    y_Translation += y_TranslationStep;
    y_Translation = Math.round(y_Translation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Z_Translation(int step) {
    z_Translation += z_TranslationStep;
    z_Translation = Math.round(z_Translation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public void resetTranslation() {
    x_TranslationStep = 0.0d;
    y_TranslationStep = 0.0d;
    z_TranslationStep = 0.0d;
  }

  @Override
  public void set_X_Rotation(int degree) {
    toDegree = xRotation + degree;
    x_RotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Y_Rotation(int degree) {
    y_RotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public void set_Z_Rotation(int degree) {
    z_RotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public void setTilt(int degree) {
    toDegree = xRotation + degree;
    x_RotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
  }

  @Override
  public synchronized void calculate_X_Rotation(int step) {
    xRotation += x_RotationStep;
    xRotation = (double) Math.round(xRotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Y_Rotation(int step) {
    y_Rotation += y_RotationStep;
    y_Rotation = (double) Math.round(y_Rotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));
  }

  @Override
  public synchronized void calculate_Z_Rotation(int step) {
    z_Rotation += z_RotationStep;
    z_Rotation = (double) Math.round(z_Rotation * 1000d) / 1000d;

    Platform.runLater(() -> calculate(step));

  }

  @Override
  public void reset_X_Rotation() {
    xRotation += x_RotationStep;
    Platform.runLater(() -> calculate(1));
    x_RotationStep = 0;
  }

  @Override
  public void reset_Y_Rotation() {
    y_Rotation += y_RotationStep;
    Platform.runLater(() -> calculate(1));
    y_RotationStep = 0;
  }

  @Override
  public void reset_Z_Rotation() {
    z_Rotation += z_RotationStep;
    Platform.runLater(() -> calculate(1));
    z_RotationStep = 0;
  }

  public void createShape() {
    // create the shape
  }

  @Override
  public synchronized void calculateShape(int step) {
    mShapeAnimationStep = step;

    Platform.runLater(() -> calculate(step));
  }

  public synchronized void calculate(int step) {
    createShape();
  }

  protected PhongMaterial getMaterial() {
    if (material == null) {
      URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
      javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
      material = new PhongMaterial();
      material.setDiffuseColor(color);
      material.setDiffuseMap(image);
      material.setSelfIlluminationMap(image);
    }
    return material;
  }
}
