package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookDown extends AnimationReeti {

  public LookDown() {
    setAnimtype(ANIMTYPE.ON);
  }

  public LookDown(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEye(), Movement.X_ROTATION, 20));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEye(), Movement.X_ROTATION, 20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWN"));
    playAnimationPart(100);

    pauseAnimation(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEye(), Movement.X_ROTATION, -20));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEye(), Movement.X_ROTATION, -20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWNEND"));
    playAnimationPart(100);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
