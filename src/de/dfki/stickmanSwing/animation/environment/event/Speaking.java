/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.environment.event;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.EventAnimationSwing;
import de.dfki.stickmanSwing.environment.SpeechBubble;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Speaking extends EventAnimationSwing {

  public Speaking() {
    super();
  }

  public Speaking(StickmanSwing sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    if (parameter instanceof WordTimeMarkSequence) {
      mWTS = (WordTimeMarkSequence) parameter;
    }

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mSpeechBubble, "shape",
            SpeechBubble.SHAPE.SPEAK.name(), mWTS));

    playEventAnimationPart();

    animationContents
        .add(new AnimationContentSwing(mStickmanSwing.mSpeechBubble, "shape",
            SpeechBubble.SHAPE.DEFAULT.name()));
    playAnimationPart(20);

  }
}
