package net.link404.RKR;
import net.link404.RKR.Commands.CommandRKR;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private static Main plugin;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		this.getCommand("rkr").setExecutor(new CommandRKR());
		this.getCommand("rkr help").setExecutor(new CommandRKR());
		this.getCommand("rkr hello").setExecutor(new CommandRKR());
		this.getCommand("rkr set").setExecutor(new CommandRKR());		
	}
	
	@Override
	public void onDisable()
	{
		plugin = null;
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) 
	{
	  for (Listener listener : listeners) 
	  {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	  }	
	}
	
	public static Plugin getPlug() 
	{
		return plugin;
	}
}
