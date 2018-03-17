/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
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
    animationContents.add(new AnimationContentReeti(getReeti().head, "rotate", 10));
    playAnimationPart(200);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().head, "rotate", -10));
    playAnimationPart(200);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
