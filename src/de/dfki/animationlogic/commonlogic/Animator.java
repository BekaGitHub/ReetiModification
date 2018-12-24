package de.dfki.animationlogic.commonlogic;

import de.dfki.agent.Agent;
import de.dfki.animationlogic.reeti.AnimationContent;
import de.dfki.util.Move;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class Animator {

  public static final int MAX_ANIM_STEPS = 20;
  protected static Move currentMoveAction;
  protected int currentStep = MAX_ANIM_STEPS;
  protected int renderPauseDuration = 0;
  protected Agent agent;
  protected Semaphore renderingPauseSemaphor = new Semaphore(0);
  protected ArrayList<AnimationContent> animationContents = new ArrayList<>();

  public Animator(Agent agent, ArrayList<AnimationContent> animationContents,
      int duration) {
    this.agent = agent;
    this.animationContents = animationContents;
    renderPauseDuration = new Float(duration / MAX_ANIM_STEPS).intValue();
    if (renderPauseDuration < 1) {
      renderPauseDuration = 1; // minimum delay is 1 millisecond
    }
  }

  public abstract void renderAnimation();

  public class WaitThread extends Thread {

    int mSleepTime;

    public WaitThread(int time) {
      mSleepTime = time;
    }

    @Override
    public void run() {
      // directly go to sleep
      try {
        sleep(mSleepTime, 0);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      // release sempahore
      renderingPauseSemaphor.release();
    }
  }
}
