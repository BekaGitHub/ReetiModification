package de.dfki.common.animationlogic;

import de.dfki.common.parts.PartsInterface;
import java.util.ArrayList;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class Animator2D extends Animator {

  public ArrayList<AnimationContent> mAnimationComponents = new ArrayList<>();
  public Animation mAnimation;

  public void render() {
    mCurrentStep = sMAX_ANIM_STEPS;
    while (mCurrentStep > 0) {
      if (mCurrentStep == sMAX_ANIM_STEPS) {
        // renderEventAnimatione animation components
        mAnimationComponents.stream().forEach((comp)
            ->
        {
          PartsInterface bodypartFX = comp.mBodypart;
          String action = comp.mAction;
          int param = comp.mParam;
          String paramString = comp.mParamString;
          if (action.equalsIgnoreCase("rotate")) {
            bodypartFX.setRotation(param);
          }
          if (action.equalsIgnoreCase("tilt")) {
            bodypartFX.setTilt(param);
          }
          if (action.equalsIgnoreCase("translate")) {
            bodypartFX.setTranslation(param);
          }
          if (action.equalsIgnoreCase("shape")) {
            bodypartFX.setShape(paramString);
          }
        });
      }

      if (mCurrentStep > 1) {
        for (AnimationContent ba : mAnimationComponents) {
          PartsInterface bodypartFX = ba.mBodypart;
          String action = ba.mAction;

          if (action.equalsIgnoreCase("rotate")) {
            bodypartFX.calculateRotation(mCurrentStep);
          }

          if (action.equalsIgnoreCase("tilt")) {
            bodypartFX.calculateRotation(mCurrentStep);
          }

          if (action.equalsIgnoreCase("translate")) {
            bodypartFX.calculateTranslation(mCurrentStep);
          }

          if (action.equalsIgnoreCase("shape")) {
            bodypartFX.calculateShape(mCurrentStep);
          }
        }

        new WaitThread(mRenderPauseDuration).start();
        // block this until WaitThread will unblock
        try {
          mRenderingPause.acquire(1);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }

      if (mCurrentStep == 1) {
        for (AnimationContent ba : mAnimationComponents) {
          String action = ba.mAction;
          PartsInterface bodypartFX = ba.mBodypart;

          if (action.equalsIgnoreCase("rotate")) {
            bodypartFX.resetRotation();
          }

          if (action.equalsIgnoreCase("tilt")) {
            bodypartFX.resetRotation();
          }

          if (action.equalsIgnoreCase("translate")) {
            bodypartFX.resetTranslation();
          }
        }

        new WaitThread(mRenderPauseDuration).start();
        // block this until WaitThread will unblock
        try {
          mRenderingPause.acquire(1);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
        mAnimation.animationPartStartSemaphore.release();
        return;
      }

      mCurrentStep -= 1;
    }
  }
}
