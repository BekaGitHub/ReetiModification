package de.dfki.agent;

import de.dfki.animation.blink.Blinking;
import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationSchedulerReeti;
import de.dfki.body.Body;
import de.dfki.body.Head;
import de.dfki.body.LeftCheek;
import de.dfki.body.LeftEar;
import de.dfki.body.LeftEye;
import de.dfki.body.LeftEyelid;
import de.dfki.body.Mouth;
import de.dfki.body.MouthDownLip;
import de.dfki.body.MouthLeftCorner;
import de.dfki.body.MouthRightCorner;
import de.dfki.body.MouthUpperLip;
import de.dfki.body.RightCheek;
import de.dfki.body.RightEar;
import de.dfki.body.RightEye;
import de.dfki.body.RightEyelid;
import de.dfki.util.Led;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class Reeti extends Pane implements Agent {

  public final Logger logger = Logger.getAnonymousLogger();
  public Blinking blinking;
  public AnimationSchedulerReeti animationSchedulerReeti;
  public Semaphore animationLaunchControlSemaphor = new Semaphore(1);
  // body parts
  private Head head;
  private LeftEyelid leftEyelid;
  private LeftEye leftEye;
  private RightEye rightEye;
  private LeftEar leftEar;
  private RightEar rightEar;
  private RightEyelid rightEyelid;
  private LeftCheek leftCheek;
  private RightCheek rightCheek;
  private Mouth mouth;
  private MouthLeftCorner mouthLeftCorner;
  private MouthRightCorner mouthRightCorner;
  private MouthUpperLip mouthUpperLip;
  private MouthDownLip mouthDownLip;
  private Body body;
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


  public Reeti() {
    this.init();
    this.addAllParts();
    this.setAgentOnScreen();
    logger.log(Level.INFO, "Reeti wurde erzeugt");
  }

  private void init() {
    setHead(new Head(this));
    setLeftEyelid(new LeftEyelid(getHead()));
    setLeftEye(new LeftEye(getHead()));
    setRightEye(new RightEye(getHead()));
    setLeftEar(new LeftEar(getHead()));
    setRightEar(new RightEar(getHead()));
    setRightEyelid(new RightEyelid(getHead()));
    setLeftCheek(new LeftCheek(getHead()));
    setRightCheek(new RightCheek(getHead()));
    setMouth(new Mouth(getHead()));
    setMouthLeftCorner(new MouthLeftCorner(getMouth()));
    setMouthRightCorner(new MouthRightCorner(getMouth()));
    setMouthUpperLip(new MouthUpperLip(getMouth()));
    setMouthDownLip(new MouthDownLip(getMouth()));
    setBody(new Body());
//    this.speechBubbleFX = new SpeechBubbleFX(head);

    animationSchedulerReeti = new AnimationSchedulerReeti(this);
    animationSchedulerReeti.start();
  }

  @Override
  public AnimationReeti doAnimation(String name, int duration, boolean block) {
    return doAnimation(name, duration, "", block);
  }

  public AnimationReeti doAnimation(String name, boolean block) {
    return doAnimation(name, -1, "", block);
  }

  @Override
  public AnimationReeti doAnimation(String name, int duration, Object param, boolean block) {
    AnimationReeti animationReeti = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, name, duration, block);

    try {
      animationLaunchControlSemaphor.acquire();
      animationReeti.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
    }

    return animationReeti;
  }

  private void setAgentOnScreen() {
    this.setTranslateX(de.dfki.util.Dimension.getReetiStage_X_Center());
    this.setTranslateY(de.dfki.util.Dimension.getScreenHight());
  }

  private void addAllParts() {
    this.getChildren().addAll(getHead(), getBody());
//    this.getChildren().addAll(neck, head, body, speechBubbleFX);
  }

  public void ledON(Color color, Led led) {
    switch (led) {
      case LEFT:
        setLedColor(color, color, color, 0.3f, 0.9f, 0.1f, "L");
        break;
      case RIGHT:
        setLedColor(color, color, color, 0.3f, 0.9f, 0.1f, "R");
        break;
      default:
        setLedColor(color, color, color, 0.3f, 0.9f, 0.1f, "B");
        break;
    }
  }

  public void ledOFF() {
    getRightCheek().getLedGroup().setVisible(false);
    getLeftCheek().getLedGroup().setVisible(false);
  }

  private void setLedColor(Color color1, Color color2, Color color3,
      float intensityForColor1,
      float intensityForColor2,
      float intensitiForColor3,
      String cheek) {

    int size = getLeftCheek().getSize();

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
      getLeftCheek().getLed().setEffect(ledOnShadow);
      getLeftCheek().getLed().setFill(highlightGradient);
      getLeftCheek().getLedGroup().setVisible(true);
    } else if (cheek.equalsIgnoreCase("R")) {
      getRightCheek().getLed().setEffect(ledOnShadow);
      getRightCheek().getLed().setFill(highlightGradient);
      getRightCheek().getLedGroup().setVisible(true);
    } else if (cheek.equalsIgnoreCase("B")) {
      getLeftCheek().getLed().setEffect(ledOnShadow);
      getLeftCheek().getLed().setFill(highlightGradient);
      getRightCheek().getLed().setEffect(ledOnShadow);
      getRightCheek().getLed().setFill(highlightGradient);
      getLeftCheek().getLedGroup().setVisible(true);
      getRightCheek().getLedGroup().setVisible(true);
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
    this.getMouthRightCorner().setRightCornerRegulator(distance);
    rightCornerOldPos = pos;
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "RightLC", (int) dur, pos, false);
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
    this.getMouthLeftCorner().setLeftCornerRegulator(distance);
    leftCornerOldPos = pos;
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "LeftLC", (int) dur, pos, false);
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
    this.getMouthUpperLip().setUpperLipRegulator(distance);
    upperLipOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "UpperLip", (int) dur, pos, false);
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
    this.getMouthDownLip().setDownLipRegulator(-distance);
    downLipOldPos = pos;

    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "DownLip", (int) dur, pos, false);
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
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
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
    }
  }

  public void defaultPose() {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "Default", 100, false);
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      logger.severe(ex.getMessage());
    }
  }

  public Head getHead() {
    return head;
  }

  public void setHead(Head head) {
    this.head = head;
  }

  public LeftEye getLeftEye() {
    return leftEye;
  }

  public RightEye getRightEye() {
    return rightEye;
  }

  public LeftEyelid getLeftEyelid() {
    return leftEyelid;
  }

  public RightEyelid getRightEyelid() {
    return rightEyelid;
  }

  public LeftEar getLeftEar() {
    return leftEar;
  }

  public void setLeftEar(LeftEar leftEar) {
    this.leftEar = leftEar;
  }

  public RightEar getRightEar() {
    return rightEar;
  }

  public void setRightEar(RightEar rightEar) {
    this.rightEar = rightEar;
  }

  public MouthLeftCorner getMouthLeftCorner() {
    return mouthLeftCorner;
  }

  public MouthRightCorner getMouthRightCorner() {
    return mouthRightCorner;
  }

  public MouthUpperLip getMouthUpperLip() {
    return mouthUpperLip;
  }

  public MouthDownLip getMouthDownLip() {
    return mouthDownLip;
  }

  public void setLeftEyelid(LeftEyelid leftEyelid) {
    this.leftEyelid = leftEyelid;
  }

  public void setLeftEye(LeftEye leftEye) {
    this.leftEye = leftEye;
  }

  public void setRightEye(RightEye rightEye) {
    this.rightEye = rightEye;
  }

  public void setRightEyelid(RightEyelid rightEyelid) {
    this.rightEyelid = rightEyelid;
  }

  public LeftCheek getLeftCheek() {
    return leftCheek;
  }

  public void setLeftCheek(LeftCheek leftCheek) {
    this.leftCheek = leftCheek;
  }

  public RightCheek getRightCheek() {
    return rightCheek;
  }

  public void setRightCheek(RightCheek rightCheek) {
    this.rightCheek = rightCheek;
  }

  public Mouth getMouth() {
    return mouth;
  }

  public void setMouth(Mouth mouth) {
    this.mouth = mouth;
  }

  public void setMouthLeftCorner(MouthLeftCorner mouthLeftCorner) {
    this.mouthLeftCorner = mouthLeftCorner;
  }

  public void setMouthRightCorner(MouthRightCorner mouthRightCorner) {
    this.mouthRightCorner = mouthRightCorner;
  }

  public void setMouthUpperLip(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  public void setMouthDownLip(MouthDownLip mouthDownLip) {
    this.mouthDownLip = mouthDownLip;
  }

  public Body getBody() {
    return body;
  }

  public void setBody(Body body) {
    this.body = body;
  }
}
