package de.dfki.agent;

import de.dfki.animationlogic.AnimationContent;
import de.dfki.body.BodyPart;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Agent {

  void onAnimation(BodyPart bodyPart,  AnimationContent animationContent);
}
