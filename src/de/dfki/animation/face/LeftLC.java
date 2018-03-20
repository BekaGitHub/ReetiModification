/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.face;

import de.dfki.agent.Reeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class LeftLC extends AnimationReeti {


  public LeftLC(Reeti sm, int duration, int pos, boolean block) {
    super(sm, duration, pos, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContentReeti(getReeti().getMouthLeftCorner(), "shape", "LEFTCORNERACTION"));
    playAnimationPart(animationDuration);


  }
}
