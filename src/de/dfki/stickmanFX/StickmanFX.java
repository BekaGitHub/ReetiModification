package de.dfki.stickmanFX;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.agents.Agent2D;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.parts.FXParts;
import de.dfki.stickmanFX.animation.environmentfx.IdleBehavior;
import de.dfki.stickmanFX.animation.environmentfx.SimplexNoise;
import de.dfki.stickmanFX.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanFX.animationlogic.AnimationSchedulerFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import de.dfki.stickmanFX.animationlogic.EventAnimationFX;
import de.dfki.stickmanFX.bodyfx.BodyFX;
import de.dfki.stickmanFX.bodyfx.BombeFX;
import de.dfki.stickmanFX.bodyfx.FaceWrinkleFX;
import de.dfki.stickmanFX.bodyfx.FemaleHairFX;
import de.dfki.stickmanFX.bodyfx.HeadFX;
import de.dfki.stickmanFX.bodyfx.LeftEyeFX;
import de.dfki.stickmanFX.bodyfx.LeftEyebrowFX;
import de.dfki.stickmanFX.bodyfx.LeftFootFX;
import de.dfki.stickmanFX.bodyfx.LeftForeArmFX;
import de.dfki.stickmanFX.bodyfx.LeftForeLegFX;
import de.dfki.stickmanFX.bodyfx.LeftHandFX;
import de.dfki.stickmanFX.bodyfx.LeftShoulderFX;
import de.dfki.stickmanFX.bodyfx.LeftUpperArmFX;
import de.dfki.stickmanFX.bodyfx.LeftUpperLegFX;
import de.dfki.stickmanFX.bodyfx.MaleHairFX;
import de.dfki.stickmanFX.bodyfx.MouthFX;
import de.dfki.stickmanFX.bodyfx.NeckFX;
import de.dfki.stickmanFX.bodyfx.NoseFX;
import de.dfki.stickmanFX.bodyfx.RightEyeFX;
import de.dfki.stickmanFX.bodyfx.RightEyebrowFX;
import de.dfki.stickmanFX.bodyfx.RightFootFX;
import de.dfki.stickmanFX.bodyfx.RightForeArmFX;
import de.dfki.stickmanFX.bodyfx.RightForeLegFX;
import de.dfki.stickmanFX.bodyfx.RightHandFX;
import de.dfki.stickmanFX.bodyfx.RightShoulderFX;
import de.dfki.stickmanFX.bodyfx.RightUpperArmFX;
import de.dfki.stickmanFX.bodyfx.RightUpperLegFX;
import de.dfki.stickmanFX.bodyfx.StarsFX;
import de.dfki.stickmanFX.bodyfx.ThinkFX;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleFX;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri <p> This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot by Ross Ching in
 * 2012
 */
public class StickmanFX extends Agent2D {

