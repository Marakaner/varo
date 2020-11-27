package net.marakaner.varo.listener;

import net.marakaner.varo.Varo;
import net.marakaner.varo.team.Team;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {

        Player player = event.getPlayer();

        Team team = Varo.getInstance().getTeamManager().getTeam(player.getUniqueId());

        if(team != null) {
            if(team.isAlive(player.getUniqueId())) {
                long time = team.getTime();

                if(time < System.currentTimeMillis()) {

                } else {

                }
            } else {
                event.setKickMessage("§3Varo \n\n§cDu bist bereits ausgeschieden§8!");
            }
        }

    }

}
