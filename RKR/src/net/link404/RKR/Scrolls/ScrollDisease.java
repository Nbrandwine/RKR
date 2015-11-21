package net.link404.RKR.Scrolls;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.entity.MPlayer;

public class ScrollDisease implements Listener
{
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e)
	{
		Player p = (Player) e.getPlayer();
		
		if(e.getPlayer().getItemInHand().getType() == (Material.PAPER))
		{
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
		    {
				ItemMeta im = p.getInventory().getItemInHand().getItemMeta();
				
				p.sendMessage(ChatColor.GREEN + "You have invoked the powers of Colborn!");
				if(im.getDisplayName().equalsIgnoreCase("Scroll of Colborn, the Plaguebringer"))
				{
					for(Player pl: Bukkit.getOnlinePlayers())
					{
						 MPlayer mp, tp;
						 tp = MPlayer.get(p);
						 mp = MPlayer.get(pl);

						 
							if(!(mp.getFactionName() == tp.getFactionName())) // 'mp' (other player) is not in same faction as 'tp' (Player)
							{
								mp.sendMessage(ChatColor.GREEN + "Enemy Player " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of Colborn, the Plaguebringer]" + ChatColor.GREEN + ", infesting your team!");
								
								  p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 280, 2));
								  
							} else
							{
								pl.sendMessage(ChatColor.GREEN + "Team Member " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of  Colborn, the Plaguebringer]" + ChatColor.GREEN + ", infecting the other team!");
								
							}
						 
						 
						 
					}
					
				}
				
				e.getPlayer().getItemInHand().setType(Material.AIR);	
		    }
			
		}
		
	}
}
