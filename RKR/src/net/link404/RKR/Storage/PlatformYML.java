package net.link404.RKR.Storage;

import java.io.File;
import java.io.IOException;

import net.link404.RKR.Main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

// Platform YML is the storage option for YML configurations.
// This should be used if the preferred option is YML or a SQL option is not found.

public class PlatformYML 
{
	 static Plugin pl = Main.getPlug();							// Plugin
	
	 static String fileName = "NOT-SET-IF-U-C-THIS";		// File Name Default
	
	 File cYml = new File(pl.getDataFolder() + "/" + fileName + ".yml");		// Path
	 FileConfiguration cfg = YamlConfiguration.loadConfiguration(cYml);	// That
	
	public void setConfigName(String cfgName)
	{
		fileName = cfgName;
	}
	
	public FileConfiguration getFileConfig()
	{
		return cfg;
	}
	
	public void BuildFiles()
	{
		try
		{
			cfg.save(cYml);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void save(FileConfiguration yConfig)
	{
		try
		{
			yConfig.save(cYml);
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void setValue(String PATH, String VALUE)
	{
		cfg.set(PATH, VALUE);
		save(cfg);
	}
	public void setValue(String PATH, int VALUE)
	{
		cfg.set(PATH, VALUE);
		save(cfg);
	}
	
	public int getValueInt(String PATH)
	{
		return cfg.getInt(PATH);
	}
	
	public String getValueStr(String PATH)
	{
		return cfg.getString(PATH);
	}
	
}
