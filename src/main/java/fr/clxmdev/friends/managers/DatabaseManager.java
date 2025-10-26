package fr.clxmdev.friends.managers;

import fr.clxmdev.friends.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final Main plugin;
    private Connection connection;

    public DatabaseManager(Main plugin) {
        this.plugin = plugin;
    }

    public void connect() throws SQLException, ClassNotFoundException {

        String host = "localhost";
        String database = "funcraft";
        String username = "root";
        String password = "";
        int port = 3306;

        if (connection != null && !connection.isClosed()) return;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&characterEncoding=utf8";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("[FriendsSQL] Connecté à la base de données !");
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("[FriendsSQL] Déconnecté de la base de données !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
