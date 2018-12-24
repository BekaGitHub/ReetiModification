/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.util.Move;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class TiltRightEnd extends AnimationReeti {

  public TiltRightEnd(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, 10));
    playAnimationPart(200);
  }
}
