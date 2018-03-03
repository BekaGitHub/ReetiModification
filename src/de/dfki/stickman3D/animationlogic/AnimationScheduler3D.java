package de.dfki.stickman3D.animationlogic;

import de.dfki.stickman3D.Stickman3D;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Beka Aptsiauri
 */
public class AnimationScheduler3D extends Thread {

  public LinkedBlockingQueue<AnimationStickman3D> mAnimationQueue = new LinkedBlockingQueue<>();
  public Semaphore mTheBlockOfHell = new Semaphore(1);
  Stickman3D mStickmanFX;
  boolean mRunning = true;

  public AnimationScheduler3D(Stickman3D s) {
    setName(s.mName + "'s AnimationScheduler");
    mStickmanFX = s;
  }

  public void introduce(AnimationStickman3D a) {
    try {
      mAnimationQueue.put(a);
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }
  }

  public void proceed(AnimationStickman3D a) {
    removeAnimation(a);
    mTheBlockOfHell.release();
  }

  public void removeAnimation(AnimationStickman3D a) {
    mAnimationQueue.remove(a);
  }

  public synchronized void end() {
    mRunning = false;

    // throw in a last animation that unblocks the scheduler letting him end
    try {
      mAnimationQueue.put(new AnimationStickman3D(mStickmanFX, 1, false) {
      });
    } catch (InterruptedException ex) {
      Logger.getLogger(AnimationScheduler3D.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    while (mRunning) {
      try {
        // serialize all animations here ...
        mTheBlockOfHell.acquire(1);

        // get the next animation in the animation queue
        AnimationStickman3D animationFX = mAnimationQueue.take();

        // tell the animation to render itself
        animationFX.animationStartSemaphore.release();

        // unblock the scheduler if animation is not blocking
        if (!animationFX.isBlocked) {
          mTheBlockOfHell.release();
          removeAnimation(animationFX);
        }
      } catch (InterruptedException ex) {
        mStickmanFX.mLogger.severe(ex.getMessage());
      }
    }
  }
}
