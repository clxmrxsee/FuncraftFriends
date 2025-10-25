package fr.clxmdev.friends.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigManager {

    private final JavaPlugin plugin;
    private final String fileName;
    private File file;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;

        loadConfigFile();
    }

    private void loadConfigFile() {
        file = new File(plugin.getDataFolder(), fileName);

        if(!file.exists()) {
            try (InputStream input = plugin.getResource(fileName)) {
                if(input != null) {
                    Files.copy(input, file.toPath());
                } else {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
