package net.marakaner.varo.tablist;

import net.marakaner.varo.Varo;
import net.marakaner.varo.team.Team;
import net.marakaner.varo.team.TeamManager;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;

import java.util.UUID;

public class TablistManager {

    public void setTablistPrefix(Player player, Player receiver) {

        Team team = Varo.getInstance().getTeamManager().getTeam(player.getUniqueId());
        String teamName;
        String prefix;

        if(team == null) {
            teamName = "0";
            prefix = "§7";
        } else {
            teamName = String.valueOf(team.getNumber());
            prefix = "§" + String.valueOf(team.getColor()) + " §8┃ §" + String.valueOf(team.getColor());
        }

        ScoreboardTeam scoreboardTeam = new ScoreboardTeam(new Scoreboard(), teamName + UUID.randomUUID().toString().substring(0, 10));

        scoreboardTeam.setPrefix(prefix);
        scoreboardTeam.getPlayerNameSet().add(player.getName());

        PacketPlayOutScoreboardTeam packet = new PacketPlayOutScoreboardTeam(scoreboardTeam, 0);
        updateForOne(packet, receiver);
    }

    public void setTablistPrefix(Player player) {

        Team team = Varo.getInstance().getTeamManager().getTeam(player.getUniqueId());
        String teamName;
        String prefix;

        if(team == null) {
            teamName = "0";
            prefix = "§7";
        } else {
            teamName = String.valueOf(team.getNumber());
            prefix = "§" + String.valueOf(team.getColor()) + " §8┃ §" + String.valueOf(team.getColor());
        }

        ScoreboardTeam scoreboardTeam = new ScoreboardTeam(new Scoreboard(), teamName + UUID.randomUUID().toString().substring(0, 10));

        scoreboardTeam.setPrefix(prefix);
        scoreboardTeam.getPlayerNameSet().add(player.getName());

        PacketPlayOutScoreboardTeam packet = new PacketPlayOutScoreboardTeam(scoreboardTeam, 0);
        updateForAll(packet);
    }

    private void updateForAll(Packet packet) {
        for(Player all : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(packet);
        }
    }

    private void updateForOne(Packet packet, Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}

