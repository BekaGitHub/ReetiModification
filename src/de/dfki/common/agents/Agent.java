package de.dfki.common.agents;

import de.dfki.common.interfaces.AnimationInterface;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Agent {

  AnimationInterface doAnimation(String name, int duration, boolean block);

  AnimationInterface doAnimation(String name, int duration, Object param, boolean block);
}
