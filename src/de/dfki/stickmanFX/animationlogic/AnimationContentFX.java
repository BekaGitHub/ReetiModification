/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.bodyfx.StickmanFXParts;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContentFX extends AnimationContent {

  public AnimationContentFX(StickmanFXParts bp, String a, int p) {
    mBodypart = bp;
    mAction = a;
    mParam = p;
    mParamString = "";
  }

  public AnimationContentFX(StickmanFXParts bp, String a, String p) {
    mBodypart = bp;
    mAction = a;
    mParam = 0;
    mParamString = p;
  }

  public AnimationContentFX(StickmanFXParts bp, String a, String p, WordTimeMarkSequence wts) {
    mBodypart = bp;
    mAction = a;
    mParam = 0;
    mParamString = p;
    mWTS = wts;
  }
}
