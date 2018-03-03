/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.body.Stickman3DParts;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContent3D extends AnimationContent {

  public AnimationContent3D(Stickman3DParts bp, String a, int p) {
    mBodypart = bp;
    mAction = a;
    mParam = p;
    mParamString = "";
  }

  public AnimationContent3D(Stickman3DParts bp, String a, String p) {
    mBodypart = bp;
    mAction = a;
    mParam = 0;
    mParamString = p;
  }

  public AnimationContent3D(Stickman3DParts bp, String a, String p, WordTimeMarkSequence wts) {
    mBodypart = bp;
    mAction = a;
    mParam = 0;
    mParamString = p;
    mWTS = wts;
  }
}
