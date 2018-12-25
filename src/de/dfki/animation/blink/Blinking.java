package de.dfki.animation.blink;

import de.dfki.agent.Reeti;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public final class Blinking {

  private final Reeti reeti;
  private Timeline blinkTimeline;

  public Blinking(Reeti reeti, int frequent, int actionDuration) {
    this.reeti = reeti;
//    startBlinkAktion(frequent, actionDuration);
  }

//  public void startBlinkAktion(int frequent, int actionDuration) {
//    blinkTimeline = new Timeline(new KeyFrame(Duration.millis(frequent), (ActionEvent event) ->
////        reeti.doAnimation("Blink", actionDuration, false)
//    ));
//    blinkTimeline.setCycleCount(Timeline.INDEFINITE);
//    blinkTimeline.play();
//  }

  public void stopBlinkAktion() {
    if (blinkTimeline != null) {
      blinkTimeline.stop();
    }
  }
}
