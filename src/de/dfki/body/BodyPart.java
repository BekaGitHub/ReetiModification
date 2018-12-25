/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import de.dfki.animationlogic.AnimationContent;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;

/**
 * @author Beka Aptsiauri
 */
public abstract class BodyPart extends Pane {

  public static final Logger LOGGER = Logger.getLogger(BodyPart.class.getName());

  public double x_Rotation = 0;
  public double y_Rotation = 0;
  public double z_Rotation = 0;

  public synchronized void calculate(int step) {
  }

  public abstract Timeline onAnimation(AnimationContent AnimationContent);
}
