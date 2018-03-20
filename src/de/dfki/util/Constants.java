package de.dfki.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
  public static final int HEAD_Y_POSITION = -700;
  public static final int BODY_Y_POSITION = -130;
  public static final int LEFT_EYE_X_POSITION = 55;
  public static final int RIGHT_EYE_X_POSITION = -LEFT_EYE_X_POSITION;
  public static final int EYE_Y_POSITION = -60;
  public static final int EYE_Z_TRANSLATION = -62;
  public static final int LEFT_EYE_LID_X_POSITION = 54;
  public static final int RIGHT_EYE_LID_X_POSITION = -LEFT_EYE_LID_X_POSITION;
  public static final int EYE_LID_Y_POSITION = -60;
  public static final int EYE_LID_Z_TRANSLATION = -65;
  public static final int LEFT_EAR_X_POSITION = 80;
  public static final int EAR_Y_POSITION = -50;
  public static final int RIGHT_EAR_X_POSITION = -LEFT_EAR_X_POSITION;
  public static final int MOUTH_X_POSITION = -7;
  public static final int MOUTH_Y_POSITION = -25;
  public static final int MOUTH_Z_POSITION = -137;
  public static final int LED_X_POSITION = -20;
  public static final double LEFT_LED_Z_POSITION = -132.4;

  public static final int Z_TRANSLATION = -105;
  public static final int BODY_Z_TRANSLATION = -125;

  public static final int CONTROLPANEL_WIDTH = 491;

  public final static String BASE_ANIMATIONPATH = "de.dfki.animation";
  public static final Set<String> ANIMATION_PACKAGE_NAMES = new HashSet<>(
      Arrays.asList("head", "expression", "faceparts", "blink"));
}
