package fr.clxmdev.friends.managers;

import org.bukkit.entity.Player;

import java.util.*;

public class FriendRequest {

    private final Map<UUID, Set<UUID>> friendRequests = new HashMap<>();

    /* Envoie une demande d’ami */
    public void sendRequest(Player sender, Player target) {
        friendRequests.computeIfAbsent(target.getUniqueId(), k -> new HashSet<>()).add(sender.getUniqueId());
    }

    /* Vérifie si une demande existe */
    public boolean hasRequest(Player target, Player sender) {
        return friendRequests.containsKey(target.getUniqueId()) &&
                friendRequests.get(target.getUniqueId()).contains(sender.getUniqueId());
    }

    /* Supprime la demande (après acceptation ou refus) */
    public void removeRequest(Player target, Player sender) {
        Set<UUID> requests = friendRequests.get(target.getUniqueId());
        if (requests != null) {
            requests.remove(sender.getUniqueId());
            if (requests.isEmpty()) {
                friendRequests.remove(target.getUniqueId());
            }
        }
    }
}
