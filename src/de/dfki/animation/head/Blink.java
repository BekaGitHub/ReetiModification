/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.animationlogic.reeti.AnimationContentReeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.AnimationVisivility;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Blink extends AnimationReeti {

  public Blink() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public Blink(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(((Reeti)agent).getLeftEyelid(), Movement.X_ROTATION, 100));
    animationContents.add(new AnimationContentReeti(((Reeti)agent).getRightEyelid(), Movement.X_ROTATION, 100));
    playAnimationPart(500);

    //blink up
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(((Reeti)agent).getLeftEyelid(), Movement.X_ROTATION, -100));
    animationContents.add(new AnimationContentReeti(((Reeti)agent).getRightEyelid(), Movement.X_ROTATION, -100));
    playAnimationPart(500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
