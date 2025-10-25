package fr.clxmdev.friends;

import fr.clxmdev.friends.commands.FriendsHelp;
import fr.clxmdev.friends.managers.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private ConfigManager databaseFile;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        databaseFile = new ConfigManager(this, "database.yml");

        System.out.println("[FuncraftFriends] Le module d'amitié est activé !");

        getCommand("friends").setExecutor(new FriendsHelp());
    }

    @Override
    public void onDisable() {
        System.out.println("[FuncraftFriends] Le module d'amitié est désactivé !");
    }

    /* GETTERS DES CONFIGS */
    public FileConfiguration getDatabaseFile() {
        return databaseFile.getConfig();
    }
}