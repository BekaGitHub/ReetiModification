/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.body.BodyPart;
import de.dfki.util.Movement;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContent {

  public BodyPart mBodypart;
  public Movement movementAction;
  public int position;
  public String bodyPartMovementAction;

  public AnimationContent(BodyPart bp, Movement movementAction, int position) {
    mBodypart = bp;
    this.movementAction = movementAction;
    this.position = position;
    bodyPartMovementAction = "";
  }

  public AnimationContent(BodyPart bp, Movement movementAction, String action) {
    mBodypart = bp;
    this.movementAction = movementAction;
    position = 0;
    this.bodyPartMovementAction = action;
  }
}
