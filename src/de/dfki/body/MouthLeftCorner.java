package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;

/**
 * @author Beka Aptsiauri
 */
public class MouthLeftCorner extends Lip {

  private MouthUpperLip mouthUpperLip;

  public MouthLeftCorner(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  @Override
  public void calculate(int step) {
    MouthUpperLip.getnstance().getUpperLip().setEndY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    createTimeline(animationContentTest, mouthUpperLip.getUpperLip().endYProperty()).play();
  }

  double calculateMovementPosition(double position) {
    return 25 + (position / 5);
  }
}
