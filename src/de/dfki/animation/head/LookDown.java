package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContentReeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.reeti.ReetiController;
import de.dfki.util.AnimationVisivility;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookDown extends AnimationReeti {

  public LookDown() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public LookDown(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentReeti(((Reeti) agent).getLeftEye(), Movement.X_ROTATION, 20));
    animationContents
        .add(new AnimationContentReeti(((Reeti) agent).getRightEye(), Movement.X_ROTATION, 20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWN"));
    playAnimationPart(100);

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentReeti(((Reeti) agent).getLeftEye(), Movement.X_ROTATION, -20));
    animationContents
        .add(new AnimationContentReeti(((Reeti) agent).getRightEye(), Movement.X_ROTATION, -20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWNEND"));
    playAnimationPart(100);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
