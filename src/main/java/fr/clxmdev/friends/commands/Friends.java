package fr.clxmdev.friends.commands;

import fr.clxmdev.friends.Main;
import fr.clxmdev.friends.commands.friends.FriendsAdd;
import fr.clxmdev.friends.commands.friends.FriendsHelp;
import fr.clxmdev.friends.managers.SubCommandsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Friends implements CommandExecutor {

    private final Main plugin;
    private final List<SubCommandsManager> SubCommandsFriends = new ArrayList<>();

    public Friends(Main plugin) {
        this.plugin = plugin;

        SubCommandsFriends.add(new FriendsHelp());
        SubCommandsFriends.add(new FriendsAdd(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[Friends] Vous ne pouvez pas utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§7Utilisez §e/friends help §7pour voir les commandes disponibles.");
            return true;
        }

        String cmdName = args[0].toLowerCase();

        for ( SubCommandsManager subcmd : SubCommandsFriends) {
            if(subcmd.getName().equalsIgnoreCase(cmdName)) {
                subcmd.execute(player, args);
                return true;
            }
        }

        return true;
    }
}
