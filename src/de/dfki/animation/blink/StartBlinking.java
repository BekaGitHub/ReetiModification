package de.dfki.animation.blink;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.AnimationVisivility;

/**
 * @author Beka
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartBlinking extends AnimationReeti {

  int frequent;
  int actionDuration;
  public StartBlinking() {
    setAnimationVisivility(AnimationVisivility.YES);
  }

  public StartBlinking(Reeti reeti, int frequent, int actionDuration, boolean block) {
    super(reeti, frequent, actionDuration, block);
    this.frequent = frequent;
    this.actionDuration = actionDuration;
  }

  public StartBlinking(Reeti reeti, int frequent, boolean block) {
    super(reeti, frequent, block);
    this.frequent = 5000;
    this.actionDuration = 50;
  }

  @Override
  public void playAnimation() {
    ((Reeti)agent).blinking = new Blinking(((Reeti)agent), frequent, actionDuration);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
