package net.marakaner.varo.listener;

import net.marakaner.varo.Varo;
import net.marakaner.varo.rank.Rank;
import net.marakaner.varo.team.Team;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        Rank rank = Varo.getInstance().getRankManager().getRank(player.getUniqueId());

        if(event.getMessage().contains("%")) {
            event.getMessage().replace("%", "%%");
        }

        switch (rank) {
            case ADMIN:
                event.setMessage("§4Admin §8┃ §4" + player.getName() + " §8» §7" + event.getMessage());
                break;
            case TEAM:

                Team team = Varo.getInstance().getTeamManager().getTeam(player.getUniqueId());


                break;
            case UNREGISTERED:
                event.setMessage("§7KEIN TEAM §8┃ §7" + player.getName() + " §8» §7" + event.getMessage());
        }
    }

}
