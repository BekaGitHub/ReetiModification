/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.body.BodyPart;
import de.dfki.movement.Move;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContent {

  public BodyPart mBodypart;
  public Move moveAction;
  public int position;
  public String bodyPartMovementAction;

  public AnimationContent(BodyPart bp, Move moveAction, int position) {
    mBodypart = bp;
    this.moveAction = moveAction;
    this.position = position;
    bodyPartMovementAction = "";
  }

  public AnimationContent(BodyPart bp, Move moveAction, String action) {
    mBodypart = bp;
    this.moveAction = moveAction;
    position = 0;
    this.bodyPartMovementAction = action;
  }
}
