/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.animationlogic.commonlogic.Animation;
import de.dfki.agent.Reeti;
import de.dfki.util.AnimationVisivility;
import java.util.HashMap;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationReeti extends Animation{

  private int actionDuration = -1;

  public AnimationReeti(){
    super();
  }

  public AnimationReeti(Reeti reeti, int duration, boolean block) {
    super(reeti, duration, block);
  }

  public AnimationReeti(Reeti reeti, int duration, int actionDuration, boolean block) {
    super(reeti, duration, block);
    this.actionDuration = actionDuration;
  }

  public void play() {
    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    animator = new AnimatorReeti((Reeti) agent, this, animationContents, duration);

  }

  @Override
  public void run() {
    play();
  }

  public AnimationVisivility getAnimationVisivility() {
    return animationVisivility;
  }

  public void setAnimationVisivility(AnimationVisivility animationVisivility) {
    this.animationVisivility = animationVisivility;
  }
}
