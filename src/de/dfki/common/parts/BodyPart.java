package de.dfki.common.parts;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class BodyPart extends Pane {

  public double x_Translation = 0.0;
  public double y_Translation = 0.0;
  public double z_Translation = 0.0;

  public double x_TranslationStep = 0.0f;
  public double y_TranslationStep = 0.0f;
  public double z_TranslationStep = 0.0f;

  public double x_Rotation = 0;
  public double y_Rotation = 0;
  public double z_Rotation = 0;
  public double toDegree = 0;

  public double x_RotationStep = 0.0f;
  public double y_RotationStep = 0.0f;
  public double z_RotationStep = 0.0f;

  public int mShapeAnimationStep = 0;
  public Color color = Color.rgb(0, 0, 0);

  public abstract void set_X_Rotation(int degree);

  public abstract void set_Y_Rotation(int degree);

  public abstract void set_Z_Rotation(int degree);

  public abstract void setTilt(int degree);

  public abstract void set_X_Translation(int length);

  public abstract void set_Y_Translation(int length);

  public abstract void set_Z_Translation(int length);

  public abstract void setShape(String s);

  public abstract void calculate_X_Rotation(int step);

  public abstract void calculate_Y_Rotation(int step);

  public abstract void calculate_Z_Rotation(int step);

  public abstract void calculate_X_Translation(int step);

  public abstract void calculate_Y_Translation(int step);

  public abstract void calculate_Z_Translation(int step);

  public abstract void calculateShape(int step);

  public abstract void reset_X_Rotation();

  public abstract void reset_Y_Rotation();

  public abstract void reset_Z_Rotation();

  public abstract void resetRotation();

  public abstract void resetTranslation();
}
