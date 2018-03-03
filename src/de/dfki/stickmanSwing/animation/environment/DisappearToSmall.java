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
public class DisappearToSmall extends AnimationSwing {

  private StickmanSwing mStickman;

  public DisappearToSmall(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
    mStickman = sm;
  }

  // WaveLeft
  @Override
  public void playAnimation() {
    mStickman.starShowControler = false;
    int rotationUnit = 5;

    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", rotationUnit * 2));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 32));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 32));
    playAnimationPart(200);
    pauseAnimation(100);

    // wave right
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 8));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 8));
    playAnimationPart(180);

    // wave left
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 8));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 8));
    playAnimationPart(180);

    for (int i = 0; i < 1; i++) {
      // wave right
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit));
        animationContents
            .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit));

        mStickman.mScale = mStickman.mScale * 0.95f;
        playAnimationPart(20);
      }

      // wave left
      for (int j = 0; j < 9; j++) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit));
        animationContents
            .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit));

        mStickman.mScale = mStickman.mScale * 0.95f;
        playAnimationPart(20);
      }
    }

    // go back in the default position
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", -rotationUnit * 2));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 32));
    animationContents
        .add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 32));
    playAnimationPart(20);

//		Show words syebye
//		mStickmanSwing.wordShowControler = true;
//		for(int i=0; i<15;i++)
//		{
//			mStickmanSwing.mScale = mStickmanSwing.mScale*1.05f;
//			if(mStickmanSwing.mScale >= 1.3)
//				mStickmanSwing.mScale = 1.334445f;
//			animationContents = new ArrayList<>();
//			animationContents.add(new AnimationContentSwing(mStickmanSwing.mWordShow, "shape", "SAYBYE"));
//			playAnimationPart(2);	
//		}
//		pauseAnimation(200);
//		
////		disappeared words
//		animationContents = new ArrayList<>();
//		animationContents.add(new AnimationContentSwing(mStickmanSwing.mWordShow, "shape", "DEFAULT"));
//		playAnimationPart(2);	
//		show stars
    mStickman.starShowControler = true;
    mStickman.mScale = 1.334445f;
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentSwing(mStickman.mStars, "shape", "STARSDISAPPEAR"));
    playAnimationPart(1000);
  }
}
