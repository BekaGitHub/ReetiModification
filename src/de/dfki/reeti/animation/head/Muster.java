/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
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
    getReeti().ledON(c1, c2, c3, 0.7f, 0.9f, 0.4f, "B");

    getReeti().mouth.setUpRegulator(-20);
    getReeti().mouth.setDownRegulator(-10);
//        reeti.mouth.setLeftCornerRegulator(-20);

    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContentReeti(reeti.leftEar, "rotate", 60));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", 60));
    animationContents.add(new AnimationContentReeti(getReeti().mouth, "shape", "MOUTHACTION"));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", 60));
    playAnimationPart(duration);

    pauseAnimation(2000);
    getReeti().ledOFF("B");
    animationContents = new ArrayList<>();
//        animationContents.add(new AnimationContentReeti(reeti.leftEar, "rotate", -60));
//        animationContents.add(new AnimationContentReeti(reeti.rightEar, "yrotate", -60));
    animationContents.add(new AnimationContentReeti(getReeti().mouth, "shape", "MOUTHACTIONEND"));
    playAnimationPart(duration);

    if (ReetiStageController.currentRadioButton != null) {
      ReetiStageController.currentRadioButton.setSelected(false);
    }
  }
}
