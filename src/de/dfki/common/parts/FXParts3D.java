package de.dfki.common.parts;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class FXParts3D extends FXParts {

  public double mXTranslation = mDefaultTranslation;
  public double mYTranslation = mDefaultTranslation;
  public double mZTranslation = mDefaultTranslation;

  public double mXTranslationStep = 0.0f;
  public double mYTranslationStep = 0.0f;
  public double mZTranslationStep = 0.0f;

  public double xRotation = mDefaultRotation;
  public double mYRotation = mDefaultRotation;
  public double mZRotation = mDefaultRotation;
  public double mToDegreeX = mDefaultRotation;
  public double mToDegreeY = mDefaultRotation;
  public double mToDegreeZ = mDefaultRotation;

  public double mXRotationStep = 0.0f;
  public double mYRotationStep = 0.0f;
  public double mZRotationStep = 0.0f;
}
