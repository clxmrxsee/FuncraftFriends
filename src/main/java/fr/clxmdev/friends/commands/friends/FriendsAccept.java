package fr.clxmdev.friends.commands.friends;

import fr.clxmdev.friends.Main;
import fr.clxmdev.friends.managers.SubCommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FriendsAccept implements SubCommandsManager {

    private final Main plugin;

    @Override
    public String getName() {
        return "accept";
    }

    @Override
    public String getDescription() {
        return "Cette commande permet d'accepter la demande d'ami d'un joueur.";
    }

    @Override
    public String getUsage() {
        return "/friends accept <joueur>";
    }

    public FriendsAccept(Main plugin) {
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

        player.sendMessage("§7[§eFriends§7] Vous êtes désormais ami avec §e" + p.getName() + "§7.");
        p.sendMessage("§7[§eFriends§7] Vous êtes désormais ami avec §e" + player.getName() + "§7.");

    }
}
