package de.dfki.reeti.controllerhelper;

import com.jfoenix.controls.JFXColorPicker;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.Reeti.LED;
import de.dfki.reeti.ReetiController;
import javafx.scene.paint.Color;

public class LedColor {

  public static void setLedColor(JFXColorPicker colorPicker, Reeti reeti, LED led) {
    Color color = colorPicker.getValue();
    reeti.setLedColor(color, led);
  }
}
