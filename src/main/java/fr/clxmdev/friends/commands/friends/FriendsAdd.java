package fr.clxmdev.friends.commands.friends;

import fr.clxmdev.friends.Main;
import fr.clxmdev.friends.managers.SubCommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FriendsAdd implements SubCommandsManager {

    private final Main plugin;

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "Permet d'ajouter des joueurs à sa liste d'amis.";
    }

    @Override
    public String getUsage() {
        return "/friends add <joueur>";
    }

    public FriendsAdd(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("§7[§eFriends§7] Vous devez utiliser §e" + getUsage());
            return;
        }

        Player friend = Bukkit.getPlayer(args[1]);
        if (friend == null) {
            player.sendMessage("§7[§eFriends§7] L'utilisateur §e" + args[1] + " §7n'est pas en ligne !");
            return;
        }

        if(friend.equals(player)) {
           player.sendMessage("§7[§eFriends§7] Tu ne peux pas t'ajouter toi-même !");
        }

        /* AJOUT DE L'AMI */
        // plugin.getFriendsManager().addFriend(player.getUniqueId(), friend.getUniqueId());
        player.sendMessage("§7[§eFriends§7] Votre demande d'ami à §e" + friend.getDisplayName() + " §7à été envoyé !");
        friend.sendMessage("§7[§eFriends§7] Vous avez reçu une demande d'ami de §e" + friend.getDisplayName() + " §7, faites §e/friends accept " + player.getName() + " pour accepter sa demande d'ami.");

        if(plugin.getFriendRequest().hasRequest(friend, player)) {
            player.sendMessage("§7[§eFriends§7] Une demande d'ami vers §e" + player.getName() + " §7est déjà en cours...");
        }

        plugin.getFriendRequest().sendRequest(player, friend);
    }
}
