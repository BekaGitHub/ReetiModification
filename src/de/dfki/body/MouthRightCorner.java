package de.dfki.body;

import de.dfki.animationlogic.commonlogic.AnimationContentTest;

/**
 * @author Beka Aptsiauri
 */
public class MouthRightCorner extends Lip {

  private MouthUpperLip mouthUpperLip;

  public MouthRightCorner(MouthUpperLip mouthUpperLip) {
    this.mouthUpperLip = mouthUpperLip;
  }

  @Override
  public void calculate(int step) {
    MouthDownLip.getnstance().getDownLip().setStartY(step);
  }

  @Override
  public void onAnimation(AnimationContentTest animationContentTest) {
    createTimeline(animationContentTest, mouthUpperLip.getUpperLip().startYProperty()).play();
  }

  double calculateMovementPosition(double position) {
    return 25 + (position / 5);
  }
}
