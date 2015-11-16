package net.link404.RKR.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class UtilWorldReset extends BukkitRunnable
{
	private int delay;
	private int maxdelay;
	private ScoreboardManager sbmanager;
	private Scoreboard board;
	private Objective obj;
	private Score time;
	private Plugin plugin;
	private int taskid;
	
	public UtilWorldReset(Plugin pl)
	{
		plugin = pl;
		maxdelay = 30;
		sbmanager = Bukkit.getScoreboardManager();
		board = sbmanager.getNewScoreboard();
		obj = board.registerNewObjective("countdown", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("Server reboot");
		time = obj.getScore(ChatColor.GREEN+"Minutes:");
	}
	
	public void scheduleReboot(int timedelay)//test for int prior to sending to this method
	{
		if (timedelay <= maxdelay && timedelay > 0)
		{
			Bukkit.getScheduler().cancelTask(taskid);//MAYBE
			delay = timedelay;
			time.setScore(delay);
			for(Player p: Bukkit.getOnlinePlayers()){
				p.setScoreboard(board);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 1);
				Bukkit.broadcastMessage(ChatColor.GREEN+"Server will reboot in " + delay + " minutes.");
				this.runTaskTimer(plugin, 0, 20);//change to 1200 to set 1min interval
			}
		}
		else
		{
			//return error here to let user know the time delay was not validated.
		}
	}
	
	public void run()
	{
		taskid = this.getTaskId();
		Bukkit.broadcastMessage(""+taskid);
		delay--;
		if (delay > 0)
		{
			time.setScore(delay);
			for(Player p: Bukkit.getOnlinePlayers())
			{			
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 1);
			}
		}
		else if (delay == 0)
		{
			for(Player p: Bukkit.getOnlinePlayers()){
				p.setScoreboard(sbmanager.getNewScoreboard());//FOR TEST ONLY
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			}
			//make a 60 second counter here
		}
		else if (delay == -1)
		{
			this.cancel();
		}
		else
		{
			Bukkit.broadcastMessage("Still running...");
		}
	}
	
}
