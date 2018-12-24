package de.dfki.style;

import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;

public class Effect {

  public void addEffect(QuadCurve lipQadCurve) {
    lipQadCurve.setStroke(Color.BLACK);
    lipQadCurve.setStrokeWidth(1);
    lipQadCurve.setFill(Color.GRAY.brighter());
  }
}
