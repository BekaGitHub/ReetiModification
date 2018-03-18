package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
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
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEye(), "rotate", 20));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEye(), "rotate", 20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWN"));
    playAnimationPart(100);

    pauseAnimation(100);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEye(), "rotate", -20));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEye(), "rotate", -20));
//        animationContents.add(new AnimationContentReeti(reeti.mRightEyeFX, "shape", "LOOKDOWNEND"));
    playAnimationPart(100);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
