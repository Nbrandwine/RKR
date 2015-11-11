package net.link404.RKR;
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