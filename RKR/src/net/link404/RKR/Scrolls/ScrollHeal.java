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

public class ScrollHeal implements Listener
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
				
				p.sendMessage(ChatColor.GREEN + "You have invoked the powers of Yrasil!");
				if(im.getDisplayName().equalsIgnoreCase("Scroll of  Yrasil, the Lifeweaver"))
				{
					for(Player pl: Bukkit.getOnlinePlayers())
					{
						 MPlayer mp, tp;
						 tp = MPlayer.get(p);
						 mp = MPlayer.get(pl);

						 
							if(!(mp.getFactionName() == tp.getFactionName())) // 'mp' (other player) is not in same faction as 'tp' (Player)
							{
								mp.sendMessage(ChatColor.GREEN + "Enemy Player " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of Yrasil, the Lifeweaver]" + ChatColor.GREEN + ", healing their team!");
							} else
							{
								pl.sendMessage(ChatColor.GREEN + "Team Member " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of  Yrasil, the Lifeweaver]" + ChatColor.GREEN + ", healing your team!");
								pl.setFoodLevel(20);
								pl.setHealth(20);
								
								  p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 2));
								
							}
						 
						 
						 
					}
					
				}
				
				e.getPlayer().getItemInHand().setType(Material.AIR);	
		    }
			
		}
		
	}
}
