package de.dfki.tts;

import de.dfki.agent.Reeti;
import de.dfki.tts.Cereproc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Speak extends Thread {

  private Cereproc cereproc;
  private Reeti reeti;
  private String text;

  public Speak(Reeti reeti) {
    this.reeti = reeti;
    cereproc = new Cereproc(null);
    cereproc.setLibraryPathFromXML("cereproc-library-path");
    cereproc.setVoiceNameFromXML("voice-name");
    cereproc.setLicenseNameFromXML("license-name");
    cereproc.buildCereVoice();
  }

  public void setCereproc(Cereproc cereproc) {
    this.cereproc = cereproc;
    cereproc.setLibraryPathFromXML("cereproc-library-path");
    cereproc.setVoiceNameFromXML("voice-name");
    cereproc.setLicenseNameFromXML("license-name");
    cereproc.buildCereVoice();
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setTextFromFile(String filePath) {
    cereproc.speakFromFile(filePath);
  }

  @Override
  public void run() {
    List<String> sentences = getSentence(text, 20);
    for (int i = 0; i < sentences.size(); i++) {
      String sencence = sentences.get(i);
      reeti.showSpeechBubble(sencence);
      cereproc.speak(sencence);
    }
    reeti.hideSpeechBubble();
  }

  private List<String> getSentence(String text, int sentenseSize) {
    Queue<String> splitText = new LinkedList<>(Arrays.asList(text.split(" ")));
    String sentenceBlock = "";
    if (splitText.size() <= sentenseSize) {
      sentenceBlock = splitText.stream().collect(Collectors.joining(" "));
      return new ArrayList<>(Collections.singletonList(sentenceBlock));
    } else {
      List<String> sentences = new ArrayList<>();
      int limit = (splitText.size() % sentenseSize == 0) ? splitText.size() / 20
          : splitText.size() / 20 + 1;
      for (int k = 0; k < limit; k++) {
        while (sentenceBlock.split(" ").length < 20) {
          if (splitText.isEmpty()) {
            break;
          }
          sentenceBlock += splitText.poll() + " ";
        }
        sentences.add(sentenceBlock);
        sentenceBlock = "";
      }
      return sentences;
    }
  }

}
