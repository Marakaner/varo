package net.marakaner.varo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TeamCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        /**
         * /team create [Name] [First] [Second] [Char]
         * /team delete [Name]
         * /team list
         * /team info [Name]
         *
         */

        if(args.length == 0) {

        } else if(args.length == 1) {
            if(args[0].equalsIgnoreCase("list")) {

            }
        } else if(args.length == 5) {

        }

        return true;
    }
}
