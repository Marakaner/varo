package net.marakaner.varo.utilities;

import net.marakaner.varo.Varo;
import org.bukkit.Bukkit;

public class TimeUtil {

    private int timer;

    public TimeUtil() {
        this.timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Varo.getInstance(), () -> {


        }, 0, 20);
    }

}
