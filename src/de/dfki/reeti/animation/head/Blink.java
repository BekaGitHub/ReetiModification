/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
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
    animationContents.add(new AnimationContentReeti(getReeti().leftEyelid, "rotate", 100));
    animationContents.add(new AnimationContentReeti(getReeti().rightEyelid, "rotate", 100));
    playAnimationPart(500);

    pauseAnimation(300);

    //blink up
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().leftEyelid, "rotate", -100));
    animationContents.add(new AnimationContentReeti(getReeti().rightEyelid, "rotate", -100));
    playAnimationPart(500);

    if (ReetiStageController.currentRadioButton != null) {
      ReetiStageController.currentRadioButton.setSelected(false);
    }
  }
}
