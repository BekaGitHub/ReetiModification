/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.reeti.Reeti;
import java.util.List;

/**
 * @author Beka Aptsiauri
 */
public class EventAnimationReeti extends AnimationReeti {

  public List<Long> mTimepoints;

  public EventAnimationReeti() {
    super();
  }

  public EventAnimationReeti(Reeti reet, int duration, boolean block) {
    super(reet, duration, block);
    name = getClass().getSimpleName();
  }
}