  //Used to change the backgroundRecord(pic) of the stickmanFX
  public final static ObservableList<String> backgroundList = FXCollections
      .observableArrayList("office",
          "grassland");
  // logging
  public final Logger mLogger = Logger.getAnonymousLogger();
  // Record mScale in DisappearToSmall and ComeBackFromSmall
  public float mScaleOriginal = mScale;
  // Added by Robbie, to control the speed of leaving
  public double hoffset = 0;
  public double voffset = 0;
  // Added by Robbie, star with character appear at the same time or not
  public boolean starShowC = false;
  // Added by Robbie, to control the character to fade out or fade in. true:
  // Fade out
  public IdleBehavior mIdleBehavior;
  // Perlin noise
  public SimplexNoise simplexNoise;
  public AnimationSchedulerFX mAnimationSchedulerFX;
  public HeadFX mHeadFX = null;
  public MaleHairFX mMaleHairFX = null;
  public FemaleHairFX mFemaleHairFX = null;
  public LeftEyebrowFX mLeftEyebrowFX = null;
  public FaceWrinkleFX mFaceWrinkleFX = null;
  public LeftEyeFX mLeftEyeFX = null;
  public RightEyebrowFX mRightEyebrowFX = null;
  public RightEyeFX mRightEyeFX = null;
  public MouthFX mMouthFX = null;
  public NeckFX mNeckFX = null;
  public BodyFX mBodyFX = null;
  public LeftShoulderFX mLeftShoulderFX = null;
  public LeftUpperArmFX mLeftUpperArmFX = null;
  public LeftForeArmFX mLeftForeArmFX = null;
  public LeftHandFX mLeftHandFX = null;
  public RightShoulderFX mRightShoulderFX = null;
  public RightUpperArmFX mRightUpperArmFX = null;
  public RightForeArmFX mRightForeArmFX = null;
  public RightHandFX mRightHandFX = null;
  public LeftUpperLegFX mLeftUpperLegFX = null;
  public LeftForeLegFX mLeftForeLegFX = null;
  public LeftFootFX mLeftFootFX = null;
  public StarsFX mStarsFX = null;
  public RightUpperLegFX mRightUpperLegFX = null;
  public RightForeLegFX mRightForeLegFX = null;
  public RightFootFX mRightFootFX = null;
  public ThinkFX mThinkFX = null;
  public BombeFX mBombeFX = null;
  public SpeechBubbleFX mSpeechBubbleFX;
  private boolean mShowName = true;
  private Label nameLabel;
  private NoseFX mNose;
  private StageRoom stageController;

  public StickmanFX(String name, Gender.TYPE gender, float scale, Dimension size) {
    this.mSize = size;
    this.mScale = scale;
    this.mScaleOriginal = scale;
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.update();
  }

  public StickmanFX(String name, Gender.TYPE gender, float scale) {
    this.mScale = scale;
    this.mScaleOriginal = scale;
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.update();
  }

  public StickmanFX(String name, Gender.TYPE gender) {
    this.name = name;
    this.mType = gender;

    this.init();
    this.addAllParts();
    this.update();
  }

  private void init() {
    this.name = "StickmanFX";
    this.nameLabel = new Label();
    this.mHeadFX = new HeadFX(this);
    this.mMaleHairFX = new MaleHairFX(this);
    this.mFemaleHairFX = new FemaleHairFX(this);
    this.mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
    this.mLeftEyeFX = new LeftEyeFX(mHeadFX);
    this.mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
    this.mRightEyeFX = new RightEyeFX(mHeadFX);
    this.mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
    this.mMouthFX = new MouthFX(mHeadFX);
    this.mNeckFX = new NeckFX(mHeadFX);
    this.mBodyFX = new BodyFX(mNeckFX);
    this.mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
    this.mLeftUpperArmFX = new LeftUpperArmFX(mLeftShoulderFX);
    this.mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
    this.mLeftHandFX = new LeftHandFX(mLeftForeArmFX);
    this.mRightShoulderFX = new RightShoulderFX(mBodyFX);
    this.mRightUpperArmFX = new RightUpperArmFX(mRightShoulderFX);
    this.mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
    this.mRightHandFX = new RightHandFX(mRightForeArmFX);
    this.mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
    this.mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
    this.mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
    this.mStarsFX = new StarsFX(mBodyFX);
    this.mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
    this.mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
    this.mRightFootFX = new RightFootFX(mRightForeLegFX);
    this.mThinkFX = new ThinkFX(mHeadFX);
    this.mBombeFX = new BombeFX(mHeadFX);
    this.mNose = new NoseFX(mHeadFX);
    this.mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
//    this.setPrefHeight(mSize.height);
//    this.setPrefWidth(mSize.width);
//    this.setMinHeight(mSize.height);
//    this.setMinWidth(mSize.width);
    // font stuff
    Map<TextAttribute, Object> map = new HashMap<>();
    map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
    map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
    map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
    map.put(TextAttribute.SIZE, 14);

    ConsoleHandler ch = new ConsoleHandler();
    ch.setFormatter(new logFormatter());

    this.mLogger.addHandler(ch);
    this.mLogger.setUseParentHandlers(false);

    this.mAnimationSchedulerFX = new AnimationSchedulerFX(this);
    this.mAnimationSchedulerFX.start();

    this.simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
    this.mIdleBehavior = new IdleBehavior(this, simplexNoise);

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
    return mShowName;
  }

