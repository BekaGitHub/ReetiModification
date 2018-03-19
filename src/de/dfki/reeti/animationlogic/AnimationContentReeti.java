/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.reeti.body.ReetiParts;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContentReeti extends AnimationContent {

  public AnimationContentReeti(ReetiParts bp, String a, int p) {
    mBodypart = bp;
    mAction = a;
    mParam = p;
    mParamString = "";
  }

  public AnimationContentReeti(ReetiParts bp, String a, String p) {
    mBodypart = bp;
    mAction = a;
    mParam = 0;
    mParamString = p;
  }
}
