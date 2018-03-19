/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import org.w3c.dom.Element;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationStickmanFX extends Animation implements XMLParseable, XMLWriteable,
    AnimationInterface {

  public AnimatorStickmanFX mAnimator;
  public AnimationPauseFX mAnimationPause;
  public StickmanFX mStickmanFX;
  public ANIMTYPE mAnimType = null;
  public AnimationStickmanFX(StickmanFX sm, int duration, boolean block) {
    name = getClass().getSimpleName();
    mStickmanFX = sm;
    agentName = mStickmanFX.name;
    setName(agentName + "'s AnimationSwing " + name);
    ID = mStickmanFX.getID(); // default ID;
    isBlocked = block;
    this.duration = duration;
  }

  public AnimationStickmanFX() {
    mAnimType = null;
  }

  public void setParameter(Object p) {
    parameter = p;
  }

  public String getmID() {
    return ID;
  }

  public void setID(String id) {
    ID = id;
  }

  public void setStickmanName(String stickmanName) {
    agentName = stickmanName;
    //mStickmanSwing = StickmanStage3D.getAgent(agentName);
    setName(agentName + "'s AnimationSwing " + name);
  }

  public void setAnimationName(String animationName) {
    name = animationName;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setBlocking(boolean blocking) {
    isBlocked = blocking;
  }

  public void waitForClearance() {
    mStickmanFX.mAnimationSchedulerFX.introduce(this);
    // block this animation for animation - AnimationSheduler will unblock
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }

    // tell Agent this animation has been scheduled and a next one can come
    mStickmanFX.animationLaunchControlSemaphor.release();
  }

  public void play() {
    // wait until AnimationScheduler says go!
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }

    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    mAnimator = new AnimatorStickmanFX(mStickmanFX, this, animationContents, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }

  }

  public void pauseAnimation(int duration) {
    mAnimationPause = new AnimationPauseFX(mStickmanFX, this, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickmanFX.mLogger.severe(ex.getMessage());
    }
  }

  public void finalizeAnimation() {
    // unblock AnimationScheduler if animation is a blocking animation
    if (isBlocked) {
      mStickmanFX.mAnimationSchedulerFX.proceed(this);
    } else {
      mStickmanFX.mAnimationSchedulerFX.removeAnimation(this);
    }
    // send event that AnimationStickman3D is ended

    // API or TCP-Interface
    if (!mStickmanFX.getStageController().ismNetwork()) {
      mStickmanFX.notifyListeners(getmID());
    } else {
      mStickmanFX.getStageController().sendAnimationUpdate("end", getmID());
    }
  }

  @Override
  public void writeXML(IOSIndentWriter out) throws XMLWriteError {
    out.println(
        "<StickmanAnimation stickmanname = \"" + agentName + "\" name=\"" + name + "\" id=\""
            + getmID() + "\" duration=\"" + duration
            + "\" blocking=\"" + isBlocked
            + "\">").push();
    if (parameter != null) {
      if (parameter instanceof WordTimeMarkSequence) {
        ((WordTimeMarkSequence) parameter).writeXML(out);
      }

      if (parameter instanceof String) {
        out.println((String) parameter);
      }
    }
    out.pop().println("</StickmanAnimation>");
  }

  @Override
  public void parseXML(final Element element) throws XMLParseError {
    agentName = element.getAttribute("stickmanname");
    name = element.getAttribute("name");
    ID = element.getAttribute("id");
    duration = Integer.parseInt(element.getAttribute("duration"));
    isBlocked = Boolean.parseBoolean(element.getAttribute("blocking"));
    parameter = (String) element.getTextContent();

    // Process The Child Nodes
    XMLParseAction.processChildNodes(element, new XMLParseAction() {
      @Override
      public void run(final Element element) throws XMLParseError {
        // Get The Child Tag Name
        final String name = element.getTagName();

        if (name.equalsIgnoreCase("WordTimeMarkSequence")) {
          parameter = new WordTimeMarkSequence();

          ((WordTimeMarkSequence) parameter).parseXML(element);
        } else {
          parameter = (String) element.getTextContent();
        }
      }
    });
  }

  @Override
  public void run() {
    waitForClearance();
    play();
    finalizeAnimation();
  }

  @Override
  public String toString() {
    return name + ", " + getName();
  }

  public enum ANIMTYPE {
    EmotionExpression, Gesture
  }
}
