/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.animationlogic.reeti;

import de.dfki.agent.Agent;
import de.dfki.agent.Reeti;
import de.dfki.util.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Beka Aptsiauri
 */
public class AnimationLoaderReeti {

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

  private String getAnimationClasspath(String animationName) {
    String classPath = "";

    for (String s : Constants.ANIMATION_PACKAGE_NAMES) {
      classPath = Constants.BASE_ANIMATIONPATH + "." + s + "." + animationName;

      try {
        Class.forName(classPath);
        break;
      } catch (ClassNotFoundException ex) {
        //Wenn die erstellte classPath nicht existiert ignoriere und mache for-Schleife weiter
      }
    }
    return classPath;
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

    return a;
  }
}
