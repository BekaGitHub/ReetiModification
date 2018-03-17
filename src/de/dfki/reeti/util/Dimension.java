package de.dfki.reeti.util;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Dimension {

  public static double getScreenWidth() {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    return bounds.getWidth();
  }

  public static double getScreenHight() {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    return bounds.getHeight();
  }

  public static double getReetiStage_X_Center() {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    return bounds.getWidth()/2 - Constants.CONTROLPANEL_WIDTH/2;
  }

  public static double getReetiStage_Y_Center() {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    return bounds.getHeight()/2;
  }

}
