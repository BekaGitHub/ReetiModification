package de.dfki.common.decorators;

import de.dfki.common.interfaces.StageRoom;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageRoomFullScreenDecorator extends StageRoomDecorator {

  public StageRoomFullScreenDecorator(StageRoom wrappedController) {
    super(wrappedController);
  }

  @Override
  public void addAgent(String name) {
    setFullScreen(true);
    super.addAgent(name);
  }

  @Override
  public void launchAgentStage(boolean show) {
    controllerFX.getAgentStage().setStageFullScreen(controllerFX.getStageIdentifier());
    super.launchAgentStage(show);
  }

  @Override
  public void launchStage(boolean show, String filepath) {
    controllerFX.getAgentStage().setStageFullScreen(controllerFX.getStageIdentifier());
    super.launchStage(show, filepath);
  }

}
