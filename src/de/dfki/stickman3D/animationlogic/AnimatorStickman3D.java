package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator3D;
import de.dfki.stickman3D.Stickman3D;
import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorStickman3D extends Animator3D {

  public AnimatorStickman3D(Stickman3D sm, AnimationStickman3D a,
      ArrayList<AnimationContent> animComps) {
    agent = sm;
    mAnimation = a;
    mAnimationComponents = animComps;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();
    mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

    render();
  }

  public AnimatorStickman3D(Stickman3D sm, AnimationStickman3D a,
      ArrayList<AnimationContent> animComps, int duration) {
    agent = sm;
    mAnimation = a;
    mAnimationComponents = animComps;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();
    mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
    mRenderPauseDuration =
        (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
    render();
  }

  public AnimatorStickman3D(Stickman3D sm, AnimationStickman3D a,
      ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts) {
    agent = sm;
    mAnimation = a;
    mAnimationComponents = animComps;
    mWTS = wts;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();

    renderEventAnimation();
  }
}
