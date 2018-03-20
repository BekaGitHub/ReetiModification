package de.dfki.animationlogic;

import de.dfki.common.parts.PartsInterface;
import de.dfki.util.Movement;
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
          Movement movementAction = comp.movementAction;
          currentMovementAction = movementAction;
          int param = comp.mParam;
          String paramString = comp.mParamString;
          if (movementAction == Movement.X_ROTATION) {
            bodyPart.set_X_Rotation(param);
          }
          if (movementAction == Movement.Y_ROTATION) {
            bodyPart.set_Y_Rotation(param);
          }
          if (movementAction == Movement.Z_ROTATION) {
            bodyPart.set_Z_Rotation(param);
          }
          if (movementAction == Movement.TILT) {
            bodyPart.setTilt(param);
          }
          if (movementAction == Movement.X_TRANSLATION) {
            bodyPart.set_X_Translation(param);
          }
          if (movementAction == Movement.Y_TRANSLATION) {
            bodyPart.set_Y_Translation(param);
          }
          if (movementAction == Movement.Z_TRANSLATION) {
            bodyPart.set_Z_Translation(param);
          }
          if (movementAction == Movement.SHAPE) {
            bodyPart.setShape(paramString);
          }
        });
      }

      if (mCurrentStep > 1) {
        for (AnimationContent acr : mAnimationComponents) {
          PartsInterface bodypart = acr.mBodypart;
          Movement movementAction = acr.movementAction;

          if (movementAction == Movement.X_ROTATION) {
            bodypart.calculate_X_Rotation(mCurrentStep);
          }
          if (movementAction == Movement.Y_ROTATION) {
            bodypart.calculate_Y_Rotation(mCurrentStep);
          }
          if (movementAction == Movement.Z_ROTATION) {
            bodypart.calculate_Z_Rotation(mCurrentStep);
          }
          if (movementAction == Movement.TILT) {
            bodypart.calculate_X_Rotation(mCurrentStep);
          }

          if (movementAction == Movement.X_TRANSLATION) {
            bodypart.calculate_X_Translation(mCurrentStep);
          }
          if (movementAction == Movement.Y_TRANSLATION) {
            bodypart.calculate_Y_Translation(mCurrentStep);
          }
          if (movementAction == Movement.Z_TRANSLATION) {
            bodypart.calculate_Z_Translation(mCurrentStep);
          }
          if (movementAction == Movement.SHAPE) {
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
          Movement movementAction = acr.movementAction;
          PartsInterface bodypart = acr.mBodypart;

          if (movementAction == Movement.X_ROTATION) {
            bodypart.reset_X_Rotation();
          }
          if (movementAction == Movement.Y_ROTATION) {
            bodypart.reset_Y_Rotation();
          }
          if (movementAction == Movement.Z_ROTATION) {
            bodypart.reset_Z_Rotation();
          }
          if (movementAction == Movement.Z_ROTATION) {
            bodypart.resetRotation();
          }

          if (movementAction == Movement.X_TRANSLATION) {
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
