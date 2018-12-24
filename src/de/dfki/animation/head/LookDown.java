package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.controllers.ReetiController;
import de.dfki.animation.AnimationVisivility;
import de.dfki.movement.Move;
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
        .add(new AnimationContent(((Reeti) agent).getLeftEye(), Move.X_ROTATION, 20));
    animationContents
        .add(new AnimationContent(((Reeti) agent).getRightEye(), Move.X_ROTATION, 20));
//        animationContents.add(new AnimationContent(reeti.mRightEyeFX, "shape", "LOOKDOWN"));
    playAnimationPart(100);

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getLeftEye(), Move.X_ROTATION, -20));
    animationContents
        .add(new AnimationContent(((Reeti) agent).getRightEye(), Move.X_ROTATION, -20));
//        animationContents.add(new AnimationContent(reeti.mRightEyeFX, "shape", "LOOKDOWNEND"));
    playAnimationPart(100);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
