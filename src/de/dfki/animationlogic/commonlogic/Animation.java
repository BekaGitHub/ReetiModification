package de.dfki.animationlogic.commonlogic;

import de.dfki.agent.Agent;
import de.dfki.agent.Reeti;
import de.dfki.util.AnimationVisivility;
import java.util.ArrayList;

/**
 * Created by EmpaT on 16.07.2017.
 */
public abstract class Animation extends Thread {
  protected ArrayList<AnimationContent> animationContents;
  protected Agent agent;
  protected Animator animator;
  protected AnimationVisivility animationVisivility;
  public boolean isBlocked;
  public int animationDuration;

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

}
