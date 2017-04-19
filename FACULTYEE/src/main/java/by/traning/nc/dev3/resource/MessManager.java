package by.traning.nc.dev3.resource;

import java.util.ResourceBundle;

public class MessManager {
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

  // класс извлекает информацию из файла messages. properties
  private MessManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}