  @Override
  public void setShowName(boolean show) {
    mShowName = show;
  }

  @Override
  public void endAnimationScheduler() {
    mAnimationSchedulerFX.end();
  }

  @Override
  public Gender.TYPE getType() {
    return mType;
  }

  @Override
  public AnimationStickmanFX doEventFeedbackAnimation(String name, int duration,
      WordTimeMarkSequence wts, boolean block) {
    EventAnimationFX a = AnimationLoaderFX.getInstance()
        .loadEventAnimation(this, name, duration, block);

    a.setParameter(wts);

    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
    return a;
  }

  @Override
  public AnimationStickmanFX doAnimation(String name, int duration, boolean block) {
    return doAnimation(name, duration, "", block);
  }

  @Override
  public AnimationInterface doAnimation(String name, int frequent, int actionDuration,
      boolean block) {
    return null;
  }

  @Override
  public AnimationStickmanFX doAnimation(String name, Object param, boolean block) {
    return doAnimation(name, -1, param, block);
  }

  public AnimationStickmanFX doAnimation(String name, boolean block) {
    return doAnimation(name, -1, "", block);
  }

  @Override
  public AnimationStickmanFX doAnimation(String name, int duration, Object param, boolean block) {
    AnimationStickmanFX a = AnimationLoaderFX.getInstance()
        .loadAnimation(this, name, duration, block);
    // this is for now only used by the Speech Bubble
    a.setParameter(param);

    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }

