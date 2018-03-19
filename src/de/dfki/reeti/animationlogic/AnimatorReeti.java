package de.dfki.reeti.animationlogic;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator3D;
import de.dfki.reeti.Reeti;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorReeti extends Animator3D {

  public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContent> animComps) {
    agent = reeti;
    mAnimation = a;
    mAnimationComponents = animComps;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();
    mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

    render();
  }

  public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContent> animComps,
      int duration) {
    agent = reeti;
    mAnimation = a;
    mAnimationComponents = animComps;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();

    mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
    mRenderPauseDuration =
        (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
    render();
  }
}
