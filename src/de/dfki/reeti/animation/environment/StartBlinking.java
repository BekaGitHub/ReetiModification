package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationReeti;

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
    setAnimtype(ANIMTYPE.ON);
  }

  public StartBlinking(Reeti reeti, int frequent, int actionDuration, boolean block) {
    super(reeti, frequent, actionDuration, block);
    setReeti(reeti);
    this.frequent = frequent;
    this.actionDuration = actionDuration;
  }

  public StartBlinking(Reeti reeti, int frequent, boolean block) {
    super(reeti, frequent, block);
    setReeti(reeti);
    this.frequent = 5000;
    this.actionDuration = 50;
  }

  @Override
  public void playAnimation() {
    getReeti().mBlinking = new Blinking(getReeti(), frequent, actionDuration);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
