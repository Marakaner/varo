package net.marakaner.varo.team;

import net.marakaner.varo.utilities.SimpleLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class Team {

    private String name;
    private HashMap<UUID, Boolean> player;
    private int number;
    private long time;

    private char color;

    public Team(String name, UUID playerOne, UUID playerTwo, char color, int number) {
        this.player = new HashMap<UUID, Boolean>();

        this.name = name;
        this.player.put(playerOne, true);
        this.player.put(playerTwo, true);
        this.color = color;
        this.number = number;
    }

    public char getColor() {
        return color;
    }

    public HashMap<UUID, Boolean> getPlayer() {
        return player;
    }

    public boolean isAlive(UUID player) {
        return this.player.get(player);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
