package de.dfki.animation.faceparts;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

import de.dfki.agent.Reeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Mouth_FIVE extends AnimationReeti {

  public Mouth_FIVE(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  public void playAnimation() {
    // smile
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContentReeti(getReeti().getMouth(), Movement.SHAPE, "FIVE"));
    playAnimationPart(20);
  }
}
