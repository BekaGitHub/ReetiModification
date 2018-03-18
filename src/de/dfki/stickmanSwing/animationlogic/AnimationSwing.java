/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.stickmanSwing.StickmanSwing;
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
public class AnimationSwing extends Animation implements XMLParseable, XMLWriteable,
    AnimationInterface {

  public AnimatorSwing mAnimator;
  public AnimationPause mAnimationPause;
  public StickmanSwing mStickmanSwing;
  public ANIMTYPE mAnimType = null;
  public AnimationSwing() {

  }

  public AnimationSwing(StickmanSwing sm, int duration, boolean block) {
    name = getClass().getSimpleName();
    mStickmanSwing = sm;
    agentName = mStickmanSwing.mName;
    setName(agentName + "'s AnimationSwing " + name);
    ID = mStickmanSwing.getID(); // default ID;
    isBlocked = block;
    this.duration = duration;
  }

  public String getmID() {
    return ID;
  }

  public void setParameter(Object p) {
    parameter = p;
  }

  public void setID(String id) {
    ID = id;
  }

  public void setStickmanName(String stickmanName) {
    agentName = stickmanName;
    //mStickmanSwing = StickmanStageSwing.getAgent(agentName);
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
    mStickmanSwing.mAnimationScheduler.introduce(this);
    // block this animation for animation - AnimationSheduler will unblock
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickmanSwing.mLogger.severe(ex.getMessage());
    }

    // tell Agent this animation has been scheduled and a next one can come
    mStickmanSwing.mAnimationLaunchControl.release();
  }

  public void play() {
    // wait until AnimationScheduler says go!
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickmanSwing.mLogger.severe(ex.getMessage());
    }

    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    mAnimator = new AnimatorSwing(mStickmanSwing, this, animationContents, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickmanSwing.mLogger.severe(ex.getMessage());
    }

  }

  public void pauseAnimation(int duration) {
    mAnimationPause = new AnimationPause(mStickmanSwing, this, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickmanSwing.mLogger.severe(ex.getMessage());
    }
  }

  public void finalizeAnimation() {
    //mStickmanSwing.logger.info(mStickmanSwing.name + "'s AnimationSwing " + getClass().getSimpleName() + " with id " + ID + " has ended - notify Listeners!");
    // unblock AnimationScheduler if animation is a blocking animation
    if (isBlocked) {
      //mStickmanSwing.logger.info("unblocking AnimationScheduler");
      mStickmanSwing.mAnimationScheduler.proceed(this);
    } else {
      mStickmanSwing.mAnimationScheduler.removeAnimation(this);
    }
    // send event that AnimationSwing is ended

    // send event that AnimationSwing is ended - if there is a recipient
    if (mStickmanSwing.getStageController() != null) {
      // API or TCP-Interface
      if (!mStickmanSwing.getStageController().ismNetwork()) {
        mStickmanSwing.notifyListeners(ID);
      } else {
        mStickmanSwing.getStageController().sendAnimationUpdate("end", getmID());
      }
    }
  }

  @Override
  public void writeXML(IOSIndentWriter out) throws XMLWriteError {
    out.println(
        "<StickmanAnimation stickmanname = \"" + agentName + "\" name=\"" + name + "\" id=\"" + ID
            + "\" duration=\"" + duration + "\" blocking=\"" + isBlocked + "\">").push();
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
    //mStickmanSwing.logger.info(mStickmanSwing.name + "'s AnimationSwing " + getClass().getSimpleName() + " wait for clearance.");
    waitForClearance();

    //mStickmanSwing.logger.info(mStickmanSwing.name + "'s AnimationSwing " + getClass().getSimpleName() + " play.");
    play();

    //mStickmanSwing.logger.info(mStickmanSwing.name + "'s AnimationSwing " + getClass().getSimpleName() + " finalize.");
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
