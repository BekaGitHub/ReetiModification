package de.dfki.common.agents;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by EmpaT on 14.07.2017.
 */
public abstract class AgentFX extends Pane implements AgentInterface {

  public final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();
  public Gender.TYPE mType = Gender.TYPE.FEMALE;
  public float mScale = 1.0f;
  public String name;
  public ORIENTATION mOrientation = Stickman3D.ORIENTATION.FRONT;
  // Added by Robbie, to control the character to fade out.
  public boolean setCharacterInvisible = false;
  // True: visible False:invisible
  public double mWobble = 0;
  // the shared variable to decide the while loop in IdleBehavior break or not
  public Boolean mIdleRun = false;
  // Added by Robbie, to control the star appear or not
  public boolean starShowControler = false;
  // id
  public long mID = 0;

  // amimation stuff
  public Semaphore mAnimationLaunchControl = new Semaphore(1);

  public void addListener(AnimationListener al) {
    mAnimationListeners.add(al);
  }

  public void removeListener(AnimationListener al) {
    synchronized (mAnimationListeners) {
      if (mAnimationListeners.contains(al)) {
        mAnimationListeners.remove(al);
      }
    }
  }

  public void notifyListeners(String animationId) {
    synchronized (mAnimationListeners) {
      mAnimationListeners.stream().forEach((al) -> al.update(animationId));
    }
  }

  public String getID() {
    return (new StringBuffer()).append(name).append(" AnimationSwing ").append(mID++).toString();
  }

  public enum ORIENTATION {
    FRONT, LEFT, RIGHT
  }

  public static class logFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
      return ((new StringBuffer()).append(record.getLevel()).append(": ")
          .append(record.getMessage())
          .append("\n")).toString();
    }
  }
}
