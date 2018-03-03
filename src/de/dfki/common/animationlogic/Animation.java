package de.dfki.common.animationlogic;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 16.07.2017.
 */
public abstract class Animation extends Thread {

  public Semaphore animationPartStartSemaphore = new Semaphore(0);
  public Semaphore animationStartSemaphore = new Semaphore(1);
  public ArrayList<AnimationContent> animationContents = new ArrayList<>();
  public Object parameter = "";
  public String ID;
  public String name = "";
  public String agentName;
  public boolean isBlocked = false;
  public int duration = -1;
}
