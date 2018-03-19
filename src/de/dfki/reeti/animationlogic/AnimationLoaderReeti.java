/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.common.agents.Agent;
import de.dfki.reeti.Reeti;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Beka Aptsiauri
 */
public class AnimationLoaderReeti {

  private final static String ANIMATIONPATH = "de.dfki.reeti";
  private static final Set<String> animationPackageNames = new HashSet<>(
      Arrays.asList("head", "face", "gesture", "environment", "posture"));
  private static AnimationLoaderReeti sInstance = null;
  private static long sID = 0;

  private AnimationLoaderReeti() {
  }

  public static AnimationLoaderReeti getInstance() {
    if (sInstance == null) {
      sInstance = new AnimationLoaderReeti();
    }

    return sInstance;
  }

  public String getNextID() {
    sID++;
    return "a" + sID;
  }

  private String getAnimationClasspath(String animationName) {
    String classPath = "";

    for (String s : animationPackageNames) {
      classPath = ANIMATIONPATH + ".animation." + s + "." + animationName;

      try {
        Class.forName(classPath);
        break;
      } catch (ClassNotFoundException ex) {
        //Wenn die erstellte classPath ignoriere und mache for-Schleife weiter
      }
    }
    return classPath;
  }

  private String getEventAnimationClasspath(String name) {
    String classPath = "";

    for (String s : animationPackageNames) {
      classPath = ANIMATIONPATH + ".animation." + s + ".event." + name;

      try {
        Class.forName(classPath);
        break;
      } catch (ClassNotFoundException ex) {
        //nothing
      }
    }
    return classPath;
  }

  public AnimationReeti loadAnimation(Agent sm, String animationName, int duration, boolean block,
      HashMap<String, String> extraParams) {
    AnimationReeti a = null;

    String cp = getAnimationClasspath(animationName);
    try {
      Class c = Class.forName(cp);
      Constructor[] constructors = c.getConstructors();
      for (Constructor con : constructors) {
        Class[] params = con.getParameterTypes();
        if (params.length == 3 && extraParams.size() == 0) {
          if (params[0].getSimpleName().equalsIgnoreCase("reeti")
              && params[1].getSimpleName().equalsIgnoreCase("int")
              && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
            a = (AnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
          }
        } else if (params.length == 4) {
          if (params[0].getSimpleName().equalsIgnoreCase("reeti")
              && params[1].getSimpleName().equalsIgnoreCase("int")
              && params[2].getSimpleName().equalsIgnoreCase("boolean")
              && params[3].getSimpleName().equalsIgnoreCase("hashMap")) {
            a = (AnimationReeti) c.getDeclaredConstructor(params)
                .newInstance(sm, duration, block, extraParams);
          }
        }

      }
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      ((Reeti) sm).logger.severe("AnimationInterface \"" + animationName + "\" cannot be found in " + cp);
    }

    if (a != null) {
      a.ID = getNextID();
    }
    return a;
  }

  public AnimationReeti loadAnimation(Agent sm, String name, int duration, boolean block) {
    AnimationReeti animationReeti = null;

    String classPath = getAnimationClasspath(name);
    try {
      Class animationClass = Class.forName(classPath);
      Constructor[] constructors = animationClass.getConstructors();
      for (Constructor con : constructors) {
        Class[] params = con.getParameterTypes();

        if (params.length == 3) {
          if (params[0].getSimpleName().equalsIgnoreCase("reeti")
              && params[1].getSimpleName().equalsIgnoreCase("int")
              && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
            animationReeti = (AnimationReeti) animationClass.getDeclaredConstructor(params).newInstance(sm, duration, block);
          }
        }

      }
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      ((Reeti) sm).logger.severe("AnimationInterface \"" + name + "\" cannot be found in " + classPath);
    }

    if (animationReeti != null) {
      animationReeti.ID = getNextID();
    }

    return animationReeti;
  }

  public AnimationReeti loadAnimation(Agent sm, String name, int frequent, int pos,
      boolean block) {
    AnimationReeti a = null;

    String cp = getAnimationClasspath(name);
    try {
      Class c = Class.forName(cp);
      Constructor[] constructors = c.getConstructors();
      for (Constructor con : constructors) {
        Class[] params = con.getParameterTypes();

        if (params.length == 4) {
          if (params[0].getSimpleName().equalsIgnoreCase("reeti")
              && params[1].getSimpleName().equalsIgnoreCase("int")
              && params[2].getSimpleName().equalsIgnoreCase("int")
              && params[3].getSimpleName().equalsIgnoreCase("boolean")) {
            a = (AnimationReeti) c.getDeclaredConstructor(params)
                .newInstance(sm, frequent, pos, block);
          }
        }

      }
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      ((Reeti) sm).logger.severe("AnimationInterface \"" + name + "\" cannot be found in " + cp);
    }

    if (a != null) {
      a.ID = getNextID();
    }
    return a;
  }

  public EventAnimationReeti loadEventAnimation(Agent sm, String name, int duration,
      boolean block) {
    EventAnimationReeti a = null;

    String cp = getEventAnimationClasspath(name);

    try {
      Class c = Class.forName(cp);

      Constructor[] constructors = c.getConstructors();
      for (Constructor con : constructors) {
        Class[] params = con.getParameterTypes();

        if (params.length == 3) {
          if (params[0].getSimpleName().equalsIgnoreCase("reeti")
              && params[1].getSimpleName().equalsIgnoreCase("int")
              && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
            a = (EventAnimationReeti) c.getDeclaredConstructor(params)
                .newInstance(sm, duration, block);
          }
        }
      }
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      ((Reeti) sm).logger.severe("AnimationInterface \"" + name + "\" cannot be found in " + cp);
    }

    a.ID = getNextID();

    return a;
  }
}
