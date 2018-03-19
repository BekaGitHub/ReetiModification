package de.dfki.common.agents;

import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.common.parts.FXParts;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Agent {

  AnimationInterface doAnimation(String name, int duration, boolean block);

  AnimationInterface doAnimation(String name, int duration, Object param, boolean block);

  public abstract FXParts getSpeechBubble();
}
