package net.marakaner.varo.team;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TeamManager {

    private Map<String, Team> teamMap = new HashMap<>();

    public void createTeam(String name, UUID playerOne, UUID playerTwo, char color) {

        Team team = new Team(name, playerOne, playerTwo, color, this.teamMap.size());

        this.teamMap.put(name.toLowerCase(), team);
    }

    public Team getTeam(String team) {
        return this.teamMap.getOrDefault(team.toLowerCase(), null);
    }

    public Team getTeam(UUID player) {
        for(Team team : this.teamMap.values()) {
            if(team.getPlayer().containsKey(player)) {
                return team;
            }
        }
        return null;
    }

    public Map<String, Team> getTeams() {
        return teamMap;
    }

    public void saveTeams() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileWriter = null;

        try {
            gson.toJson(teamMap, fileWriter = new FileWriter("/plugins/Varo/Teams.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
