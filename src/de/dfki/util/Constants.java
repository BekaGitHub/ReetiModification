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
  public static final double MOUTH_Y_POSITION = -28;
  public static final int MOUTH_Z_POSITION = -135;
  public static final int LED_X_POSITION = -20;
  public static final double LEFT_LED_Z_POSITION = -132.4;

  public static final int Z_TRANSLATION = -105;
  public static final int BODY_Z_TRANSLATION = -125;

  public static final int CONTROLPANEL_WIDTH = 491;

  public static final int SPEECH_BUBBLE_X_POSITION = MOUTH_X_POSITION + 27;
  public static final double SPEECH_BUBBLE_Y_POSITION = MOUTH_Y_POSITION - 665;
  public static final int SPEECH_BUBBLE_Z_POSITION = Z_TRANSLATION - 145;

  public final static String BASE_ANIMATIONPATH = "de.dfki.animation";
  public static final Set<String> ANIMATION_PACKAGE_NAMES = new HashSet<>(
      Arrays.asList("head", "expression", "faceparts", "blink"));

  public static final String RIGHT_LC = "RightLC";
  public static final String LEFT_LC = "LeftLC";
  public static final String UPPER_LIP = "UpperLip";
  public static final String DOWN_LIP = "DownLip";
  public static final String LEFT_EYE_X = "LeftEye_X";
  public static final String LEFT_EYE_Y = "LeftEye_Y";
  public static final String RIGHT_EYE_X = "RightEye_X";
  public static final String RIGHT_EYE_Y = "RightEye_Y";
  public static final String BLINK_LEFT_EYELID = "BlinkLeftEyelid";
  public static final String BLINK_RIGHT_EYELID = "BlinkRightEyelid";
  public static final String LEFT_EAR_MOVEMENT = "LeftEarMovement";
  public static final String RIGHT_EAR_MOVEMENT = "RightEarMovement";
  public static final String NECK_ROTATION = "NeckRotation";
  public static final String NECK_PAN = "NeckPan";
  public static final String NECK_TILT = "NeckTilt";
}
