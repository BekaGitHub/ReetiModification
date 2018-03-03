package de.dfki.common.agents;

import java.awt.Dimension;

/**
 * Created by EmpaT on 14.07.2017.
 */
public abstract class Agent3D extends AgentFX {

  private double stageHeight;
  public boolean isFullScreen = false;
  public Dimension size = new Dimension(300, 800);

  public double getStageHeight() {
    return stageHeight;
  }

  public void setStageHeight(double stageHeight) {
    this.stageHeight = stageHeight;
  }
}
