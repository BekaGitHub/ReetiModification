/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class FadeIn extends AnimationSwing {

  private StickmanSwing mStickman;

  public FadeIn(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
//		star fade in
    mStickman.starShowControler = true;
    mStickman.starShowC = true;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickman.mStars, "shape", "STARSFADEIN"));
    playAnimationPart(1000);

//		character fade in
    mStickman.starShowControler = false;
    mStickman.setCharacterInvisible = true;
    mStickman.fadeControler = false;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mMouth, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mLeftHand, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mRightHand, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mRightLeg, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mLeftLeg, "shape", "DEFAULT"));
    animationContents.add(new AnimationContentSwing(mStickman.mNeck, "shape", "DEFAULT"));
    playAnimationPart(1000);
    mStickman.setCharacterInvisible = false;

//		stars fade out
    mStickman.starShowC = true;
    mStickman.setCharacterInvisible = false;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickman.mStars, "shape", "STARSFADEOUT"));
    playAnimationPart(500);

    // bring upper arm and fore arm in position
    int rotationUnit = 10;
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 16));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 16));
    playAnimationPart(200);
    pauseAnimation(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
    playAnimationPart(100);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 4));
    playAnimationPart(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
    playAnimationPart(100);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 4));
    playAnimationPart(100);
    pauseAnimation(200);

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 16));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 16));
    playAnimationPart(20);

    mStickman.setCharacterInvisible = false;
    mStickman.starShowControler = false;
    mStickman.starShowC = false;

  }
}
