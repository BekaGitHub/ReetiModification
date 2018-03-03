package de.dfki.common;

import de.dfki.common.agents.AgentInterface;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanSwing.util.Names;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16.
 */
public abstract class AgentsOnStage {

  public static final float DEFAULT_SCALE = 0.8f;
  protected AgentStage agentStage;
  private Map<String, AgentInterface> agentMap = new HashMap<>();
  private StageRoom stageRoom;
  private String mFilePath;

  public AgentsOnStage(AgentStage stickmanStage) {
    this.agentStage = stickmanStage;
  }

  public AgentsOnStage(AgentStage stickmanStageFX, StageRoom controllerFX) {
    agentStage = stickmanStageFX;
    stageRoom = controllerFX;
  }

  public AgentStage getStageStickman() {
    return agentStage;
  }

  public StageRoom getStageRoom() {
    return stageRoom;
  }

  public void setStageRoom(StageRoom controllerFX) {
    stageRoom = controllerFX;
  }

  public void addAgent(String name, boolean fullScreen) {
    Gender.TYPE gender = getStickmanGender(name);
    addAgent(name, gender, fullScreen);
  }

  public Gender.TYPE getStickmanGender(String name) {
    Gender.TYPE gender = null;
    if (Names.sFemaleNames.contains(name.toLowerCase())) {
      gender = Gender.TYPE.FEMALE;
    } else {
      gender = Gender.TYPE.MALE;
    }
    return gender;
  }

  public void addAgent(String name, Gender.TYPE gender, boolean fullScreen) {
    if (!agentMap.containsKey(name.toLowerCase())) {
      addAgentToStage(name, fullScreen, gender, false);
    }
  }

  public void addAgent(String name, boolean fullScreen, boolean onlyFace) {
    Gender.TYPE gender = getStickmanGender(name);
    if (!agentMap.containsKey(name.toLowerCase())) {
      addAgentToStage(name, fullScreen, gender, onlyFace);
    }
  }

  public void showStickmanNameFX(boolean show) {
    for (AgentInterface s : agentMap.values()) {
      s.setShowName(show);
    }
  }

  protected abstract void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender);

  protected abstract void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender,
      boolean onlyFace);

  public abstract XmlTransform getmXmlTransform();

  public AgentInterface getAgent(String name) {
    if (agentMap.containsKey(name.toLowerCase())) {
      return agentMap.get(name.toLowerCase());
    }
    throw new NullPointerException("No stickman with name " + name);

  }

  public void clearStage() {
    Set<String> deleteStickman = new HashSet<>();
    agentMap.keySet().stream().map((s) ->
    {
      deleteStickman.add(s);
      return s;
    }).forEach((s) ->
    {
      getAgent(s).endAnimationScheduler();
    });
  }

  protected void putFullAgentOnStage(String name, AgentInterface agent) {
    agentMap.put(name.toLowerCase(), agent);
    agent.setStageController(stageRoom);
  }

  public Set<String> getStickmanNames() {
    return agentMap.keySet();
  }

  public AgentInterface getStickmanByKey(String key) {
    return agentMap.get(key);
  }

  public String getmFilePath() {
    return mFilePath;
  }

  public void setmFilePath(String mFilePath) {
    this.mFilePath = mFilePath;
  }

}
