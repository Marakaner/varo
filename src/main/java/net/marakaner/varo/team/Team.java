package net.marakaner.varo.team;

import net.marakaner.varo.utilities.SimpleLocation;
import org.bukkit.entity.Player;

import java.util.*;

public class Team {

    private String name;
    private List<UUID> player;
    private Map<UUID, SimpleLocation> locationMap;

    private char color;

    public Team(String name, UUID playerOne, UUID playerTwo, char color) {
        this.player = new ArrayList<>();
        this.locationMap = new HashMap<>();

        this.name = name;
        this.player.add(playerOne);
        this.player.add(playerTwo);
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public List<UUID> getPlayer() {
        return player;
    }

    public Map<UUID, SimpleLocation> getLocationMap() {
        return locationMap;
    }

    public String getName() {
        return name;
    }
}
