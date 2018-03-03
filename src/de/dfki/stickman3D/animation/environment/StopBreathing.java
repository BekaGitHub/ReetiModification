package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Robbie
 */
public class StopBreathing extends AnimationStickman3D {

  public StopBreathing() {
    mAnimType = ANIMTYPE.ON;
  }

  public StopBreathing(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (mStickman3D.mBreathing != null) {
      mStickman3D.mBreathing.stopBreathAktion();
    }

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }
  }
}
