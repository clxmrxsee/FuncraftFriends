package fr.clxmdev.friends;

import fr.clxmdev.friends.commands.Friends;
import fr.clxmdev.friends.database.FriendsManager;
import fr.clxmdev.friends.managers.ConfigManager;
import fr.clxmdev.friends.managers.DatabaseManager;
import fr.clxmdev.friends.managers.FriendRequest;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin {

    public static Main plugin;
    private ConfigManager databaseFile;
    private DatabaseManager db;

    private FriendsManager friendsManager;
    private FriendRequest friendRequest;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        databaseFile = new ConfigManager(this, "database.yml");

        System.out.println("[FuncraftFriends] Le module d'amitié est activé !");

        /* LES COMMANDES DU SYSTEME D'AMIS */
        getCommand("friends").setExecutor(new Friends(this));

        /* SETUP LA DB */
        db = new DatabaseManager(this);

        try {
            db.connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("[Friends] Impossible de se connecter à la base de données.");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        /* ON GERE LES AMIS */
        friendsManager = new FriendsManager(this);
        friendRequest = new FriendRequest();
    }

    @Override
    public void onDisable() {
        System.out.println("[FuncraftFriends] Le module d'amitié est désactivé !");

        db.disconnect();
    }

    /* GETTERS DES CONFIGS */
    public FileConfiguration getDatabaseFile() {
        return databaseFile.getConfig();
    }

    /* GETTER DE LA DATABASE */
    public DatabaseManager getDb() {
        return db;
    }

    /* ACCEDER A MA CLASS MAIN */
    public static Main getPlugin() {
        return plugin;
    }

    /* GETTER DU FRIENDS MANAGER */
    public FriendsManager getFriendsManager() {
        return friendsManager;
    }

    /* GETTER DES REQUETES D'AMIS */
    public FriendRequest getFriendRequest() {
        return friendRequest;
    }
}