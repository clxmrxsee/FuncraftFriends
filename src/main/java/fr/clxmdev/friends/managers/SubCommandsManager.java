package fr.clxmdev.friends.managers;

import org.bukkit.entity.Player;

public interface SubCommandsManager {

    String getName();
    String getDescription();
    String getUsage();

    void execute(Player player, String[] args);
}
