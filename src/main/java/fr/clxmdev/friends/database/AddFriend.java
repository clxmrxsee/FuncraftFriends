package fr.clxmdev.friends.database;

import fr.clxmdev.friends.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class AddFriend {

    private final Main plugin;

    public AddFriend(Main plugin) {
        this.plugin = plugin;
    }

    private String statement = "INSERT INTO friends (player, friend, date, statut) VALUES (?, ?, ?)";

    public void addFriend(UUID player, UUID friend) throws SQLException {
        try (PreparedStatement ps = plugin.getDb().getConnection().prepareStatement(statement)) {
            ps.setString(1, player.toString());
            ps.setString(2, friend.toString());
            ps.setString(3, String.valueOf(LocalDate.now()));
            ps.setString(4, "pending");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
