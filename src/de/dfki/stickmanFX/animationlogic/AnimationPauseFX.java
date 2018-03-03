package de.dfki.stickmanFX.animationlogic;

import de.dfki.stickmanFX.StickmanFX;
import java.util.concurrent.Semaphore;

/**
 * @author Beka Aptsiauri
 */
public class AnimationPauseFX {

  private final StickmanFX mStickmanFX;
  private final AnimationStickmanFX mAnimationFX;
  public Semaphore mPauseEnd = new Semaphore(0);

  public AnimationPauseFX(StickmanFX sm, AnimationStickmanFX a, int duration) {
    mStickmanFX = sm;
    mAnimationFX = a;

    new WaitThread(duration).start();

    // block this until WaitThread will unblock
    try {
      mPauseEnd.acquire(1);
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }

    // tell animation to proceed
    mAnimationFX.animationPartStartSemaphore.release();
  }

  private class WaitThread extends Thread {

    int mSleepTime = 0;

    public WaitThread(int time) {
      mSleepTime = time;
    }

    @Override
    public void run() {
      // directly go to sleep
      try {
        sleep(mSleepTime);
      } catch (InterruptedException ex) {
        mStickmanFX.mLogger.severe(ex.getMessage());
      }
      mPauseEnd.release();
    }
  }
}
