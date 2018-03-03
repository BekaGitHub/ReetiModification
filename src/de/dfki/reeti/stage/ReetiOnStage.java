package de.dfki.reeti.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.Gender;
import de.dfki.common.XmlTransform;
import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.reeti.Reeti;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 9/19/16.
 */
public class ReetiOnStage extends AgentsOnStage {

  private String identifier;

  public ReetiOnStage(AgentStage stickmanStage) {
    super(stickmanStage);
  }

  public ReetiOnStage(AgentStage stickmanStageFX, StageRoom controllerFX) {
    super(stickmanStageFX, controllerFX);
  }

  public ReetiOnStage(AgentStage stickmanStageFX, StageRoom controllerFX, String identifier) {
    super(stickmanStageFX, controllerFX);
    this.identifier = identifier;
  }

  @Override
  protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender) {
    if (fullScreen) {
      AgentInterface stickman = new Reeti(name, gender, agentStage.getFullScreenScale(),
          agentStage.getFullScreenDimension());
      putFullAgentOnStage(name, stickman);
    } else {

      createNonFullAgent(name, gender, DEFAULT_SCALE);
    }
  }

  @Override
  protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender,
      boolean onlyFace) {
    if (fullScreen) {
      AgentInterface agent = new Reeti(name, gender, agentStage.getFullScreenScale(),
          agentStage.getFullScreenDimension());
      putFullAgentOnStage(name, agent);
    } else {
      float scale = DEFAULT_SCALE;
      if (onlyFace) {
        scale = 1.0f;
      }
      createNonFullAgent(name, gender, scale);

    }
  }

  private void createNonFullAgent(String name, Gender.TYPE gender, float scale) {
    if (!identifier.equals("")) {
      try {
        HBox h = agentStage.getAgentBox(identifier);

        AgentInterface agent = new Reeti(name, gender, scale, h.getPrefHeight());
        putFullAgentOnStage(name, agent);
      } catch (Exception ex) {
        Logger.getLogger(ReetiOnStage.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  @Override
  public XmlTransform getmXmlTransform() {
    throw new UnsupportedOperationException(
        "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
