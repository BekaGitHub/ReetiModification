package de.dfki.common.animationlogic;

import de.dfki.common.agents.Agent;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class Animator {

  public static int sMAX_ANIM_STEPS = 20;
  public static String sCurrentAction;
  public int mCurrentStep = sMAX_ANIM_STEPS;
  public String mDescription = "";
  public int mRenderPauseDuration = 0;
  public Semaphore mRenderingPause = new Semaphore(0);
  public Agent agent;

  public abstract void render();

  public class WaitThread extends Thread {

    int mSleepTime = 0;

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
      mRenderingPause.release();
    }
  }
}
