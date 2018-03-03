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
public class GoDown extends AnimationStickman3D {

  double recordOriginLeaveSpeed;

  public GoDown() {
    mAnimType = ANIMTYPE.ON;
  }

  public GoDown(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman3D = sm;
    recordOriginLeaveSpeed = mStickman3D.leaveSpeed;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
    int rotationUnit = 5;
    int speed = 5;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -rotationUnit));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -rotationUnit * 30));
    playAnimationPart(200);

    for (int i = 0; i < 8; i++) {
      // wave right
      for (int j = 0; j < 8; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -rotationUnit));

        mStickman3D.leaveSpeed = mStickman3D.leaveSpeed + speed;
        Platform.runLater(() -> mStickman3D.update());
        playAnimationPart(20);
      }

      // wave left
      for (int j = 0; j < 8; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", rotationUnit));

        mStickman3D.leaveSpeed = mStickman3D.leaveSpeed + speed;
        Platform.runLater(() -> mStickman3D.update());
        playAnimationPart(20);
      }
    }

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", rotationUnit));
    animationContents
        .add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", rotationUnit * 30));
    playAnimationPart(20);
    mStickman3D.leaveSpeed = recordOriginLeaveSpeed;

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }

}
