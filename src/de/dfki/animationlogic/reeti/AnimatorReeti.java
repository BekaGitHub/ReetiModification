package de.dfki.animationlogic.reeti;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.animationlogic.commonlogic.Animator;
import de.dfki.common.parts.BodyPart;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorReeti extends Animator {

  public AnimatorReeti(Reeti reeti, ArrayList<AnimationContent> animationContents,
      int duration) {
    super(reeti, animationContents, duration);
  }

  public void renderAnimation() {
    currentStep = MAX_ANIM_STEPS;
    while (currentStep > 0) {
      if (currentStep == MAX_ANIM_STEPS) {
        animationContents.stream().forEach((comp) ->
        {
          BodyPart bodyPart = comp.mBodypart;
          Movement movementAction = comp.movementAction;
          currentMovementAction = movementAction;
          int param = comp.position;
          String paramString = comp.bodyPartMovementAction;
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

      if (currentStep > 1) {
        for (AnimationContent acr : animationContents) {
          BodyPart bodypart = acr.mBodypart;
          Movement movementAction = acr.movementAction;

          if (movementAction == Movement.X_ROTATION) {
            bodypart.calculate_X_Rotation(currentStep);
          }
          if (movementAction == Movement.Y_ROTATION) {
            bodypart.calculate_Y_Rotation(currentStep);
          }
          if (movementAction == Movement.Z_ROTATION) {
            bodypart.calculate_Z_Rotation(currentStep);
          }
          if (movementAction == Movement.TILT) {
            bodypart.calculate_X_Rotation(currentStep);
          }

          if (movementAction == Movement.X_TRANSLATION) {
            bodypart.calculate_X_Translation(currentStep);
          }
          if (movementAction == Movement.Y_TRANSLATION) {
            bodypart.calculate_Y_Translation(currentStep);
          }
          if (movementAction == Movement.Z_TRANSLATION) {
            bodypart.calculate_Z_Translation(currentStep);
          }
          if (movementAction == Movement.SHAPE) {
            bodypart.calculateShape(currentStep);
          }
        }

        new WaitThread(renderPauseDuration).start();
        // block this until WaitThread will unblock
        try {
          renderingPauseSemaphor.acquire(1);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }

      if (currentStep == 1) {
        for (AnimationContent acr : animationContents) {
          Movement movementAction = acr.movementAction;
          BodyPart bodypart = acr.mBodypart;

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

        new WaitThread(renderPauseDuration).start();
        // block this until WaitThread will unblock
        try {
          renderingPauseSemaphor.acquire(1);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
        return;
      }

      currentStep -= 1;
    }
  }
}
