package fr.clxmdev.friends.commands.friends;

import fr.clxmdev.friends.Main;
import fr.clxmdev.friends.managers.SubCommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FriendsDeny implements SubCommandsManager {

    private final Main plugin;

    @Override
    public String getName() {
        return "deny";
    }

    @Override
    public String getDescription() {
        return "Permet de refuser la demande d'ami d'un joueur.";
    }

    @Override
    public String getUsage() {
        return "/friends deny <joueur>";
    }

    public FriendsDeny(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Player player, String[] args) {
        Player p = Bukkit.getPlayer(args[1]);

        if (p == null) {
            player.sendMessage("§7[§eFriends§7] Le joueur §e" + args[1] + " §7n’est pas en ligne !");
            return;
        }

        if(!plugin.getFriendRequest().hasRequest(player, p)) {
            player.sendMessage("§7[§eFriends§7] Aucune demande d'ami venant de §e" + p.getName() + "§7.");
        }

        plugin.getFriendRequest().removeRequest(player, p);

        player.sendMessage("§7[§eFriends§7] Vous venez de refuser la demande d'ami de §e" + p.getName() + "§7.");

    }
}
