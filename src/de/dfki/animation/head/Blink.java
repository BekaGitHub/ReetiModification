/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Blink extends AnimationReeti {

  public Blink() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Blink(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEyelid(), Movement.X_ROTATION, 100));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEyelid(), Movement.X_ROTATION, 100));
    playAnimationPart(500);

    pauseAnimation(300);

    //blink up
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getLeftEyelid(), Movement.X_ROTATION, -100));
    animationContents.add(new AnimationContentReeti(getReeti().getRightEyelid(), Movement.X_ROTATION, -100));
    playAnimationPart(500);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
