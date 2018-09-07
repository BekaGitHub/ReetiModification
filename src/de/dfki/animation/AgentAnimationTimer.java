package de.dfki.animation;

import de.dfki.agent.Agent;
import javafx.animation.AnimationTimer;

public abstract class AgentAnimationTimer extends AnimationTimer{

  public static final double TOTAL_ANIMATION_STEPS = 2;
  protected int movement;
  protected int duration;
  private double delay;
  private long lastUpdate = 0;

  protected Agent agent;

  public AgentAnimationTimer(Agent agent, int movement, int duration) {
    this.agent = agent;
    this.movement = movement;
    this.duration = duration;
    delay = duration / TOTAL_ANIMATION_STEPS;
   }
  public abstract void doAnimation();

  @Override
  public void handle(long now) {
    long milli = nanoToMilli(now);
    if (milli - lastUpdate >= delay) {
      doAnimation();
      lastUpdate = milli;
    }
  }

  private long nanoToMilli(long nano) {
    return nano / 1000000;
  }

  private long milliToSecond(long milli) {
    return milli / 1000;
  }
}
