package com.blaxout1213.DaytimeRules;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventListener implements Listener
{
	private DaytimeRules plugin;

	public EventListener(DaytimeRules plugin)
	{
		
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityAttack(EntityDamageByEntityEvent event)
	{
		if(event.getEntity() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			Player a = null;
			if(event.getDamager() instanceof Player)
			{
				a = (Player) event.getDamager();
			}
			if(event.getDamager() instanceof Projectile)
			{
				Projectile arrow = (Projectile) event.getDamager();
				if(arrow.getShooter() instanceof Player) { a = (Player) arrow.getShooter(); }
			}
			if(a == null){ return; }
			//Bukkit.broadcastMessage(String.valueOf(p.getLocation().getBlock().getRelative(BlockFace.UP).getLightFromSky()));
			//Bukkit.broadcastMessage(String.valueOf(a.getWorld().getTime()));
			if(a.getWorld().getTime() > 23000 || (a.getWorld().getTime() > 0 && a.getWorld().getTime() < 13000) && p.getLocation().getBlock().getRelative(BlockFace.UP).getLightFromSky() >= 4 && a.getLocation().getBlock().getRelative(BlockFace.UP).getLightFromSky() >= 4)
			{

				a.sendMessage("You wouldnt attack someone in broad daylight, would you?");
				event.setCancelled(true);
			}
		}
	}
}
