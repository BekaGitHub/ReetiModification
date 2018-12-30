package de.dfki.tts;

import com.cereproc.cerevoice_eng.CPRC_VOICE_LOAD_TYPE;
import com.cereproc.cerevoice_eng.SWIGTYPE_p_CPRCEN_engine;
import com.cereproc.cerevoice_eng.TtsEngineCallback;
import com.cereproc.cerevoice_eng.cerevoice_eng;
import de.dfki.reader.XMLParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cereproc {

  private SWIGTYPE_p_CPRCEN_engine eng;
  private AudioLine audioLine;
  private TtsEngineCallback ttsEngineCallback;

  private String javalibPath;
  private String voiceName;
  private String licenseName;
  private String rateStr;
  private Float rate;

  private int chan_handle;
  private int res;

  public static final Logger LOGGER = Logger.getLogger(Cereproc.class.getName());


  public Cereproc() {
    XMLParser.createDocument(null);
  }

  public Cereproc(String cereprocConfigPath) {
    XMLParser.createDocument(cereprocConfigPath);
  }

  public void setLibraryPath(String libraryPath) {

  }

  public void setVoiceName(String voiceNamePath) {

  }

  public void setLicenseName(String licenseNamePath) {
  }

  public void setLibraryPathFromXML(String tagNameForLibraryPath) {
    javalibPath = XMLParser.getVauleOf(tagNameForLibraryPath);
    try {
      addDir(javalibPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.loadLibrary("cerevoice_eng");
  }

  public void setVoiceNameFromXML(String tagNameForVoiceName) {
    voiceName = XMLParser.getVauleOf(tagNameForVoiceName);
  }

  public void setLicenseNameFromXML(String tagNameForLicenseName) {
    licenseName = XMLParser.getVauleOf(tagNameForLicenseName);
  }

  private void loadVoice() {
    LOGGER.log(Level.INFO, "creating CereVoice Engine");
    eng = cerevoice_eng.CPRCEN_engine_new();
    LOGGER.log(Level.INFO, "loading voice");
    res = cerevoice_eng.CPRCEN_engine_load_voice(eng, licenseName, "", voiceName,
        CPRC_VOICE_LOAD_TYPE.CPRC_VOICE_LOAD);
    if (res == 0) {
      LOGGER.log(Level.WARNING, "unable to load voice file " + voiceName);
    }
  }

  private void openDefaultSynthesisChannel() {
    LOGGER.log(Level.INFO, "opening default channel");
    chan_handle = cerevoice_eng.CPRCEN_engine_open_default_channel(eng);
    if (chan_handle == 0) {
      LOGGER.log(Level.WARNING, "unable to open default channel");
    }
  }

  private void setSampleRate() {
    rateStr = cerevoice_eng.CPRCEN_channel_get_voice_info(eng, chan_handle, "SAMPLE_RATE");
    LOGGER.log(Level.INFO, "channel has a sample rateStr of: "  + rateStr);
  }

  private void openAudioLineForOutput() {
    rate = new Float(rateStr);
    audioLine = new AudioLine(rate.floatValue());
    ttsEngineCallback = new TtsCallback(audioLine.line());
    ttsEngineCallback.SetCallback(eng, chan_handle);
  }

  public void buildCereVoice() {
    loadVoice();
    openDefaultSynthesisChannel();
    setSampleRate();
    openAudioLineForOutput();
  }

  public void speak(String text) {
    if (text != null) {
      try {
        byte[] utf8bytes = text.getBytes("UTF-8");
        cerevoice_eng.CPRCEN_engine_channel_speak(eng, chan_handle, text + "\n", utf8bytes.length + 1, 0);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Flush engine
    cerevoice_eng.CPRCEN_engine_channel_speak(eng, chan_handle, "", 0, 1);
    //################Überprüfe ob dieses Block auskommentiert werden kann##############
    // Flush any remaining audio
//    audioLine.flush();
//    ttsEngineCallback.ClearCallback(eng, chan_handle);
//    // Close the channel
//    cerevoice_eng.CPRCEN_engine_channel_close(eng, chan_handle);
//    // Delete the engine
//    cerevoice_eng.CPRCEN_engine_delete(eng);
    //##################################################################################
  }

  public void speakFromFile(String filePath) {
    try{
      // Open the text file
      FileReader fileReader = new FileReader(filePath);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String strLine;
      // Read file line-by-line to improve latency,
      // readLine strips line break so reattach it
      while ((strLine = bufferedReader.readLine()) != null)   {
        // Stream data to engine
        // Get UTF-8 byte length
        byte[] utf8bytes = strLine.getBytes("UTF-8");
        cerevoice_eng.CPRCEN_engine_channel_speak(eng, chan_handle, strLine + "\n", utf8bytes.length + 1, 0);
      }
      cerevoice_eng.CPRCEN_engine_channel_speak(eng, chan_handle, "", 0, 1);
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
    }
    // Flush any remaining audio
    audioLine.flush();
    ttsEngineCallback.ClearCallback(eng, chan_handle);
    // Close the channel
    cerevoice_eng.CPRCEN_engine_channel_close(eng, chan_handle);
    // Delete the engine
    cerevoice_eng.CPRCEN_engine_delete(eng);
  }

  private static void addDir(String s) throws IOException {
    try {
      // This enables the java.library.path to be modified at runtime
      // From a Sun engineer at http://forums.sun.com/thread.jspa?threadID=707176
      //
      Field field = ClassLoader.class.getDeclaredField("usr_paths");
      field.setAccessible(true);
      String[] paths = (String[])field.get(null);
      for (int i = 0; i < paths.length; i++) {
        if (s.equals(paths[i])) {
          return;
        }
      }
      String[] tmp = new String[paths.length+1];
      System.arraycopy(paths,0,tmp,0,paths.length);
      tmp[paths.length] = s;
      field.set(null,tmp);
      System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + s);
    } catch (IllegalAccessException e) {
      throw new IOException("Failed to get permissions to set library path");
    } catch (NoSuchFieldException e) {
      throw new IOException("Failed to get field handle to set library path");
    }
  }

  public TtsEngineCallback getTtsEngineCallback() {
    return ttsEngineCallback;
  }
}
