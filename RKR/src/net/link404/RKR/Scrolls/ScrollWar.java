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

// Gulbrand the Warrior
public class ScrollWar implements Listener
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
				
				p.sendMessage(ChatColor.GREEN + "You have invoked the powers of Gulbrand!");
				if(im.getDisplayName().equalsIgnoreCase("Scroll of  Gulbrand, the Warrior"))
				{
					for(Player pl: Bukkit.getOnlinePlayers())
					{
						 MPlayer mp, tp;
						 tp = MPlayer.get(p);
						 mp = MPlayer.get(pl);

						 
							if(!(mp.getFactionName() == tp.getFactionName())) // 'mp' (other player) is not in same faction as 'tp' (Player)
							{
								mp.sendMessage(ChatColor.GREEN + "Enemy Player " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of Gulbrand, the Warrior]" + ChatColor.GREEN + ", beserking their team!");
							} else
							{
								pl.sendMessage(ChatColor.GREEN + "Team Member " + ChatColor.GOLD + p.getName() + " has invoked the powers of "
										+ ChatColor.RED + "[Scroll of  Gulbrand, the Warrior]" + ChatColor.GREEN + ", sending your team into a blind rage!");
				
								
								  p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 1));
								  p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 2));
								
							}
						 
						 
						 
					}
					
				}
				
				e.getPlayer().getItemInHand().setType(Material.AIR);	
		    }
			
		}
		
	}
}
