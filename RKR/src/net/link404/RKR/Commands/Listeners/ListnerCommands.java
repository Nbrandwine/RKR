package net.link404.RKR.Commands.Listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListnerCommands {

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (commandLabel.equalsIgnoreCase("rkr")) // Base Command
			{
				sender.sendMessage("Rival Kingdom Reloaded");
				sender.sendMessage("Version 1.0");
				sender.sendMessage("Rival Kingdom Reloaded is an RPG type plugin designed for an attack and defend type gamemode with advance mechanics to improve gameplay");
				sender.sendMessage("Developers:");
				sender.sendMessage("	-Stryker_");
				sender.sendMessage("	-EUFlux");
				if (args[0] == "hi") {
					sender.sendMessage("Hey!");
				}
			}
			return true;
		}
		return false;
	}
}