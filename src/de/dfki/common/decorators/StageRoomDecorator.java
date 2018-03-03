package de.dfki.common.decorators;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageRoomDecorator implements StageRoom {

  protected StageRoom controllerFX;

  public StageRoomDecorator(StageRoom wrappedController) {
    controllerFX = wrappedController;
  }

  @Override
  public boolean ismNetwork() {
    return controllerFX.ismNetwork();
  }

  @Override
  public void clearStage() {
    controllerFX.clearStage();
  }

  @Override
  public void sendTimeMarkInformation(String timemark) {
    controllerFX.sendTimeMarkInformation(timemark);
  }

  @Override
  public void sendAnimationUpdate(String state, String id) {
    controllerFX.sendAnimationUpdate(state, id);
  }

  @Override
  public void launchAgentStage(boolean show) {
    controllerFX.launchAgentStage(show);
  }

  public void addAgent(String name) {
    controllerFX.addAgent(name);
  }

  public void addAgent(String name, boolean onlyFace) {
    controllerFX.addAgent(name, onlyFace);
  }

  @Override
  public void animate(String stickmanname, String name, int duration, String text, boolean block) {
    controllerFX.animate(stickmanname, name, duration, text, block);
  }

  @Override
  public AgentInterface getAgent(String name) {
    return controllerFX.getAgent(name);
  }

  public AgentsOnStage getCommonAgentsOnStage() {
    return controllerFX.getCommonAgentsOnStage();
  }

  public AgentStage getAgentStage() {
    return controllerFX.getAgentStage();
  }

  public String getStageIdentifier() {
    return controllerFX.getStageIdentifier();
  }

  public void setFullScreen(boolean fullScreen) {
    controllerFX.setFullScreen(fullScreen);
  }

  @Override
  public BufferedImage getStageAsImage() throws Exception {
    return controllerFX.getStageAsImage();
  }

  @Override
  public void launchConfiguration() {
  }

  @Override
  public void launchConfiguration(String filepath) {

  }

  @Override
  public void launchStage(boolean show, String filepath) {
    controllerFX.launchStage(show, filepath);
  }

}
