/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationStickman3D extends Animation implements XMLParseable, XMLWriteable,
    AnimationInterface {

  public static boolean isSmileInAction = false;
  public static boolean isHeadTiltInAction = false;
  public static boolean isSurprisedInAction = false;
  public static boolean isAngryInAction = false;
  public AnimatorStickman3D mAnimator;
  public AnimationPause3D mAnimationPause;
  public Stickman3D mStickman3D;
  public int actionDuration = -1;
  public ANIMTYPE mAnimType = null;
  protected HashMap<String, String> extraParams = new HashMap<>();
  public AnimationStickman3D() {
  }

  public AnimationStickman3D(Stickman3D sm, int duration, boolean block) {
    name = getClass().getSimpleName();
    mStickman3D = sm;
    agentName = mStickman3D.mName;
    setName(agentName + "'s AnimationSwing " + name);
    ID = mStickman3D.getID(); // default ID;
    isBlocked = block;
    this.duration = duration;
  }

  public AnimationStickman3D(Stickman3D sm, int frequent, int actionDuration, boolean block) {
    name = getClass().getSimpleName();
    mStickman3D = sm;
    agentName = mStickman3D.mName;
    setName(agentName + "'s AnimationSwing " + name);
    ID = mStickman3D.getID(); // default ID;
    isBlocked = block;
    duration = frequent;
    this.actionDuration = actionDuration;
  }

  public AnimationStickman3D(Stickman3D sm, int frequent, int actionDuration, boolean block,
      HashMap<String, String> extraParams) {
    name = getClass().getSimpleName();
    mStickman3D = sm;
    agentName = mStickman3D.mName;
    setName(agentName + "'s AnimationSwing " + name);
    ID = mStickman3D.getID(); // default ID;
    isBlocked = block;
    duration = frequent;
    this.actionDuration = actionDuration;
    this.extraParams = extraParams;
  }

  public void setParameter(Object p) {
    parameter = p;
  }

  @Override
  public String getmID() {
    return ID;
  }

  public void setID(String id) {
    ID = id;
  }

  public boolean hasExtraParams() {
    return extraParams.size() > 0;
  }

  public HashMap<String, String> getExtraParams() {
    return extraParams;
  }

  public void setStickmanName(String stickmanName) {
    agentName = stickmanName;
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
    mStickman3D.mAnimationSchedulerFX.introduce(this);
    // block this animation for animation - AnimationSheduler will unblock
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickman3D.mLogger.severe(ex.getMessage());
    }

    // tell Agent this animation has been scheduled and a next one can come
    mStickman3D.mAnimationLaunchControl.release();
  }

  public void play() {
    // wait until AnimationScheduler says go!
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      mStickman3D.mLogger.severe(ex.getMessage());
    }

    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    mAnimator = new AnimatorStickman3D(mStickman3D, this, animationContents, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickman3D.mLogger.severe(ex.getMessage());
    }

  }

  public void pauseAnimation(int duration) {
    mAnimationPause = new AnimationPause3D(mStickman3D, this, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      mStickman3D.mLogger.severe(ex.getMessage());
    }
  }

  public void finalizeAnimation() {
    // unblock AnimationScheduler if animation is a blocking animation
    if (isBlocked) {
      mStickman3D.mAnimationSchedulerFX.proceed(this);
    } else {
      mStickman3D.mAnimationSchedulerFX.removeAnimation(this);
    }
    // send event that AnimationStickman3D is ended

    // API or TCP-Interface
    if (!mStickman3D.getStageController().ismNetwork()) {
      mStickman3D.notifyListeners(getmID());
    } else {
      mStickman3D.getStageController().sendAnimationUpdate("end", getmID());
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
    addExtraParamsToXML(out);
    out.pop().println("</StickmanAnimation>");
  }

  private void addExtraParamsToXML(IOSIndentWriter out) {
    if (extraParams.size() > 0) {
      out.println("<Params>").push();
      for (Map.Entry<String, String> entry : extraParams.entrySet()) {
        out.println("<Param key=\"" + entry.getKey() + "\">" + entry.getValue() + "</Param>")
            .push();
      }
      out.pop().println("</Params>");
    }
  }

  @Override
  public void parseXML(final Element element) throws XMLParseError {
    agentName = element.getAttribute("stickmanname");
    name = element.getAttribute("name");
    ID = element.getAttribute("id");
    duration = Integer.parseInt(element.getAttribute("duration"));
    isBlocked = Boolean.parseBoolean(element.getAttribute("blocking"));
    extraParams = new HashMap<>();

    // Process The Child Nodes
    XMLParseAction.processChildNodes(element, new XMLParseAction() {
      @Override
      public void run(final Element element) throws XMLParseError {
        // Get The Child Tag Name
        final String name = element.getTagName();

        if (name.equalsIgnoreCase("WordTimeMarkSequence")) {
          parameter = new WordTimeMarkSequence();

          ((WordTimeMarkSequence) parameter).parseXML(element);
        } else if (name.equals("Params")) {
          NodeList nodes = element.getChildNodes();
          for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (!node.hasAttributes()) {
              continue;
            }
            String key = node.getAttributes().getNamedItem("key").getNodeValue();
            String value = node.getTextContent();
            extraParams.put(key, value);
          }
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
    ON, OFF
  }
}
