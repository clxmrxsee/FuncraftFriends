package fr.clxmdev.friends.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FriendsHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[Friends] Vous ne pouvez pas utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("friends")) {
            if(args[0].equals("help")) {
                player.sendMessage("§e-----------------------------------\n§e- /friends - §7Permet d'ouvrir la liste des amis.\n§e- /friends add - §7Permet d'ajouter un joueur dans la liste d'amis.\n§e- /friends remove - §7Permet de supprimer un joueur de la liste d'amis.\n§e- /friends status - §7Permet de changer son type d'état comme connecté ou invisible.\n\n§e-----------------------------------");
                return true;
            }
        }

        return false;
    }
}
