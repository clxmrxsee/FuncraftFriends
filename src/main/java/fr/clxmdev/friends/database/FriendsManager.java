package fr.clxmdev.friends.database;

import fr.clxmdev.friends.Main;

import java.sql.SQLException;
import java.util.UUID;

public class FriendsManager {

    private final Main plugin;
    private final AddFriend addFriend;

    public FriendsManager(Main plugin) {
        this.plugin = plugin;
        this.addFriend = new AddFriend(plugin);
    }

    public void addFriend(UUID player, UUID friend) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                addFriend.addFriend(player, friend);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
