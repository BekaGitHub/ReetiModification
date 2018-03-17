package de.dfki.reeti;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.agents.Agent3D;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.parts.FXParts;
import de.dfki.reeti.animation.environment.Blinking;
import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationSchedulerReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.body.Body;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.LeftCheek;
import de.dfki.reeti.body.LeftEar;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.LeftEyelid;
import de.dfki.reeti.body.Mouth;
import de.dfki.reeti.body.MouthDownLip;
import de.dfki.reeti.body.MouthLeftCorner;
import de.dfki.reeti.body.MouthRightCorner;
import de.dfki.reeti.body.MouthUpperLip;
import de.dfki.reeti.body.Neck;
import de.dfki.reeti.body.RightCheek;
import de.dfki.reeti.body.RightEar;
import de.dfki.reeti.body.RightEye;
import de.dfki.reeti.body.RightEyelid;
import de.dfki.reeti.environment.SpeechBubbleFX;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri <p> This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot by Ross Ching in
 * 2012
 */
public class Reeti extends Agent3D {

  private static final double REETI_HEIGHT = 480;
  private static Reeti sReeti;
  // logging
  public final Logger mLogger = Logger.getAnonymousLogger();
  public Blinking mBlinking;
  public AnimationSchedulerReeti mAnimationSchedulerReeti;
  // body parts
  public Head head;
  public LeftEyelid leftEyelid;
  public LeftEye leftEye;
  public RightEye rightEye;
  public LeftEar leftEar;
  public RightEar rightEar;
  public RightEyelid rightEyelid;
  public LeftCheek leftCheek;
  public RightCheek rightCheek;
  public Mouth mouth;
  public MouthLeftCorner mouthLeftCorner;
  public MouthRightCorner mouthRightCorner;
  public MouthUpperLip mouthUpperLip;
  public MouthDownLip mouthDownLip;
  public Neck neck;
  public Body body;
  // environment
  public SpeechBubbleFX speechBubbleFX;
  private StageRoom stageController = null;
  //Movement
  private double upperLipOldPos = 0;
  private double downLipOldPos = 20;
  private double leftCornerOldPos = 8;
  private double rightCornerOldPos = 8;
  private double leftEyelidOldPos = 100;
  private double rightEyelidOldPos = 100;
  private double leftEye_X_OldPos = 40;
  private double leftEye_Y_OldPos = 42;
  private double rightEye_X_OldPos = 60;
  private double rightEye_Y_OldPos = 42;
  private double leftEarOldPos = 80;
  private double rightEarOldPos = 80;
  private double neckRotatOldPos = 50;
  private double neckPanOldPos = 50;
  private double neckTiltOldPos = 50;

  public Reeti(String name, Gender.TYPE gender, float scale, Dimension size) {
    this.size = size;
    this.mScale = scale;
    this.isFullScreen = true;
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.posOnScreen();
    sReeti = this;
  }

  public Reeti(String name, Gender.TYPE gender, float scale, double height) {
    this.mScale = scale;
    this.isFullScreen = false;
    setStageHeight(height);
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.posOnScreen();
    sReeti = this;
  }

  public Reeti(String name, Gender.TYPE gender) {
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.posOnScreen();
    sReeti = this;
  }

  //VSM static stuff
  public static void vsm_ledOn(String color) {
    sReeti.setLedColor(color);
  }

  public static void vsm_ledOf() {
    sReeti.ledOFF("B");
  }

  public static void vsm_rightLC(int pos, int duration) {
    sReeti.rightLC(pos, duration);
  }

  public static void vsm_leftLC(int pos, int duration) {
    sReeti.leftLC(pos, duration);
  }

  public static void vsm_topLip(int pos, int duration) {
    sReeti.topLip(pos, duration);
  }

  public static void vsm_bottomLip(int pos, int duration) {
    sReeti.bottomLip(pos, duration);
  }

  public static void vsm_leftEyeTilt(int pos, int duration) {
    sReeti.leftEyeTilt(pos, duration);
  }

  public static void vsm_rightEyeTilt(int pos, int duration) {
    sReeti.rightEyeTilt(pos, duration);
  }

