package com.blaxout1213.DaytimeRules;

import org.bukkit.plugin.java.JavaPlugin;

public class DaytimeRules extends JavaPlugin
{
	private EventListener ev;

	public void onEnable()
	{
		this.ev = new EventListener(this);
	}
	
}
