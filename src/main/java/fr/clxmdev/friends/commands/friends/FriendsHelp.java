package fr.clxmdev.friends.commands.friends;

import fr.clxmdev.friends.Main;
import fr.clxmdev.friends.managers.SubCommandsManager;
import org.bukkit.entity.Player;

public class FriendsHelp implements SubCommandsManager {

    private Main plugin;

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Affiche la liste des commandes disponibles dans le système d'amis.";
    }

    @Override
    public String getUsage() {
        return "/friends help";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("§e-----------------------------------\n§e- /friends - §7Permet d'ouvrir la liste des amis.\n§e- /friends add <joueur> - §7Permet d'ajouter un joueur dans la liste d'amis.\n§e- /friends remove <joueur> - §7Permet de supprimer un joueur de la liste d'amis.\n§e- /friends status - §7Permet de changer son type d'état comme connecté ou invisible.\n§e- /friends accept <joueur> - §7Permet d'accepter la demande d'ami d'un joueur.\n§e- /friends deny <joueur> - §7Permet de refuser la demande d'ami d'un joueur.\n§e-----------------------------------");
    }
}