  public static void vsm_leftEyePan(int pos, int duration) {
    sReeti.leftEyePan(pos, duration);
  }

  public static void vsm_rightEyePan(int pos, int duration) {
    sReeti.rightEyePan(pos, duration);
  }

  public static void vsm_leftEyeLid(int pos, int duration) {
    sReeti.leftEyeLid(pos, duration);
  }

  public static void vsm_rightEyeLid(int pos, int duration) {
    sReeti.rightEyeLid(pos, duration);
  }

  public static void vsm_leftEar(int pos, int duration) {
    sReeti.leftEar(pos, duration);
  }

  public static void vsm_rightEar(int pos, int duration) {
    sReeti.rightEar(pos, duration);
  }

  public static void vsm_neckRotat(int pos, int duration) {
    sReeti.neckRotat(pos, duration);
  }

  public static void vsm_neckPan(int pos, int duration) {
    sReeti.neckPan(pos, duration);
  }

  public static void vsm_neckTilt(int pos, int duration) {
    sReeti.neckTilt(pos, duration);
  }

  public static void vsm_defaultPose() {
    sReeti.defaultPose();
  }

  private void init() {
    name = "Reeti";
    head = new Head(this);
    leftEyelid = new LeftEyelid(head);
    leftEye = new LeftEye(head);
    rightEye = new RightEye(head);
    leftEar = new LeftEar(head);
    rightEar = new RightEar(head);
    rightEyelid = new RightEyelid(head);
//    this.leftCheek = new LeftCheek(head);
//    this.rightCheek = new RightCheek(head);
    this.mouth = new Mouth(head);
    this.mouthLeftCorner = new MouthLeftCorner(mouth);
    this.mouthRightCorner = new MouthRightCorner(mouth);
    this.mouthUpperLip = new MouthUpperLip(mouth);
    this.mouthDownLip = new MouthDownLip(mouth);
//    this.neck = new Neck(head);
    this.body = new Body();
//    this.speechBubbleFX = new SpeechBubbleFX(head);

//    this.setPrefHeight(size.height);
//    this.setPrefWidth(size.width);
//    this.setMinHeight(size.height);
//    this.setMinWidth(size.width);

    InnerShadow is = new InnerShadow();
    is.setOffsetX(4.0f);
    is.setOffsetY(4.0f);

    ConsoleHandler ch = new ConsoleHandler();
    ch.setFormatter(new logFormatter());

    this.mLogger.addHandler(ch);
    this.mLogger.setUseParentHandlers(false);

    this.mAnimationSchedulerReeti = new AnimationSchedulerReeti(this);
    this.mAnimationSchedulerReeti.start();
  }

  @Override
  public AnimationReeti doEventFeedbackAnimation(String name, int duration,
      WordTimeMarkSequence wts, boolean block) {
    EventAnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadEventAnimation(this, name, duration, block);

    a.setParameter(wts);

    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }

