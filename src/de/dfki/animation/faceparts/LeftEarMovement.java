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
import de.dfki.util.Movement;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class LeftEarMovement extends AnimationReeti {


  int rot;

  public LeftEarMovement(Reeti sm, int duration, int pos, boolean block) {
    super(sm, duration, pos, block);
    this.rot = pos;
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getLeftEar(), Movement.Z_ROTATION, rot));
    playAnimationPart(animationDuration);

  }
}
