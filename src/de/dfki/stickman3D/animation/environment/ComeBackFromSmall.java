/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 * @author Beka
 */
public class ComeBackFromSmall extends AnimationStickman3D {

  public ComeBackFromSmall() {
    mAnimType = ANIMTYPE.ON;
  }

  public ComeBackFromSmall(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman3D = sm;
  }

  @Override
  public void playAnimation() {

    int rotationUnit = 5;

    float recordOriginScale = mStickman3D.mScale;

    for (int j = 0; j < 19; j++) {
      mStickman3D.mScale = mStickman3D.mScale * 0.95f;
    }

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -rotationUnit * 30));
    playAnimationPart(20);

    pauseAnimation(20);

    for (int i = 0; i < 2; i++) {
      // wave right
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -rotationUnit));

        mStickman3D.mScale = mStickman3D.mScale * 1.05f;
        if (mStickman3D.mScale >= recordOriginScale) {
          mStickman3D.mScale = recordOriginScale;
        }
        playAnimationPart(20);
        Platform.runLater(() -> mStickman3D.update());
        mStickman3D.showAllParts();
      }

      // wave left
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", rotationUnit));

        mStickman3D.mScale = mStickman3D.mScale * 1.05f;
        if (mStickman3D.mScale >= recordOriginScale) {
          mStickman3D.mScale = recordOriginScale;
        }
        playAnimationPart(20);
        Platform.runLater(() -> mStickman3D.update());
        mStickman3D.showAllParts();
      }
    }

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", rotationUnit * 30));
    playAnimationPart(20);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }

  }
}