    return a;
  }

  @Override
  public StageRoom getStageController() {
    return stageController;
  }

  @Override
  public void setStageController(StageRoom s) {
    stageController = s;
  }

  @Override
  public boolean isShowName() {
    return false;
  }

  @Override
  public void setShowName(boolean show) {

  }

  @Override
  public void endAnimationScheduler() {

  }

  @Override
  public Gender.TYPE getType() {
    return null;
  }

  @Override
  public AnimationReeti doAnimation(String name, int duration, boolean block) {
    return doAnimation(name, duration, "", block);
  }

  @Override
  public AnimationReeti doAnimation(String name, int frequent, int actionDuration, boolean block) {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, name, frequent, actionDuration, block);

    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }

    return a;
  }

  @Override
  public AnimationReeti doAnimation(String name, Object param, boolean block) {
    return doAnimation(name, -1, param, block);
  }

  public AnimationReeti doAnimation(String name, boolean block) {
    return doAnimation(name, -1, "", block);
  }

  @Override
  public AnimationReeti doAnimation(String name, int duration, Object param, boolean block) {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, name, duration, block);

    a.setParameter(param); // this is for now only used by the Speech Bubble

    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }

    return a;
  }

  public void playAnimation(AnimationReeti a) {
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  public void posOnScreen(float... pos) {
    this.setTranslateX(de.dfki.reeti.util.Dimension.getReetiStage_X_Center());
    this.setTranslateY(de.dfki.reeti.util.Dimension.getScreenHight());
  }

  @Override
  public FXParts getSpeechBubble() {
    return this.speechBubbleFX;
  }

  public void setScale(float scale) {
    mScale = scale;
  }

  private void addAllParts() {
    this.getChildren().addAll(head, body);
//    this.getChildren().addAll(neck, head, body, speechBubbleFX);
  }

  /**
   * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
   */
  public void setLedColor(String color) {
    Color ledColor = checkColor(color);
    if (ledColor.equals(Color.BLACK)) {
      ledOFF("B");
    } else {
      ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
    }
  }

  /**
   * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
   * @param led left, right, both
   */
  public void setLedColor(String color, LED led) {
    Color ledColor = checkColor(color);
    if (ledColor.equals(Color.BLACK)) {
      switch (led) {
        case LEFTLED:
          ledOFF("L");
          break;
        case RIGHTLED:
          ledOFF("R");
          break;
        default:
          ledOFF("B");
          break;
      }
    } else {
      switch (led) {
        case LEFTLED:
          ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "L");
          break;
        case RIGHTLED:
          ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "R");
          break;
        default:
          ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
          break;
      }
    }

  }

  public void setLedColor(Color color, LED led) {
    switch (led) {
      case LEFTLED:
        ledON(color, color, color, 0.3f, 0.9f, 0.1f, "L");
        break;
      case RIGHTLED:
        ledON(color, color, color, 0.3f, 0.9f, 0.1f, "R");
        break;
      default:
        ledON(color, color, color, 0.3f, 0.9f, 0.1f, "B");
        break;
    }
  }

  public void ledON(Color color1, Color color2, Color color3,
      float intensityForColor1,
      float intensityForColor2,
      float intensitiForColor3,
      String cheek) {

    int size = leftCheek.getSize();

    InnerShadow ledOnShadow = new InnerShadow(BlurType.TWO_PASS_BOX, color3, 0.05 * size,
        intensityForColor1, 0, 0);
    ledOnShadow.setInput(
        new DropShadow(BlurType.TWO_PASS_BOX, color2, 0.05 * size, intensityForColor2, 0, 0));

    RadialGradient highlightGradient = new RadialGradient(0, 0,
        0.3 * size, 0.3 * size,
        0.29 * size,
        false, CycleMethod.NO_CYCLE,
        new Stop(intensitiForColor3, color1),
        new Stop(1.0, Color.TRANSPARENT));

    if (cheek.equalsIgnoreCase("L")) {
      leftCheek.getLed().setEffect(ledOnShadow);
      leftCheek.getLed().setFill(highlightGradient);
      leftCheek.getLedGroup().setVisible(true);
    } else if (cheek.equalsIgnoreCase("R")) {
      rightCheek.getLed().setEffect(ledOnShadow);
      rightCheek.getLed().setFill(highlightGradient);
      rightCheek.getLedGroup().setVisible(true);
    } else if (cheek.equalsIgnoreCase("B")) {
      leftCheek.getLed().setEffect(ledOnShadow);
      leftCheek.getLed().setFill(highlightGradient);
      rightCheek.getLed().setEffect(ledOnShadow);
      rightCheek.getLed().setFill(highlightGradient);
      leftCheek.getLedGroup().setVisible(true);
      rightCheek.getLedGroup().setVisible(true);
    }
  }

  public void ledOFF(String cheek) {
    if (cheek.equalsIgnoreCase("R")) {
      rightCheek.getLedGroup().setVisible(false);
    } else if (cheek.equalsIgnoreCase("L")) {
      leftCheek.getLedGroup().setVisible(false);
    } else if (cheek.equalsIgnoreCase("B")) {
      rightCheek.getLedGroup().setVisible(false);
      leftCheek.getLedGroup().setVisible(false);
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */

  public void rightLC(int pos, double... duration) {
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    pos = (pos * 16) / 100;
    double distance = rightCornerOldPos - pos;
    this.mouthRightCorner.setRightCornerRegulator(distance);
    rightCornerOldPos = pos;
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "RightLC", (int) dur, pos, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void leftLC(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    pos = (pos * 16) / 100;
    double distance = leftCornerOldPos - pos;
    this.mouthLeftCorner.setLeftCornerRegulator(distance);
    leftCornerOldPos = pos;
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "LeftLC", (int) dur, pos, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 0)
   */
  public void topLip(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }

    pos = (pos * 25) / 100;

    double distance = upperLipOldPos - pos;
    this.mouthUpperLip.setUpperLipRegulator(distance);
    upperLipOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "UpperLip", (int) dur, pos, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void bottomLip(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }

    pos = (pos * 20) / 100;

    double distance = pos - downLipOldPos;
    this.mouthDownLip.setDownLipRegulator(-distance);
    downLipOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "DownLip", (int) dur, pos, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 30)
   */
  public void leftEyeTilt(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];

    if (pos > 100) {
      pos = 100;
    } else if (pos < 20) {
      pos = 20;
    }

    double rot = leftEye_Y_OldPos - pos;
    leftEye_Y_OldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "LeftEye_X", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 40)
   */
  public void leftEyePan(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = leftEye_X_OldPos - pos;
    leftEye_X_OldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "LeftEye_Y", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 30)
   */
  public void rightEyeTilt(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];

    if (pos > 100) {
      pos = 100;
    } else if (pos < 23) {
      pos = 23;
    }

    double rot = rightEye_Y_OldPos - pos;
    rightEye_Y_OldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "RightEye_X", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 60)
   */
  public void rightEyePan(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = rightEye_X_OldPos - pos;
    rightEye_X_OldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "RightEye_Y", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void leftEyeLid(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = leftEyelidOldPos - pos;
    leftEyelidOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "BlinkLeftEyelid", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void rightEyeLid(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = rightEyelidOldPos - pos;
    rightEyelidOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "BlinkRightEyelid", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void leftEar(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = leftEarOldPos - pos;
    leftEarOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "LeftEarMovement", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void rightEar(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = rightEarOldPos - pos;
    rightEarOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "RightEarMovement", (int) dur, (int) -rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckRotat(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = neckRotatOldPos - pos;
    neckRotatOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "NeckRotation", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckTilt(int pos, double... duration) {
    if (pos == -1) {
      return;
    }

    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }

    double rot = neckPanOldPos - pos;
    rot = (rot * 40) / 100;
    neckPanOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "NeckPan", (int) dur, (int) rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckPan(int pos, double... duration) {
    if (pos == -1) {
      return;
    }
    double dur = (duration.length == 0) ? 500 : duration[0];
    if (pos > 100) {
      pos = 100;
    }
    double rot = neckTiltOldPos - pos;
    rot = (rot * 40) / 100;
    neckTiltOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "NeckTilt", (int) dur, (int) -rot, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  public void defaultPose() {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "Default", 100, false);
    try {
      mAnimationLaunchControl.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  private Color checkColor(String color) {
    Color ledColor = null;
    switch (color) {
      case "red":
        ledColor = Color.RED;
        break;
      case "green":
        ledColor = Color.GREEN;
        break;
      case "lightGreen":
        ledColor = Color.LIGHTGREEN;
        break;
      case "blue":
        ledColor = Color.BLUE;
        break;
      case "darkBlue":
        ledColor = Color.DARKBLUE;
        break;
      case "turquoise":
        ledColor = Color.TURQUOISE;
        break;
      case "yellow":
        ledColor = Color.YELLOW;
        break;
      case "violet":
        ledColor = Color.VIOLET;
        break;
      case "white":
        ledColor = Color.WHITE;
        break;
      case "stop":
        ledColor = Color.BLACK;
        break;
    }
    return ledColor;
  }

  public enum LED {
    LEFTLED, RIGHTLED, BOTHLED
  }

  public Head getHead() {
    return head;
  }

  public void setHead(Head head) {
    this.head = head;
  }
}
