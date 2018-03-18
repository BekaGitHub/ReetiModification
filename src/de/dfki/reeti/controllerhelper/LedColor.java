package de.dfki.reeti.controllerhelper;

import com.jfoenix.controls.JFXColorPicker;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.Reeti.LED;
import de.dfki.reeti.ReetiController;
import javafx.scene.paint.Color;

public class LedColor {

  public static void leftLedColorChanger(ReetiController controller) {
    if (controller.currentReeti != null) {
//      Color color = controller.leftLedColorPicker.getValue();
//      controller.currentReeti.setLedColor(color, Reeti.LED.LEFTLED);
    }
  }

  public static void rightLedColorChanger(ReetiController controller) {
    if (controller.currentReeti != null) {
//      Color color = controller.rightLedColorPicker.getValue();
//      controller.currentReeti.setLedColor(color, Reeti.LED.RIGHTLED);
    }
  }

  public static void bothLedColorChanger(ReetiController controller) {
    if (controller.currentReeti != null) {
//      Color color = controller.bothLedColorPicker.getValue();
//      controller.currentReeti.setLedColor(color, Reeti.LED.BOTHLED);
    }
  }

  public static void setLedColor(JFXColorPicker colorPicker, Reeti reeti, LED led) {
    Color color = colorPicker.getValue();
    reeti.setLedColor(color, led);
  }
}
