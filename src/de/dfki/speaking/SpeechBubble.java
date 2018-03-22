package de.dfki.speaking;

import de.dfki.body.Head;
import de.dfki.util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;

public class SpeechBubble extends Pane {

  private Head head;
  private Label textLabel;
  private HBox bubbleBox;

  public SpeechBubble (Head head) {
    this.head = head;
    createSpeechBubble();
  }


  public void showSpeechBubble(String speechText) {
    textLabel.setText(speechText);
    bubbleBox.setVisible(true);
  }

  public void hideSpeechBubble() {
    bubbleBox.setVisible(false);
  }

  private void createSpeechBubble() {
    bubbleBox = new HBox();
    bubbleBox.setAlignment(Pos.TOP_CENTER);
    Path face = createFace(Color.rgb(222, 222, 222));
    textLabel = new Label();
    textLabel.setMaxWidth(200);
    textLabel.setMinHeight(70);
    textLabel.setPadding(new Insets(5, 5, 5, 5));
    textLabel.setWrapText(true);
    createMessageStyle(textLabel);
    bubbleBox.getChildren().addAll(face, textLabel);
    bubbleBox.setTranslateZ(-200);
    bubbleBox.setTranslateY(-150);
    bubbleBox.setTranslateX(150);

    bubbleBox.setVisible(false);

    setSpeechBubblePosition();
    this.getChildren().add(bubbleBox);

  }

  private void setSpeechBubblePosition() {
    bubbleBox.setTranslateX(Constants.SPEECH_BUBBLE_X_POSITION);
    bubbleBox.setTranslateY(Constants.SPEECH_BUBBLE_Y_POSITION);
    bubbleBox.setTranslateZ(Constants.SPEECH_BUBBLE_Z_POSITION);
  }

  private Path createFace(Color color) {
    Path path = new Path();
    path.setStroke(Color.GRAY.darker());
    path.setStrokeWidth(2);
    path.getElements().add(new MoveTo(2, 0));
    path.getElements().add(new CubicCurveTo(-10, 15, -50, 10, -90, -5));
    path.getElements().add(new LineTo(2, 50));
    path.setTranslateX(4);
    path.setTranslateZ(-1);
    path.setFill(color);

    return path;
  }

  private void createMessageStyle(Label message)
  {
    message.setStyle("-fx-background-color: #DEDEDE; "
        + "-fx-border-color: #585858;  " +
        "-fx-border-width: 2;"
        + "-fx-border-radius: 10 10 10 10;\n"
        + "-fx-background-radius: 10 10 10 10;");
    message.setFont(new Font("Comic Sans MS", 16));
  }

}
