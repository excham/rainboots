package net.excham.rainboots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.excham.rainboots.Rainboots;
import net.excham.rainboots.items.WearableRainboots;

public class RainbootsCommand implements CommandExecutor {
	
	Rainboots plugin;
	
	public RainbootsCommand(Rainboots rainboots) {
		this.plugin = rainboots;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) return false;
		
		Player player = (Player) sender;
		
		ItemStack currentBoots = player.getInventory().getBoots();
		
		if(currentBoots != null) {
			player.sendMessage("Please take off your current boots");
			return true;
		}
		
		player.getInventory().setBoots(new WearableRainboots(this.plugin, player).getBoots());
		
		
		return true;
	}

}
