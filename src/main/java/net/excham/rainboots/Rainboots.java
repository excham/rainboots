package net.excham.rainboots;

import org.bukkit.plugin.java.JavaPlugin;

import net.excham.rainboots.commands.RainbootsCommand;

public class Rainboots extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getServer().getLogger().info("Loading Rainboots");
		
		this.getCommand("rainboots").setExecutor(new RainbootsCommand(this));
		
	}
	
	
	@Override
	public void onDisable() {
		this.getServer().getLogger().info("Disabling Rainboots");
	}

}
