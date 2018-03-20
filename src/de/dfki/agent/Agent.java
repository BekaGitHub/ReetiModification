package de.dfki.agent;

import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Agent {

  AnimationReeti doAnimation(String name, int duration, boolean block);

  AnimationReeti doAnimation(String name, int duration, Object param, boolean block);
}
