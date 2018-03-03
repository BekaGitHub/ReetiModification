/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.reeti.Reeti;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLWriteError;
import java.util.List;
import org.w3c.dom.Element;

/**
 * @author Beka Aptsiauri
 */
public class EventAnimationReeti extends AnimationReeti {

  public List<Long> mTimepoints;
  public WordTimeMarkSequence mWTS;

  public EventAnimationReeti() {
    super();
  }

  public EventAnimationReeti(Reeti reet, int duration, boolean block) {
    super(reet, duration, block);
    name = getClass().getSimpleName();
    setName(reet.mName + "'s Event AnimationSwing " + name);
  }

  public void playEventAnimationPart() {
    setAnimatorReeti(new AnimatorReeti(getReeti(), this, animationContents, mWTS));

    try {
      animationPartStartSemaphore.acquire();
    } catch (InterruptedException ex) {
      getReeti().mLogger.severe(ex.getMessage());
    }
  }

  @Override
  public void writeXML(IOSIndentWriter out) throws XMLWriteError {
    out.println(
        "<StickmanEventAnimation stickmanname = \"" + agentName + "\" name=\"" + name + "\" id=\""
            + ID
            + "\" duration=\"" + duration + "\" blocking=\"" + isBlocked + "\">").push();
    if (parameter != null) {
      if (parameter instanceof WordTimeMarkSequence) {
        ((WordTimeMarkSequence) parameter).writeXML(out);
      }

      if (parameter instanceof String) {
        out.println((String) parameter);
      }
    }
    out.pop().println("</StickmanEventAnimation>");
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
}
