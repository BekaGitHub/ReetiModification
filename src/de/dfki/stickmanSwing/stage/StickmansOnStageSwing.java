package de.dfki.stickmanSwing.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.Gender;
import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.xmlsettings.XmlTransformFX;
import de.dfki.stickmanSwing.StickmanSwing;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageSwing extends AgentsOnStage {

  public StickmansOnStageSwing(AgentStage stickmanStage) {
    super(stickmanStage);
  }

  public StickmansOnStageSwing(AgentStage stickmanStage, StageRoom controller) {
    super(stickmanStage, controller);
  }

  @Override
  protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender) {
    if (fullScreen) {
      AgentInterface stickman = new StickmanSwing(name, gender, agentStage.getFullScreenScale(),
          agentStage.getFullScreenDimension());
      putFullAgentOnStage(name, stickman);
    } else {
      AgentInterface stickman = new StickmanSwing(name, gender, DEFAULT_SCALE);
      putFullAgentOnStage(name, stickman);
    }
  }

  @Override
  protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender,
      boolean onlyFace) {
    addAgentToStage(name, fullScreen, gender);
  }

  public XmlTransformFX getmXmlTransform() {
    return null;
  }
}
