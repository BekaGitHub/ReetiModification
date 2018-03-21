/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.animationlogic.commonlogic.AnimationContent;
import de.dfki.body.ReetiBodyPart;
import de.dfki.util.Movement;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContentReeti extends AnimationContent {

  public AnimationContentReeti(ReetiBodyPart bp, Movement movementAction, int position) {
    mBodypart = bp;
    this.movementAction = movementAction;
    this.position = position;
    bodyPartMovementAction = "";
  }

  public AnimationContentReeti(ReetiBodyPart bp, Movement movementAction, String action) {
    mBodypart = bp;
    this.movementAction = movementAction;
    position = 0;
    this.bodyPartMovementAction = action;
  }
}
