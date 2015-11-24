package net.link404.RKR.Listeners;

import net.link404.RKR.Storage.PlatformYML;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;

public class $ListenerTeamBalance implements Listener
{
	  @SuppressWarnings("unused")
      @EventHandler
      public void onPlayerJoin(PlayerJoinEvent e)
      {
              Player p = e.getPlayer();
              MPlayer mp;
              mp = MPlayer.get(p);
             
              Faction f1 = null;
              Faction f2 = null;
              Faction ee = null;    
              PlatformYML cfg = new PlatformYML();
              
  
             if(mp.hasFaction() == false)
             {                 
                	  f1 = FactionColl.get().getByName("Red");
                      f2 = FactionColl.get().getByName("Blue");
                     
                      Boolean flg;
                     
                      int a = 0; int b = 0;
                      for(MPlayer mpl : f1.getMPlayers())
                      {
                              a++;
                      }
                      for(MPlayer mpl : f2.getMPlayers())
                      {
                              b++;
                      }
                      
                      if(a > b) // red > blue
                      {
                              mp.setFaction(f2);
                              p.sendMessage(ChatColor.BLUE + "You have been drafted into blue team! You may opt-out of this team by requesting a team-change on the website.");
                              mp.setTitle("Draftee");
                              Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + mp.getName() + " Blue");
                              flg = true;
                              
                          	cfg.setValue("Player." + p.getName() + ".Joined", "true");
                        	cfg.setValue("Player." + p.getName() + ".Team", "Blue");
                        	cfg.save(cfg.getFileConfig());
                        	
                        	// IF Player joined RED, Alert RED Players
                        	for(Player px : Bukkit.getOnlinePlayers())
                        	{ MPlayer pxx = (MPlayer) px;
                        		if(pxx.getFaction() == mp.getFaction())
                        			px.sendMessage(ChatColor.GREEN + "Congratulations, " + ChatColor.RED + px.getName() + ChatColor.GREEN + " has joined your team!");
                        	}
                        	
                      } else if(b > a) // blue > red
                      {
                         mp.setFaction(f1);
                         p.sendMessage(ChatColor.RED + "You have been drafted into red team! You may opt-out of this team by requesting a team-change on the website.");
                         flg = false;
                         mp.setTitle("Draftee");
                         Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + mp.getName() + " Red");
                         
                       	cfg.setValue("Player." + p.getName() + ".Joined", "true");
                    	cfg.setValue("Player." + p.getName() + ".Team", "Blue");
                    	cfg.save(cfg.getFileConfig());
                    	
                    	// IF Player joined BLUE Alert BLUE Players
                    	for(Player px : Bukkit.getOnlinePlayers())
                    	{ MPlayer pxx = (MPlayer) px;
                    		if(pxx.getFaction() == mp.getFaction())
                    			px.sendMessage(ChatColor.GREEN + "Congratulations, " + ChatColor.RED + px.getName() + ChatColor.GREEN + " has joined your team!");
                    	}
                      }
                      
             }
        }
}
