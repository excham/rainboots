package net.excham.rainboots.items;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.excham.rainboots.Rainboots;
import net.excham.rainboots.tasks.RainbootRainbower;
import net.md_5.bungee.api.ChatColor;

public class WearableRainboots extends ItemStack {
	
	private Player wearer;
	private ItemStack boots;
	private Rainboots plugin;
	private int taskId;

	public WearableRainboots(Rainboots plugin, Player player) {
		this.plugin = plugin;
		this.wearer = player;
		
		this.boots = new ItemStack(Material.LEATHER_BOOTS);
		
		this.superEnchant(this.boots);
		
		this.boots = this.setName(this.boots);

		this.taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new RainbootRainbower(this), 0, 1);
	}

	private void superEnchant(ItemStack boots) {
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 100);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 100);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 100);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 100);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 100);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
		boots.addUnsafeEnchantment(Enchantment.THORNS, 100);
	}
	
	private ItemStack setName(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "the Gay Boots(tm)");
		
		stack.setItemMeta(meta);
		
		return stack;
	}

	public ItemStack getBoots() {
		return this.boots;
	}
	
	public void setColor(Color color) {
		LeatherArmorMeta meta = (LeatherArmorMeta) this.boots.getItemMeta();
		
		meta.setColor(color);

		this.boots.setItemMeta(meta);
		
		this.wearer.getInventory().setBoots(this.boots);
	}

	public boolean wearerWearing() {
		ItemStack bootsWearing = this.wearer.getInventory().getBoots();
		
		if(bootsWearing != null) return true;
		
		Bukkit.getScheduler().cancelTask(this.taskId);
		return false;
	}

}
