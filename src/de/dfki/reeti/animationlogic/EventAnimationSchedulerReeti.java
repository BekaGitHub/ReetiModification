package de.dfki.reeti.animationlogic;

import de.dfki.agent.Reeti;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Beka Aptsiauri
 */
public class EventAnimationSchedulerReeti extends Thread {

  public LinkedBlockingQueue<AnimationReeti> mAnimationQueue = new LinkedBlockingQueue<>();
  public Semaphore mTheBlockOfHell = new Semaphore(1);
  Reeti mReeti;
  boolean mRunning = true;

  public EventAnimationSchedulerReeti(Reeti s) {
//    setName(s.name + "'s Event AnimationScheduler");
    mReeti = s;
  }

  public void introduce(AnimationReeti a) {
    try {
      mReeti.logger.info("AnimationSwing " + a + " added to event animation scheduler");

      mAnimationQueue.put(a);
    } catch (InterruptedException ex) {
      mReeti.logger.severe(ex.getMessage());
    }
  }

  public void proceed(AnimationReeti a) {
    removeAnimation(a);
    mTheBlockOfHell.release();
  }

  public void removeAnimation(AnimationReeti a) {
    mAnimationQueue.remove(a);
  }

  public synchronized void end() {
    mRunning = false;

    // throw in a last animationFX that unblocks the scheduler letting him end
    try {
      mAnimationQueue.put(new AnimationReeti(mReeti, 1, false) {
      });
    } catch (InterruptedException ex) {
      Logger.getLogger(EventAnimationSchedulerReeti.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    while (mRunning) {
      try {
        // serialize all animations here ...
        mTheBlockOfHell.acquire(1);

        // get the next animation in the animation queue
        AnimationReeti animation = mAnimationQueue.take();

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
