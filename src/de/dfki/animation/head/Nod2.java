/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContentReeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.controllers.ReetiController;
import de.dfki.util.AnimationVisivility;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationReeti {

  public Nod2() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Nod2(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    for (int i = 0; i < 6; i++) {
      if (i == 0) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentReeti(((Reeti) agent).getHead(), Movement.X_ROTATION, 10));
        playAnimationPart(200);
      } else if (i == 5) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentReeti(((Reeti) agent).getHead(), Movement.X_ROTATION, -10));
        playAnimationPart(200);
      } else if (i % 2 == 1) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentReeti(((Reeti) agent).getHead(), Movement.X_ROTATION, -20));
        playAnimationPart(200);
      } else {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContentReeti(((Reeti) agent).getHead(), Movement.X_ROTATION, 20));
        playAnimationPart(200);
      }
    }

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
