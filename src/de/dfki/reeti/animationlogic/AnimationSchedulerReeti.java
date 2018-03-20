package de.dfki.reeti.animationlogic;

import de.dfki.agent.Reeti;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Beka Aptsiauri
 */
public class AnimationSchedulerReeti extends Thread {

  public LinkedBlockingQueue<AnimationReeti> animationQueue = new LinkedBlockingQueue<>();
  public Semaphore mTheBlockOfHell = new Semaphore(1);
  Reeti mReeti;
  boolean mRunning = true;

  public AnimationSchedulerReeti(Reeti s) {
//    setName(s.name + "'s AnimationScheduler");
    mReeti = s;
  }

  public void introduce(AnimationReeti a) {
    try {
      animationQueue.put(a);
    } catch (InterruptedException ex) {
      mReeti.logger.severe(ex.getMessage());
    }
  }

  public void proceed(AnimationReeti a) {
    removeAnimation(a);
    mTheBlockOfHell.release();
  }

  public void removeAnimation(AnimationReeti a) {
    animationQueue.remove(a);
  }

  public synchronized void end() {
    mRunning = false;

    // throw in a last animation that unblocks the scheduler letting him end
    try {
      animationQueue.put(new AnimationReeti(mReeti, 1, false) {
      });
    } catch (InterruptedException ex) {
      Logger.getLogger(AnimationSchedulerReeti.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    while (mRunning) {
      try {
        // serialize all animations here ...
        mTheBlockOfHell.acquire(1);

        // get the next animation in the animation queue
        AnimationReeti animation = animationQueue.take();

        // tell the animation to render itself
        animation.animationStartSemaphore.release();

        // unblock the scheduler if animation is not blocking
        if (!animation.isBlocked) {
          mTheBlockOfHell.release();
          removeAnimation(animation);
        }
      } catch (InterruptedException ex) {
        mReeti.logger.severe(ex.getMessage());
      }
    }
  }
}
