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
import de.dfki.util.Move;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class LeftEye_X extends AnimationReeti {


  int rot;

  public LeftEye_X(Reeti sm, int duration, int pos, boolean block) {
    super(sm, duration, pos, block);
    this.rot = pos;
  }

  @Override
  public void playAnimation() {

    animationContents = new ArrayList<>();
    animationContents
        .add(new AnimationContent(((Reeti) agent).getLeftEye(), Move.X_ROTATION, rot));
    playAnimationPart(animationDuration);

  }
}
