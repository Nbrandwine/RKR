package net.link404.RKR.Storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import net.link404.RKR.Main;

import org.bukkit.plugin.Plugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlatformJSON 
{
	private Plugin plugin = Main.getPlug();
	
	public String pluginFolder = plugin.getDataFolder().getAbsolutePath();
	
	/// WRITE AN INDEX TO A JSON PATH
	/// PLEASE LABEL ALL WRITTEN JSON FILES WHEN APPLICABLE
	@SuppressWarnings("unchecked") // Why do I feel like this is going to be a pain in the ass later?
	public void writeJSON(String fileName, String subPath, String OBJECT, String VALUE)
	{
		JSONObject jso = new JSONObject();
		
		jso.put(OBJECT, VALUE);
		
		try {
			File f = new File(pluginFolder + File.separator + subPath + fileName + ".json");
			f.mkdirs();
			
			if(!f.exists())
				f.createNewFile();
			
			FileWriter fw = new FileWriter(f);
			fw.write(jso.toJSONString());
			fw.flush();
			fw.close();
			
		}catch (Exception e) 
		{
			System.out.println("ERROR: Could not write to json file (Failed to write params " + OBJECT + ", " + VALUE + ":\n" + e.getMessage() + "\n" + e.getStackTrace());
		}
		
	}

	/// READ AN INDEX TO A JSON PATH
	//// ONLY READ FROM WRITTEN JSON FILES
	public String parseJSON(String fileName, String subPath, String OBJECT)
	{
		String v = null;
		try
		{
			JSONParser par = new JSONParser();
			
			File f = new File(pluginFolder + File.separator + subPath + fileName + ".json");
			Object o = par.parse(new FileReader(f));
			
			JSONObject jso = (JSONObject) o;
			
			v = (String) jso.get(o);
		} catch(Exception e)
		{
			System.out.println("ERROR: Could not write to json file (Failed to read params " + OBJECT + ":\n" + e.getMessage() + "\n" + e.getStackTrace());
		}
		return v;
	}

}
