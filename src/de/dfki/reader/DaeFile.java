package de.dfki.reader;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import java.net.URL;
import javafx.scene.Group;
import javafx.scene.shape.MeshView;

public class DaeFile {

  public Object read(String path) {
    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource(path);

    importer.read(url);
    return importer.getImport()[0];
  }
}
