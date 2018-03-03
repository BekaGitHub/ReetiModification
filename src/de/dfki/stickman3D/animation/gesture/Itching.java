package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import java.util.ArrayList;

/**
 * @author Beka
 */
public class Itching extends AnimationStickman3D {

  public Itching() {
    mAnimType = ANIMTYPE.ON;
  }

  public Itching(Stickman3D sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    // bring upper arm and fore arm in position
    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -25));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -35));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 65));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 10));
    playAnimationPart(duration);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", 8));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", -8));
    playAnimationPart(50);

    for (int i = 0; i < 4; i++) {
      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 10));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", 60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", 70));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 80));
      playAnimationPart(200);

      pauseAnimation(200);

      animationContents = new ArrayList<>();
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -10));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", -60));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", -70));
      animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -80));
      playAnimationPart(200);
    }

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", -8));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", 8));
    playAnimationPart(50);

    animationContents = new ArrayList<>();
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 25));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 35));
    animationContents.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -65));

    animationContents.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -10));

    playAnimationPart(duration);

    if (StickmanStageController.currentRadioButton != null) {
      StickmanStageController.currentRadioButton.setSelected(false);
    }

  }
}
