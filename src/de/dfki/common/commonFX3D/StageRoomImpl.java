package de.dfki.common.commonFX3D;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.ApplicationLauncher;
import de.dfki.common.interfaces.StageRoom;
import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 11/13/16.
 */
public abstract class StageRoomImpl implements StageRoom {

  public static final String CONFIG_STAGE = "configStage";
  protected ApplicationLauncher applicationLauncher = null;
  protected AgentStage agentStage = null;
  protected AgentsOnStage agentsOnStage = null;
  protected String stageIdentifier = null;
  private boolean fullScreen = false;

  public abstract void init(String stageIdentifier);

  protected abstract void getStageInstance();

  protected abstract void createNewStage(int x, int y, boolean decoration);

  @Override
  public void clearStage() {
    getCommonAgentsOnStage().clearStage();
    agentStage.clearStage(stageIdentifier);
  }

  @Override
  public void animate(String agentName, String name, int duration, String text, boolean block) {
    AgentInterface agent = getCommonAgentsOnStage().getAgent(agentName);
    agent.doAnimation(name, duration, text, block);
  }

  @Override
  public boolean ismNetwork() {
    return false;
  }

  @Override
  public void launchAgentStage(boolean show) {
    try {
      getAgentStage().addAgentToStage(getStageIdentifier());
      if (show) {
        getAgentStage().showStage(getStageIdentifier());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addAgent(String name) {
    getCommonAgentsOnStage().addAgent(name, fullScreen);
  }

  @Override
  public void addAgent(String name, boolean onlyFace) {
    getCommonAgentsOnStage().addAgent(name, fullScreen, onlyFace);
  }

  @Override
  public BufferedImage getStageAsImage() throws Exception {
    return getAgentStage().getStageAsImage(stageIdentifier);
  }

  @Override
  public AgentInterface getAgent(String name) {
    return getCommonAgentsOnStage().getAgent(name);
  }

  @Override
  public AgentsOnStage getCommonAgentsOnStage() {
    return agentsOnStage;
  }

  @Override
  public AgentStage getAgentStage() {
    return agentStage;
  }

  @Override
  public String getStageIdentifier() {
    return stageIdentifier;
  }

  @Override
  public void setFullScreen(boolean fullScreen) {
    this.fullScreen = fullScreen;
  }

}
