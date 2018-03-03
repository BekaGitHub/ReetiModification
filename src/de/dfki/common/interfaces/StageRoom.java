package de.dfki.common.interfaces;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agents.AgentInterface;
import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/12/16.
 */
public interface StageRoom {

  void clearStage();

  void animate(String agentName, String name, int duration, String text, boolean block);

  boolean ismNetwork();

  void sendTimeMarkInformation(String timemark);

  void sendAnimationUpdate(String state, String id);

  void addAgent(String name);

  void addAgent(String name, boolean onlyFace);

  AgentInterface getAgent(String name);

  void launchAgentStage(boolean show);

  AgentStage getAgentStage();

  AgentsOnStage getCommonAgentsOnStage();

  String getStageIdentifier();

  void setFullScreen(boolean fullScreen);

  BufferedImage getStageAsImage() throws Exception;

  void launchConfiguration();

  void launchConfiguration(String filepath);

  void launchStage(boolean show, String filepath);
}
