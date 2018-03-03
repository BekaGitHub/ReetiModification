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
public class GoDown extends AnimationStickmanFX {

  private StickmanFX mStickmanFX;

  public GoDown(StickmanFX sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickmanFX = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
    int rotationUnit = 5;
    int speed = 7;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
    animationContents
        .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
    playAnimationPart(200);

    for (int i = 0; i < 8; i++) {
      // wave right
      for (int j = 0; j < 8; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

        mStickmanFX.voffset = mStickmanFX.voffset + speed;
        Platform.runLater(() -> mStickmanFX.update());
        playAnimationPart(20);
      }

      // wave left
      for (int j = 0; j < 8; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
        animationContents
            .add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

        mStickmanFX.voffset = mStickmanFX.voffset + speed;
        Platform.runLater(() -> mStickmanFX.update());
        playAnimationPart(20);
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
  }

}
