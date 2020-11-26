package net.marakaner.varo.rank;

import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RankManager {

    private Map<UUID, Rank> ranks = new HashMap<>();

    public void registerPlayer(UUID player, Rank rank) {
        this.ranks.put(player, rank);
    }

    public boolean isRegistered(UUID player) {
        return this.ranks.containsKey(player);
    }

    public Rank getRank(UUID player) {
        return this.ranks.getOrDefault(player, null);
    }

    public void setRank(UUID player, Rank rank) {
        if (this.ranks.containsKey(player)) {
            this.ranks.replace(player, rank);
        } else {
            this.ranks.put(player, rank);
        }
    }

}
