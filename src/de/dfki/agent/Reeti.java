package de.dfki.agent;

import de.dfki.animation.blink.Blinking;
import de.dfki.animationlogic.reeti.AnimationLoaderReeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
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
import de.dfki.movement.MoveReetiPart;
import de.dfki.speaking.SpeechBubble;
import de.dfki.util.Constants;
import de.dfki.util.Led;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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

  private SpeechBubble speechBubble;

  //Movement
  private MoveReetiPart moveReetiPart;

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
    moveReetiPart = new MoveReetiPart();
    speechBubble = new SpeechBubble(head);
  }

  public void showSpeechBubble(String text) {
    Platform.runLater(() -> speechBubble.showSpeechBubble(text));
  }

  public void hideSpeechBubble() {
    Platform.runLater(() -> speechBubble.hideSpeechBubble());
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
    animationReeti.start();
    return animationReeti;
  }

  private void setAgentOnScreen() {
    this.setTranslateX(de.dfki.util.Dimension.getReetiStage_X_Center());
    this.setTranslateY(de.dfki.util.Dimension.getScreenHight());
  }

  private void addAllParts() {
    this.getChildren().addAll(getHead(), getBody(), speechBubble);
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

  public void rightLC(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.RIGHT_LC, pos, 16, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void leftLC(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.LEFT_LC, pos, 16, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 0)
   */
  public void topLip(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.UPPER_LIP, pos, 25, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void bottomLip(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.DOWN_LIP, pos, 20, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 30)
   */
  public void leftEyeTilt(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.LEFT_EYE_X, pos, 20, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 40)
   */
  public void leftEyePan(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.LEFT_EYE_Y, pos, -1, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 30)
   */
  public void rightEyeTilt(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.RIGHT_EYE_X, pos, 23, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 60)
   */
  public void rightEyePan(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.RIGHT_EYE_Y, pos, 23, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void leftEyeLid(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.BLINK_LEFT_EYELID, pos, 23, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 100)
   */
  public void rightEyeLid(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.BLINK_RIGHT_EYELID, pos, 23, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void leftEar(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.LEFT_EAR_MOVEMENT, pos, 23, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void rightEar(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.RIGHT_EAR_MOVEMENT, pos, 1, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckRotat(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.NECK_ROTATION, pos, 1, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckTilt(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.NECK_TILT, pos, 40, duration);
  }

  /**
   * @param pos a int between 0 and 100 (default value is 50)
   */
  public void neckPan(int pos, double duration) {
    moveReetiPart.movePart(this, Constants.NECK_PAN, pos, 40, duration);
  }

  public void mouthTest() {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "Mouth_O", 100, false);
    a.start();
  }

  public void defaultPose() {
    AnimationReeti a = AnimationLoaderReeti.getInstance()
        .loadAnimation(this, "Default", 100, false);
    a.start();
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

  public void setLeftEye(LeftEye leftEye) {
    this.leftEye = leftEye;
  }

  public RightEye getRightEye() {
    return rightEye;
  }

  public void setRightEye(RightEye rightEye) {
    this.rightEye = rightEye;
  }

  public LeftEyelid getLeftEyelid() {
    return leftEyelid;
  }

  public void setLeftEyelid(LeftEyelid leftEyelid) {
    this.leftEyelid = leftEyelid;
  }

  public RightEyelid getRightEyelid() {
    return rightEyelid;
  }

  public void setRightEyelid(RightEyelid rightEyelid) {
    this.rightEyelid = rightEyelid;
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

  public void setMouthLeftCorner(MouthLeftCorner mouthLeftCorner) {
    this.mouthLeftCorner = mouthLeftCorner;
  }

  public MouthRightCorner getMouthRightCorner() {
    return mouthRightCorner;
  }

  public void setMouthRightCorner(MouthRightCorner mouthRightCorner) {
    this.mouthRightCorner = mouthRightCorner;
  }

  public MouthUpperLip getMouthUpperLip() {
    return mouthUpperLip;
  }

  public void setMouthUpperLip(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  public MouthDownLip getMouthDownLip() {
    return mouthDownLip;
  }

  public void setMouthDownLip(MouthDownLip mouthDownLip) {
    this.mouthDownLip = mouthDownLip;
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

  public Body getBody() {
    return body;
  }

  public void setBody(Body body) {
    this.body = body;
  }
}
