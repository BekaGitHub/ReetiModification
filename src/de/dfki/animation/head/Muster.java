/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.reeti.ReetiController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.util.Movement;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 * @author Beka Aptsiauri
 */
public class Muster extends AnimationReeti {

  public Muster() {
    setAnimtype(ANIMTYPE.ON);
  }

  public Muster(Reeti sm, int duration, boolean block) {
    super(sm, duration, block);
  }

  @Override
  public void playAnimation() {
    Color c1 = Color.rgb(255, 255, 255);
    Color c2 = Color.rgb(255, 0, 255);
    Color c3 = Color.rgb(0, 0, 255);
//    getReeti().ledON(c1, c2, c3, 0.7f, 0.9f, 0.4f, "B");

    getReeti().getMouth().setUpRegulator(-20);
    getReeti().getMouth().setDownRegulator(-10);
//        reeti.mouth.setLeftCornerRegulator(-20);

    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContentReeti(reeti.leftEar, "rotate", 60));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", 60));
    animationContents.add(new AnimationContentReeti(getReeti().getMouth(), Movement.SHAPE, "MOUTHACTION"));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", 60));
    playAnimationPart(animationDuration);

    pauseAnimation(2000);
    getReeti().ledOFF();
    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContentReeti(reeti.leftEar, "rotate", -60));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", -60));
    animationContents.add(new AnimationContentReeti(getReeti().getMouth(), Movement.SHAPE, "MOUTHACTIONEND"));
    playAnimationPart(animationDuration);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
