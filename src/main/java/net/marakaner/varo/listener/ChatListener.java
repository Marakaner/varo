package net.marakaner.varo.listener;

import net.marakaner.varo.Varo;
import net.marakaner.varo.team.Team;
import net.marakaner.varo.team.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if(event.getMessage().contains("%")) {
            event.getMessage().replace("%", "%%");
        }

        Team team = Varo.getInstance().getTeamManager().getTeam(player.getUniqueId());

        if(team == null) {
            event.setMessage("§7KEIN TEAM §8┃ §7" + player.getName() + " §8» §7" + event.getMessage());
        } else {
            ChatColor chatColor = ChatColor.getByChar(team.getColor());

            event.setMessage(chatColor + team.getName() + " §8┃ " + chatColor + player.getName() + " §8» §7" + event.getMessage());
        }
    }

}
