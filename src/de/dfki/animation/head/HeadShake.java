/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.controllers.ReetiController;
import de.dfki.animation.AnimationVisivility;
import de.dfki.movement.Move;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class HeadShake extends AnimationReeti {

  public HeadShake() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public HeadShake(Reeti reeti, int duration, boolean block) {
    super(reeti, duration, block);
  }

  @Override
  public void playAnimation() {

    // shaking head 4 times
    for (int i = 0; i < 6; i++) {
      if (i == 0) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, -10));
        playAnimationPart(200);
      } else if (i == 5) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, 10));
        playAnimationPart(200);
      } else if (i % 2 == 1) {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, 20));
        playAnimationPart(400);
      } else {
        animationContents = new ArrayList<>();
        animationContents
            .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, -20));
        playAnimationPart(400);
      }
    }

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }

  }

}
