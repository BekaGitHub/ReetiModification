/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 * @author Beka
 */
public class DisappearToSmall extends AnimationStickmanFX {

  private StickmanFX mStickmanFX;

  public DisappearToSmall(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickmanFX = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
    mStickmanFX.mScaleOriginal = mStickmanFX.mScale;
    mStickmanFX.starShowControler = false;
    int rotationUnit = 5;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
    playAnimationPart(200);
    pauseAnimation(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 8));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 8));
    playAnimationPart(180);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 8));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 8));
    playAnimationPart(180);

    for (int i = 0; i < 1; i++) {
      // wave right
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

        mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
        playAnimationPart(20);
        Platform.runLater(() -> mStickmanFX.update());
      }

      // wave left
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

        mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
        playAnimationPart(20);
        Platform.runLater(() -> mStickmanFX.update());
      }
    }

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 32));
    playAnimationPart(20);

    // show stars
    mStickmanFX.starShowControler = true;
    mStickmanFX.hideAllPartsWithout(mStickmanFX.mStarsFX);
    mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSDISAPPEAR"));
    playAnimationPart(1000);
  }
}
