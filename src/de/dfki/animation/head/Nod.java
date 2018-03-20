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
 * @author Beka
 */
public class Nod extends AnimationReeti {

  public Nod() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Nod(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getHead(), Movement.X_ROTATION, 10));
    playAnimationPart(200);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getHead(), Movement.X_ROTATION, -10));
    playAnimationPart(200);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
