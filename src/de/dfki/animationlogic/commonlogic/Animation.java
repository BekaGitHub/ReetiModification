package de.dfki.animationlogic.commonlogic;

import de.dfki.agent.Agent;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.animation.AnimationVisivility;
import java.util.ArrayList;

/**
 * Created by EmpaT on 16.07.2017.
 */
public abstract class Animation extends Thread {

  protected ArrayList<AnimationContent> animationContents;
  protected Agent agent;
  protected Animator animator;
  protected AnimationVisivility animationVisivility;
  protected boolean isBlocked;
  protected int animationDuration;

  public Animation() {
    init();
  }

  public Animation(Agent agent, int duration, boolean block) {
    this();
    this.agent = agent;
    isBlocked = block;
    this.animationDuration = duration;
  }

  private void init() {
    animationContents = new ArrayList<>();
    animationDuration = -1;
  }

  public AnimationVisivility getAnimationVisivility() {
    return animationVisivility;
  }

  public void setAnimationVisivility(AnimationVisivility animationVisivility) {
    this.animationVisivility = animationVisivility;
  }

}
