package fr.clxmdev.friends.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;
    private final String host, database, username, password;
    private final int port;

    public DatabaseManager(String host, String database, String username, String password, int port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public void connect() throws SQLException {
        if (connection != null && !connection.isClosed()) return;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&autoReconnect=true";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("[FriendsSQL] Connecté à la base de données !");
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("[FriendsSQL] Déconnecté de la base de données !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
