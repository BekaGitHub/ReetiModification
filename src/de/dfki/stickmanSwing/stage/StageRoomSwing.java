package de.dfki.stickmanSwing.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanSwing.StickmanSwing;
import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/19/16.
 */
public class StageRoomSwing implements StageRoom {

  private AgentsOnStage commonStickmansOnStage;
  private AgentStage stickmanStage;
  private boolean fullScreen = false;

  public StageRoomSwing() {
    stickmanStage = new StickmanStageSwing();
    commonStickmansOnStage = new StickmansOnStageSwing(stickmanStage, this);
    //agentStage.setAgentsOnStage(agentsOnStage);
  }

  @Override
  public void clearStage() {
    commonStickmansOnStage.clearStage();
    ((StickmanStageSwing) stickmanStage).clearStage();
  }

  @Override
  public void animate(String stickmanname, String name, int duration, String text, boolean block) {
    StickmanSwing sm = (StickmanSwing) commonStickmansOnStage.getAgent(stickmanname);
    sm.doAnimation(name, duration, text, block);
  }

  @Override
  public boolean ismNetwork() {
    return false;
  }

  @Override
  public void sendTimeMarkInformation(String timemark) {
  }

  @Override
  public void sendAnimationUpdate(String state, String id) {
  }

  @Override
  public void addAgent(String name) {
    commonStickmansOnStage.addAgent(name, fullScreen);
    ((StickmanStageSwing) stickmanStage)
        .addStickmanToPanel((StickmanSwing) commonStickmansOnStage.getAgent(name));
    ((StickmanStageSwing) stickmanStage).pack();
    ((StickmanStageSwing) stickmanStage).setVisible(true);
  }

  @Override
  public AgentInterface getAgent(String name) {
    return commonStickmansOnStage.getAgent(name);
  }

  @Override
  public void launchAgentStage(boolean show) {
  }

  @Override
  public AgentStage getAgentStage() {
    return stickmanStage;
  }

  public AgentsOnStage getCommonAgentsOnStage() {
    return commonStickmansOnStage;
  }

  @Override
  public String getStageIdentifier() {
    return "";
  }

  @Override
  public void setFullScreen(boolean fullS) {
    fullScreen = fullS;
    ((StickmanStageSwing) stickmanStage).setFullScreenSize();
  }

  @Override
  public void addAgent(String name, boolean onlyFace) {
    addAgent(name);
  }

  @Override
  public BufferedImage getStageAsImage() {
    return null;
  }

  @Override
  public void launchConfiguration() {

  }

  @Override
  public void launchConfiguration(String filepath) {

  }

  @Override
  public void launchStage(boolean show, String filepath) {

  }
}
