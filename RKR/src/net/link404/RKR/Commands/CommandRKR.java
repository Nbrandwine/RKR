package net.link404.RKR.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRKR implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd,String commandLabel, String[] args) 
	{
					if (sender instanceof Player)
					{
						Player p = (Player) sender;
						
						if (commandLabel.equalsIgnoreCase("rkr")) // Base Command
						{
							if(args[0] == "hello")
							{
								if(p.hasPermission("rkr.rename-me") || p.isOp())
								{
									// TODO:
									// Fix this command to be something useful.
									p.sendMessage(ChatColor.GREEN + "Hello, " + p.getName() + "!");
								}
							}
							else if(args[0] == "set")
							{
								if(p.hasPermission("rkr.set") || p.isOp())
								{
									// TODO:
									// Communicate with PlatformConfigBuilder to determine <SQL/FF/YML>
									// Collect command values from above, then talk to Platform<SQL/FF/YML>
									// Store values and alert user of such actions.
								}
							}
							else
							{
									// The command that basically says "You fucked up with your commands.".
								p.sendMessage(ChatColor.DARK_AQUA + "-=====<" + ChatColor.AQUA + "Rival Kingdoms Reloaded" + ChatColor.DARK_AQUA + " >=====-");
								p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Rival Kingdoms Reloaded");
								p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Version 1.0 (DEV)");
								p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Rival Kingdoms Reloaded is a plugin designed to provide infrastructure for the server.");
								p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Developers");
								p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "Stryker_");
								p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "EUFlux");
								p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "Zxios");
								p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "This plugin is for administrators only.");
							}
							
						}
					}

	return true;
	} // END-ONCOMMAND

} // END-CLASS