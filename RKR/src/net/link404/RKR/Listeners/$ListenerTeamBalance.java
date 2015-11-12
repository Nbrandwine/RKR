package net.link404.RKR.Listeners;

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
       
              if(!e.getPlayer().hasPlayedBefore())
              {
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
                                      p.sendMessage(ChatColor.BLUE + "You have been drafted into blue team! You may opt-out of this team by requesting a team-change in the forums.");
                                      mp.setTitle("Recruit");
                                      Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn " + mp.getName() + " blue");
                                      flg = true;
                              } else if(b > a) // blue > red
                              {
                                 mp.setFaction(f1);
                                 p.sendMessage(ChatColor.RED + "You have been drafted into red team! You may opt-out of this team by requesting a team-change in the forums.");
                                 flg = false;
                                 mp.setTitle("Recruit");
                                 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn " + mp.getName() + " red");
                              } else
                              {
                                      mp.setFaction(f1);
                                       p.sendMessage(ChatColor.RED + "You have been drafted into red team! You may opt-out of this team by requesting a team-change in the forums.");
                                       mp.setTitle("Recruit");
                                       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn " + mp.getName() + " red");
                                       flg = false;
                              }
                             
                              for(Player adm: Bukkit.getOnlinePlayers())
                              {
                                      if(adm.hasPermission("sck.teamnotify"))
                                      {
                                              if(flg)
                                                      adm.sendMessage(ChatColor.WHITE + "(Admin Message) A new player has joined and has been drafted. (" + p.getName() + " to " + mp.getFactionName() + ")");
                     
                                      }
                              }
                             
                              for(Player ad: Bukkit.getOnlinePlayers())
                              { MPlayer x;
                                x = MPlayer.get(ad);
                             
                                if(mp.getFaction() == x.getFaction())
                                {
                                        ad.sendMessage(ChatColor.GREEN + "! New Player " + ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.GREEN + " has joined your team.");
                                }
                              }
                             
                      }
              }
               
               
               
      }
}
