package de.dfki.common.interfaces;

import de.dfki.common.AgentsOnStage;
import de.dfki.stickmanFX.StickmanFX;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 9/4/16.
 */
public interface AgentStage {

  float getFullScreenScale();

  Dimension getFullScreenDimension();

  void addAgentToStage(String stageIdentifier) throws Exception;

  void addAgentToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception;

  void setStageFullScreen(String stageIdentifier);

  void setAgentsOnStage(AgentsOnStage agentsOnStage, String identifier);

  HBox getAgentBox(String stageIdentifier) throws Exception;

  BufferedImage getStageAsImage(String stageIdentifier) throws Exception;

  void launcher();

  void clearStage(String stageIdentifier);

  void showStage(String configStage);

  String createNewStage(int x, int y, boolean decoration) throws IOException;
}
