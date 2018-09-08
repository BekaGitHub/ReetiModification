/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Mouth_Default extends AnimationReeti {

  public Mouth_Default(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // smile
    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getMouth(), Movement.SHAPE, "DEFAULT"));
    playAnimationPart(animationDuration);
  }
}
