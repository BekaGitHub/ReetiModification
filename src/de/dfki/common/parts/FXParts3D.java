package de.dfki.common.parts;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class FXParts3D extends Pane implements PartsInterface {

  public double x_Translation = 0.0;
  public double y_Translation = 0.0;
  public double z_Translation = 0.0;

  public double x_TranslationStep = 0.0f;
  public double y_TranslationStep = 0.0f;
  public double z_TranslationStep = 0.0f;

  public double xRotation = 0;
  public double y_Rotation = 0;
  public double z_Rotation = 0;
  public double toDegree = 0;

  public double x_RotationStep = 0.0f;
  public double y_RotationStep = 0.0f;
  public double z_RotationStep = 0.0f;

  public int mShapeAnimationStep = 0;
  public Color color = Color.rgb(0, 0, 0);
}
