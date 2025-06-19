package io.github.ink_song.tools.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CustomCommandRegistry {
  Properties properties = new Properties();
  private final Path configDirectory;
  private final Path propertiesFile;

  public CustomCommandRegistry(String configFolder, String propertiesFile) {
    this.configDirectory = Paths.get(configFolder);
    this.propertiesFile = configDirectory.resolve(propertiesFile);
  }

  public void initialize() throws IOException {
    if (Files.notExists(configDirectory)) {
      Files.createDirectories(configDirectory);
    }

    if (Files.notExists(propertiesFile)) {
      try (OutputStream outputStream = Files.newOutputStream(propertiesFile)) {
        properties.setProperty("#", "User-defined command shortcuts");
        properties.store(outputStream, "#shortcuts.properties");
      }
    }

    try (InputStream inputStream = Files.newInputStream(propertiesFile)) {
      properties.load(inputStream);
    }
  }

  public String get(String key){
    return properties.getProperty(key);
  }

  public void register(String key, String value) throws IOException {
    properties.setProperty(key, value);
    try (OutputStream outputStream = Files.newOutputStream(propertiesFile)) {
      properties.store(outputStream, "commands.properties");
    }
  }
  public boolean exists(String key){
    return properties.containsKey(key);
  }

  public void clear() throws IOException {
    properties.clear();
    try (OutputStream outputStream = Files.newOutputStream(propertiesFile)) {
      properties.store(outputStream, "commands.properties");
    }
  }
}
