package de.dfki.animationlogic;

import de.dfki.common.parts.PartsInterface;
import java.util.ArrayList;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class Animator3D extends Animator {

  public ArrayList<AnimationContent> mAnimationComponents = new ArrayList<>();
  public Animation mAnimation;

  public void render() {
    mCurrentStep = sMAX_ANIM_STEPS;
    while (mCurrentStep > 0) {
      if (mCurrentStep == sMAX_ANIM_STEPS) {
        // renderEventAnimatione animation components
        mAnimationComponents.stream().forEach((comp) ->
        {
          PartsInterface bodyPart = comp.mBodypart;
          String action = comp.mAction;
          sCurrentAction = action;
          int param = comp.mParam;
          String paramString = comp.mParamString;
          if (action.equalsIgnoreCase("rotate")) {
            bodyPart.set_X_Rotation(param);
          }
          if (action.equalsIgnoreCase("yRotate")) {
            bodyPart.set_Y_Rotation(param);
          }
          if (action.equalsIgnoreCase("zRotate")) {
            bodyPart.set_Z_Rotation(param);
          }
          if (action.equalsIgnoreCase("tilt")) {
            bodyPart.setTilt(param);
          }
          if (action.equalsIgnoreCase("translate")) {
            bodyPart.set_X_Translation(param);
          }
          if (action.equalsIgnoreCase("ytranslate")) {
            bodyPart.set_Y_Translation(param);
          }
          if (action.equalsIgnoreCase("ztranslate")) {
            bodyPart.set_Z_Translation(param);
          }
          if (action.equalsIgnoreCase("shape")) {
            bodyPart.setShape(paramString);
          }
        });
      }

      if (mCurrentStep > 1) {
        for (AnimationContent acr : mAnimationComponents) {
          PartsInterface bodypart = acr.mBodypart;
          String action = acr.mAction;

          if (action.equalsIgnoreCase("rotate")) {
            bodypart.calculate_X_Rotation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("yrotate")) {
            bodypart.calculate_Y_Rotation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("zrotate")) {
            bodypart.calculate_Z_Rotation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("tilt")) {
            bodypart.calculate_X_Rotation(mCurrentStep);
          }

          if (action.equalsIgnoreCase("translate")) {
            bodypart.calculate_X_Translation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("ytranslate")) {
            bodypart.calculate_Y_Translation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("ztranslate")) {
            bodypart.calculate_Z_Translation(mCurrentStep);
          }
          if (action.equalsIgnoreCase("shape")) {
            bodypart.calculateShape(mCurrentStep);
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
        for (AnimationContent acr : mAnimationComponents) {
          String action = acr.mAction;
          PartsInterface bodypart = acr.mBodypart;

          if (action.equalsIgnoreCase("rotate")) {
            bodypart.reset_X_Rotation();
          }
          if (action.equalsIgnoreCase("yrotate")) {
            bodypart.reset_Y_Rotation();
          }
          if (action.equalsIgnoreCase("zrotate")) {
            bodypart.reset_Z_Rotation();
          }
          if (action.equalsIgnoreCase("tilt")) {
            bodypart.resetRotation();
          }

          if (action.equalsIgnoreCase("translate")) {
            bodypart.resetTranslation();
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
