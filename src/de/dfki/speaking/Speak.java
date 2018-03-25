package de.dfki.speaking;

import de.dfki.agent.Reeti;
import de.dfki.tts.Cereproc;

public class Speak extends Thread{
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
    reeti.showSpeechBubble(text);
    cereproc.speak(text);
  }

}
