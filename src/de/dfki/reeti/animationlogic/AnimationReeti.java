/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.reeti.Reeti;
import java.util.HashMap;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationReeti extends Animation implements AnimationInterface {

  private AnimatorReeti animatorReeti;
  private AnimationPauseReeti animationPauseReeti;
  private Reeti reeti;
  private int actionDuration = -1;
  private HashMap<String, String> extraParams = new HashMap<>();
  private ANIMTYPE animtype;
  public AnimationReeti() {
  }

  public AnimationReeti(Reeti reeti, int duration, boolean block) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    setName(agentName + "'s AnimationSwing " + name);
    isBlocked = block;
    this.duration = duration;
  }

  public AnimationReeti(Reeti reeti, int duration, int pos, boolean block) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    setName(agentName + "'s AnimationSwing " + name);
    isBlocked = block;
    this.duration = duration;
    this.actionDuration = actionDuration;
  }

  public AnimationReeti(Reeti reeti, int frequent, int actionDuration, boolean block,
      HashMap<String, String> extraParams) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    setName(agentName + "'s AnimationSwing " + name);
    isBlocked = block;
    duration = frequent;
    this.actionDuration = actionDuration;
    this.extraParams = extraParams;
  }

  @Override
  public void setParameter(Object p) {
    parameter = p;
  }


  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void waitForClearance() {
    reeti.animationSchedulerReeti.introduce(this);
    // block this animation for animation - AnimationSheduler will unblock
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

    // tell Agent this animation has been scheduled and a next one can come
    reeti.animationLaunchControlSemaphor.release();
  }

  public void play() {
    // wait until AnimationScheduler says go!
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    animatorReeti = new AnimatorReeti(reeti, this, animationContents, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

  }

  public void pauseAnimation(int duration) {
    animationPauseReeti = new AnimationPauseReeti(reeti, this, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }
  }

  public void finalizeAnimation() {
    // unblock AnimationScheduler if animation is a blocking animation
    if (isBlocked) {
      reeti.animationSchedulerReeti.proceed(this);
    } else {
      reeti.animationSchedulerReeti.removeAnimation(this);
    }
  }

  @Override
  public void run() {
    waitForClearance();
    play();
    finalizeAnimation();
  }

  public Reeti getReeti() {
    return reeti;
  }

  public void setReeti(Reeti reeti) {
    this.reeti = reeti;
  }

  public ANIMTYPE getAnimtype() {
    return animtype;
  }

  public void setAnimtype(ANIMTYPE animtype) {
    this.animtype = animtype;
  }

  @Override
  public String toString() {
    return name + ", " + getName();
  }

  public enum ANIMTYPE {
    ON, OFF
  }
}
