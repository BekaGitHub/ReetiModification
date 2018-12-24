/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.faceparts;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.movement.Move;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class NeckPan extends AnimationReeti {


  int rot;

  public NeckPan(Reeti sm, int duration, int pos, boolean block) {
    super(sm, duration, block);
    this.rot = pos;
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getHead(), Move.Z_ROTATION, rot));
    playAnimationPart(animationDuration);

  }
}
