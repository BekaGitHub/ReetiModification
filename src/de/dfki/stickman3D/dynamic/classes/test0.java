package de.dfki.stickman3D.dynamic.classes;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

public class test0 extends AnimationStickman3D {

  public test0() {
    mAnimType = ANIMTYPE.ON;
  }

  public test0(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 0));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 57));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "zrotate", 0));
    playAnimationPart(duration);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 0));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -104));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "zrotate", 0));
    playAnimationPart(duration);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 0));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", 112));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "zrotate", 0));
    playAnimationPart(duration);
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 0));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -119));
    animationContents.add(new AnimationContent3D(mStickman3D.mHead, "zrotate", 0));
    playAnimationPart(duration);
  }
} 
