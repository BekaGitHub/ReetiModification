package de.dfki.animationlogic.reeti;

import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.animationlogic.commonlogic.Animator3D;
import de.dfki.agent.Reeti;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorReeti extends Animator3D {

  public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContent> animComps,
      int duration) {
    agent = reeti;
    mAnimation = a;
    mAnimationComponents = animComps;
    mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
    mRenderPauseDuration =
        (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
    render();
  }
}
