package de.dfki.animationlogic.reeti;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.commonlogic.Animator;
import de.dfki.body.BodyPart;
import de.dfki.util.Move;
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
          Move moveAction = comp.moveAction;
          currentMoveAction = moveAction;
          int param = comp.position;
          String paramString = comp.bodyPartMovementAction;
          if (moveAction == Move.X_ROTATION) {
//            bodyPart.set_X_Rotation(param);
          }
          if (moveAction == Move.Y_ROTATION) {
//            bodyPart.set_Y_Rotation(param);
          }
          if (moveAction == Move.Z_ROTATION) {
//            bodyPart.set_Z_Rotation(param);
          }
          if (moveAction == Move.TILT) {
//            bodyPart.setTilt(param);
          }
          if (moveAction == Move.X_TRANSLATION) {
//            bodyPart.set_X_Translation(param);
          }
          if (moveAction == Move.Y_TRANSLATION) {
//            bodyPart.set_Y_Translation(param);
          }
          if (moveAction == Move.Z_TRANSLATION) {
//            bodyPart.set_Z_Translation(param);
          }
          if (moveAction == Move.SHAPE) {
//            bodyPart.setShape(paramString);
          }
        });
      }

      if (currentStep > 1) {
        for (AnimationContent acr : animationContents) {
          BodyPart bodypart = acr.mBodypart;
          Move moveAction = acr.moveAction;

          if (moveAction == Move.X_ROTATION) {
//            bodypart.calculate_X_Rotation(currentStep);
          }
          if (moveAction == Move.Y_ROTATION) {
//            bodypart.calculate_Y_Rotation(currentStep);
          }
          if (moveAction == Move.Z_ROTATION) {
//            bodypart.calculate_Z_Rotation(currentStep);
          }
          if (moveAction == Move.TILT) {
//            bodypart.calculate_X_Rotation(currentStep);
          }

          if (moveAction == Move.X_TRANSLATION) {
//            bodypart.calculate_X_Translation(currentStep);
          }
          if (moveAction == Move.Y_TRANSLATION) {
//            bodypart.calculate_Y_Translation(currentStep);
          }
          if (moveAction == Move.Z_TRANSLATION) {
//            bodypart.calculate_Z_Translation(currentStep);
          }
          if (moveAction == Move.SHAPE) {
//            bodypart.calculateShape(currentStep);
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
          Move moveAction = acr.moveAction;
          BodyPart bodypart = acr.mBodypart;

          if (moveAction == Move.X_ROTATION) {
//            bodypart.reset_X_Rotation();
          }
          if (moveAction == Move.Y_ROTATION) {
//            bodypart.reset_Y_Rotation();
          }
          if (moveAction == Move.Z_ROTATION) {
//            bodypart.reset_Z_Rotation();
          }
          if (moveAction == Move.Z_ROTATION) {
//            bodypart.resetRotation();
          }

          if (moveAction == Move.X_TRANSLATION) {
//            bodypart.resetTranslation();
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
