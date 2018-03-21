/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.body.ReetiParts;
import de.dfki.util.Movement;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContentReeti extends AnimationContent {

  public AnimationContentReeti(ReetiParts bp, Movement movementAction, int p) {
    mBodypart = bp;
    this.movementAction = movementAction;
    mParam = p;
    mParamString = "";
  }

  public AnimationContentReeti(ReetiParts bp, Movement movementAction, String p) {
    mBodypart = bp;
    this.movementAction = movementAction;
    mParam = 0;
    mParamString = p;
  }
}
