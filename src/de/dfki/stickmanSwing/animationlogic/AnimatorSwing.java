package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator2D;
import de.dfki.stickmanSwing.StickmanSwing;
import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class AnimatorSwing extends Animator2D {

  public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContent> animComps) {
    agent = sm;
    mAnimation = a;
    mAnimationComponents = animComps;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();
    mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

    render();
  }

  public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContent> animComps,
      int duration) {
    //mPreparationTime = System.currentTimeMillis();
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

  public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContent> animComps,
      WordTimeMarkSequence wts) {
    //mPreparationTime = System.currentTimeMillis();
    agent = sm;
    mAnimation = a;
    mAnimationComponents = animComps;
    mWTS = wts;
    mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.ID + "), " + mAnimation
        .toString();

    renderEventAnimation();
  }
}