    return a;
  }

  public FXParts getSpeechBubble() {
    return this.mSpeechBubbleFX;
  }

  public void playAnimation(AnimationStickmanFX a) {
    try {
      animationLaunchControlSemaphor.acquire();
      a.start();
    } catch (InterruptedException ex) {
      mLogger.severe(ex.getMessage());
    }
  }

  public void update() {
    float mGeneralXTranslation;
    float mGeneralYTranslation;

    // draw everthing in the middle and scaled
    Affine af = new Affine();
    mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
    mGeneralYTranslation = (float) (mSize.height / 5);
    af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
    af.appendScale(mScale, mScale);
    // Added by Robbie, GoDown
    af.appendTranslation(hoffset, voffset);
    this.getTransforms().clear();
    this.getTransforms().add(af);

    // Out put perlin noise
    implimentPerlinNoise(mWobble,
        (mBodyFX.getRightLegStartPostion().x + mBodyFX.getLeftLegStartPostion().x) / 2,
        mBodyFX.getRightLegStartPostion().y + mLeftUpperLegFX.mLength + mLeftForeLegFX.mLength);

    if (mShowName) {
      nameLabel.setTranslateY(mRightForeLegFX.getLegStartPosition().getY() * 21 / 20);
      nameLabel.setText(name);
    } else {
      nameLabel.setTranslateY(mRightForeLegFX.getLegStartPosition().getY() * 21 / 20);
      nameLabel.setText("");
    }

    updateAll();
  }

  private void addAllParts() {
    this.getChildren()
        .addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, mMouthFX,
            mNeckFX,
            mBodyFX, mLeftShoulderFX, mLeftUpperArmFX, mLeftForeArmFX, mLeftHandFX,
            mRightShoulderFX,
            mRightUpperArmFX, mRightForeArmFX, mRightHandFX, /* mLeftLegFX, */ mLeftUpperLegFX,
            mLeftForeLegFX,
            mLeftFootFX, /* mRightLegFX, */ mRightUpperLegFX, mRightForeLegFX, mRightFootFX,
            mFaceWrinkleFX,
            mStarsFX, mSpeechBubbleFX, mThinkFX, mBombeFX, nameLabel);
    if (this.mType == Gender.TYPE.MALE) {
      this.getChildren().add(mMaleHairFX);
    } else {
      this.getChildren().add(mFemaleHairFX);
    }
  }

  private void updateAll() {
    // draw body parts
    if (starShowControler) {
      // Added by Robbie, to show stars or words here.
      mStarsFX.update();
    } else {
      if (starShowC) {
        mStarsFX.update();
      }
      mHeadFX.update();

      if (this.mType == Gender.TYPE.MALE) {
        mMaleHairFX.update();
      } else {
        mFemaleHairFX.update();
      }
      mLeftEyebrowFX.update();
      mLeftEyeFX.update();
      mRightEyebrowFX.update();
      mFaceWrinkleFX.update();
      mRightEyeFX.update();
      mMouthFX.update();
      mNeckFX.update();
      mBodyFX.calculate();
      mLeftShoulderFX.update();
      mLeftUpperArmFX.update();
      mLeftForeArmFX.update();
      mLeftHandFX.update();
      mRightShoulderFX.update();
      mRightUpperArmFX.update();
      mRightForeArmFX.update();
      mRightHandFX.update();
      mLeftUpperLegFX.update();
      mLeftForeLegFX.update();
      mLeftFootFX.update();
      mRightUpperLegFX.update();
      mRightForeLegFX.update();
      mRightFootFX.update();

      if (starShowC) // Added by Robbie, to show stars or words here.
      {
        mStarsFX.update();
      }
    }
  }

  private void implimentPerlinNoise(double mWobble, int x, int y) {
    if (starShowControler) {
      // Added by Robbie, to show stars or words here
      mStarsFX.rotatePerlinNoise(mWobble, x, y);
    } else {
      if (starShowC) {
        mStarsFX.rotatePerlinNoise(mWobble, x, y);
      }
      mHeadFX.rotatePerlinNoise(mWobble, x, y);

      if (this.mType == Gender.TYPE.MALE) {
        mMaleHairFX.rotatePerlinNoise(mWobble, x, y);
      } else {
        mFemaleHairFX.rotatePerlinNoise(mWobble, x, y);
      }
      mLeftEyebrowFX.rotatePerlinNoise(mWobble, x, y);
      mLeftEyeFX.rotatePerlinNoise(mWobble, x, y);
      mRightEyebrowFX.rotatePerlinNoise(mWobble, x, y);
      mFaceWrinkleFX.rotatePerlinNoise(mWobble, x, y);
      mRightEyeFX.rotatePerlinNoise(mWobble, x, y);
      mMouthFX.rotatePerlinNoise(mWobble, x, y);
      mNeckFX.rotatePerlinNoise(mWobble, x, y);
      mBodyFX.rotatePerlinNoise(mWobble, x, y);
      mLeftShoulderFX.rotatePerlinNoise(mWobble, x, y);
      mLeftUpperArmFX.rotatePerlinNoise(mWobble, x, y);
      mLeftForeArmFX.rotatePerlinNoise(mWobble, x, y);
      mLeftHandFX.rotatePerlinNoise(mWobble, x, y);
      mRightShoulderFX.rotatePerlinNoise(mWobble, x, y);
      mRightUpperArmFX.rotatePerlinNoise(mWobble, x, y);
      mRightForeArmFX.rotatePerlinNoise(mWobble, x, y);
      mRightHandFX.rotatePerlinNoise(mWobble, x, y);
      mLeftUpperLegFX.rotatePerlinNoise(mWobble, x, y);
      mLeftForeLegFX.rotatePerlinNoise(mWobble, x, y);
      mLeftFootFX.rotatePerlinNoise(mWobble, x, y);
      mRightUpperLegFX.rotatePerlinNoise(mWobble, x, y);
      mRightForeLegFX.rotatePerlinNoise(mWobble, x, y);
      mRightFootFX.rotatePerlinNoise(mWobble, x, y);

      if (starShowC) // Added by Robbie, to show stars or words here.
      {
        mStarsFX.rotatePerlinNoise(mWobble, x, y);
      }
    }
  }

  public void hideAllPartsWithout(Pane p) {
    this.getChildren().forEach(child ->
    {
      if (!child.equals(p)) {
        child.setVisible(false);
      }
    });
  }

  public void showAllParts() {
    this.getChildren().forEach(child -> child.setVisible(true));
  }
}
