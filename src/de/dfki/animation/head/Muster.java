/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animation.head;

import de.dfki.agent.Reeti;
import de.dfki.animationlogic.reeti.AnimationReeti;
import de.dfki.controllers.ReetiController;
import de.dfki.util.AnimationVisivility;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 * @author Beka Aptsiauri
 */
public class Muster extends AnimationReeti {

  public Muster() {
    setAnimationVisivility(AnimationVisivility.YES);
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

//    ((Reeti) agent).getMouth().setUpRegulator(-20);
//    ((Reeti) agent).getMouth().setDownRegulator(-10);
//        reeti.mouth.setLeftCornerRegulator(-20);

    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContent(reeti.leftEar, "rotate", 60));
//        animationContents.add(new AnimationContent(reeti.rightEar, "yrotate", 60));
//    animationContents
//        .add(new AnimationContent(((Reeti) agent).getMouth(), Move.SHAPE, "MOUTHACTION"));
//        animationContents.add(new AnimationContent(reeti.rightEar, "yrotate", 60));
    playAnimationPart(animationDuration);

    ((Reeti) agent).ledOFF();
    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContent(reeti.leftEar, "rotate", -60));
//        animationContents.add(new AnimationContent(reeti.rightEar, "yrotate", -60));
//    animationContents.add(
//        new AnimationContent(((Reeti) agent).getMouth(), Move.SHAPE, "MOUTHACTIONEND"));
//    playAnimationPart(animationDuration);

    if (ReetiController.currentRadioButton != null) {
      ReetiController.currentRadioButton.setSelected(false);
    }
  }
}
