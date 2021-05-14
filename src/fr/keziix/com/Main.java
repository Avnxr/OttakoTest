package fr.keziix.com;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		System.out.println("Plugin TEST activé");
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player p = event.getPlayer(); 
		
		event.setJoinMessage("§eBienvenue à §6" + p.getName());
		
		p.getInventory().clear();
		p.setFoodLevel(20);
		p.setGameMode(GameMode.ADVENTURE);
		p.setHealth(20);
		
		// Menu		

		ItemStack menu = new ItemStack(Material.COMPASS);
		
		
		ItemMeta meta = menu.getItemMeta();
		meta.setDisplayName("§6Menu");
		
		menu.setItemMeta(meta);
		
		p.getInventory().setItem(4, menu);
		
		// Boutique		

		ItemStack shop = new ItemStack(Material.GOLD_INGOT);
		
		
		ItemMeta oeoe = shop.getItemMeta();
		oeoe.setDisplayName("§eBoutique");
		
		shop.setItemMeta(oeoe);
		
		p.getInventory().setItem(2, shop);
		
		// Paramètres		

		ItemStack para = new ItemStack(Material.COMMAND_REPEATING);
		
		para.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		ItemMeta ueue = para.getItemMeta();
		ueue.setDisplayName("§cParamètres de " + p.getName());
		
		para.setItemMeta(ueue);
		
		p.getInventory().setItem(6, para);
		
		if(p.hasPermission("moderator") || p.isOp()) {
			
			ItemStack modo = new ItemStack(Material.SHIELD);
			
			ItemMeta modoo = modo.getItemMeta();
			modoo.setDisplayName("§cReports");
			
			modo.setItemMeta(modoo);
			
			p.getInventory().setItem(8, modo);
			
		}
		
		
	}
	
	
	@Override
	public void onDisable() {
		
		System.out.println("Plugin TEST désactivé");
		
	}

}
