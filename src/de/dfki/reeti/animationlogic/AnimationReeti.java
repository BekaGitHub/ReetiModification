/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.reeti.Reeti;
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
public class AnimationReeti extends Animation implements XMLParseable, XMLWriteable,
    AnimationInterface {

  private AnimatorReeti animatorReeti;
  private AnimationPauseReeti animationPauseReeti;
  private Reeti reeti;
  private int actionDuration = -1;
  private HashMap<String, String> extraParams = new HashMap<>();
  private ANIMTYPE animtype;
  public AnimationReeti() {
  }

  public AnimationReeti(Reeti reeti, int duration, boolean block) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    agentName = this.reeti.name;
    setName(agentName + "'s AnimationSwing " + name);
    ID = this.reeti.getID(); // default ID;
    isBlocked = block;
    this.duration = duration;
  }

  public AnimationReeti(Reeti reeti, int duration, int pos, boolean block) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    agentName = this.reeti.name;
    setName(agentName + "'s AnimationSwing " + name);
    ID = this.reeti.getID(); // default ID;
    isBlocked = block;
    this.duration = duration;
    this.actionDuration = actionDuration;
  }

  public AnimationReeti(Reeti reeti, int frequent, int actionDuration, boolean block,
      HashMap<String, String> extraParams) {
    name = getClass().getSimpleName();
    this.reeti = reeti;
    agentName = this.reeti.name;
    setName(agentName + "'s AnimationSwing " + name);
    ID = this.reeti.getID(); // default ID;
    isBlocked = block;
    duration = frequent;
    this.actionDuration = actionDuration;
    this.extraParams = extraParams;
  }

  @Override
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

  public void setExtraParams(HashMap<String, String> extraParams) {
    this.extraParams = extraParams;
  }

  public void setReetiName(String stickmanName) {
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
    reeti.animationSchedulerReeti.introduce(this);
    // block this animation for animation - AnimationSheduler will unblock
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

    // tell Agent this animation has been scheduled and a next one can come
    reeti.mAnimationLaunchControl.release();
  }

  public void play() {
    // wait until AnimationScheduler says go!
    try {
      animationStartSemaphore.acquire(1);
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

    playAnimation();
  }

  public void playAnimation() {
    // place animation code here
  }

  public void playAnimationPart(int duration) {
    animatorReeti = new AnimatorReeti(reeti, this, animationContents, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }

  }

  public void pauseAnimation(int duration) {
    animationPauseReeti = new AnimationPauseReeti(reeti, this, duration);

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      reeti.logger.severe(ex.getMessage());
    }
  }

  public void finalizeAnimation() {
    // unblock AnimationScheduler if animation is a blocking animation
    if (isBlocked) {
      reeti.animationSchedulerReeti.proceed(this);
    } else {
      reeti.animationSchedulerReeti.removeAnimation(this);
    }
    // send event that AnimationReeti is ended

    // API or TCP-Interface
//    if (!reeti.getStageController().ismNetwork()) {
//      reeti.notifyListeners(getmID());
//    } else {
//      reeti.getStageController().sendAnimationUpdate("end", getmID());
//    }
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

  public AnimatorReeti getAnimatorReeti() {
    return animatorReeti;
  }

  public void setAnimatorReeti(AnimatorReeti animatorReeti) {
    this.animatorReeti = animatorReeti;
  }

  public AnimationPauseReeti getAnimationPauseReeti() {
    return animationPauseReeti;
  }

  public void setAnimationPauseReeti(AnimationPauseReeti animationPauseReeti) {
    this.animationPauseReeti = animationPauseReeti;
  }

  public Reeti getReeti() {
    return reeti;
  }

  public void setReeti(Reeti reeti) {
    this.reeti = reeti;
  }

  public int getActionDuration() {
    return actionDuration;
  }

  public void setActionDuration(int actionDuration) {
    this.actionDuration = actionDuration;
  }

  public ANIMTYPE getAnimtype() {
    return animtype;
  }

  public void setAnimtype(ANIMTYPE animtype) {
    this.animtype = animtype;
  }

  @Override
  public String toString() {
    return name + ", " + getName();
  }

  public enum ANIMTYPE {
    ON, OFF
  }
}
