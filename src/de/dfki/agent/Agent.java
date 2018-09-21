package de.dfki.agent;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.body.BodyPart;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Agent {

  AnimationReeti doAnimation(String name, int duration, boolean block);

  AnimationReeti doAnimation(String name, int duration, Object param, boolean block);

  void onAnimation(BodyPart bodyPart,  AnimationContentTest animationContentTest);
}
