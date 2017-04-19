package by.traning.nc.dev3.resource;

import java.util.ResourceBundle;

public class ConfManager {
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  // класс извлекает информацию из файла config. properties
  private ConfManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}