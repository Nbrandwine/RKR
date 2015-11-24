package net.link404.RKR.Commands;
 
import net.link404.RKR.Storage.PlatformYML;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
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
            if(args.length > 0)
            {
             if(args[0].equalsIgnoreCase("hello"))
             {
               if(p.hasPermission("rkr.rename-me") || p.isOp())
               {
                  // TODO:
                  // Fix this command to be something useful.
                  p.sendMessage(ChatColor.GREEN + "Hello, " + p.getName() + "!");
               }
               return true;
             } // End of "Hello"
            
             else if(args[0].equalsIgnoreCase("set"))
             {
                if(p.hasPermission("rkr.set") || p.isOp())
                {
                	// R k r:  <set>(0) <team>(1) <name>(2+=)
                	if(args.length >= 2)
                	{
                    	Location lc = p.getLocation();
                    	String Collection = "";
                		PlatformYML sp = new PlatformYML();
                		int qwe = 0;
                		
                		for(int i = 2; i < args.length; i++)
                		{
                			Collection = Collection + args[i] + " ";
                		}
                		
                		Collection = Collection.replaceAll("\\s+$", "");
                		
                		String snv = args[2].toString();
                		snv.substring(0, 3);
                		
                		
                		// deprecated 
                		String saveName = String.valueOf(snv + "_" + String.valueOf(lc.getBlockX()) + "-" +
                				String.valueOf(lc.getBlockY()) + "-" + String.valueOf(lc.getBlockZ()));
                		
                		sp.setConfigName("blockList");
                		
                		if(args[1] == "RED")
                		{
                			p.getWorld().getBlockAt(lc).setType(Material.REDSTONE_BLOCK);
                			qwe = 1;
                    		
                		} else if(args[1] == "BLUE")
                		{
                			p.getWorld().getBlockAt(lc).setType(Material.LAPIS_BLOCK);
                			qwe = 2;
                    		
                		}else if(args[1] == "NEU")
                		{
                			p.getWorld().getBlockAt(lc).setType(Material.IRON_BLOCK);
                			qwe = 3;
                    		
                		}
                		else
                		{
                			qwe = 0;
                			p.sendMessage(ChatColor.RED + "Failed to place block at position. Acceptable args are 'RED', 'BLUE', or 'NEU'.");
                		}
                		
                		try{
                			sp.setConfigName("blockList");
                    		sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.Team", args[1]);
                    		sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.Name", Collection);
                    		sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.Coordinates.X", String.valueOf(lc.getBlockX()) );
                    		sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.Coordinates.Y", String.valueOf(lc.getBlockY()) );
                    		sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.Coordinates.Z", String.valueOf(lc.getBlockZ()) );
                    		
                    		if(qwe == 1)
                    			sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.BlockType", "REDSTONE_BLOCK");
                    			
                    		if(qwe == 2)
                    			sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.BlockType", "LAPIS_BLOCK");
                    			
                    		if(qwe == 3)
                    			sp.setValue("Block." + lc.getBlockX() + lc.getBlockY() + lc.getBlockZ() + "Properties.BlockType", "IRON_BLOCK");
                    		
                    		lc.getWorld().playSound(lc.add(0, -1, 0), Sound.ANVIL_LAND, 1, 1);//Sound feedback of block place
                    			
                    		p.sendMessage(ChatColor.GREEN + "Wrote X (" + String.valueOf(lc.getBlockX()) + "), Y ("
                    				+ String.valueOf(lc.getBlockY()) + "), Z (" + String.valueOf(lc.getBlockZ()) 
                    				+ "), Team (" + args[1] + "), and zone name (" + Collection + " to config (YML) of " + saveName);
                    
                    
                    		
                    	return true; 
                		}catch(Exception e)
                		{
                			System.out.println(e.getMessage());
                		
                			p.sendMessage(ChatColor.RED + "Failed to write to YML. Check config as well. \n\nError: " + e.getMessage());
                		}
      
                	} else
                	{
                		p.sendMessage(ChatColor.RED + "Invalid argument count for /rkr set. \nCommand usage: /rkr set <TEAM> <NAME, CAN HAVE SPACES>");
                	}
                	
                	
                }
              return true;
              }
            }
            else
            {
            // The command that basically says "You fucked up with your commands.".
               p.sendMessage(ChatColor.DARK_AQUA + "-=====<" + ChatColor.AQUA + "Rival Kingdoms Reloaded" + ChatColor.DARK_AQUA + ">=====-");
               p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Rival Kingdoms Reloaded");
               p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Version 1.0 (DEV)");
               p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Rival Kingdoms Reloaded is a plugin designed to provide infrastructure for the server.");
               p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "Developers");
               p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "Stryker_");
               p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "EUFlux");
               p.sendMessage(ChatColor.AQUA + "- " + ChatColor.DARK_AQUA + "Zxios");
               p.sendMessage(ChatColor.AQUA + "" + ChatColor.DARK_AQUA + "This plugin is for administrators only.");
              return true; 
              }
            }
          }
 
        return true;
        } // END-ONCOMMAND
 
} // END-CLASS