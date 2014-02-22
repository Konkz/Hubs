package me.konkz.listener;

import me.konkz.hubs.Messages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class ListenerNoDmg implements Listener {

	Messages ms = new Messages();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			((Player) e.getEntity()).setHealth(20);
			e.setCancelled(true);
			((Player) e.getEntity()).updateInventory();
		}
	}	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player) {
			e.setCancelled(true);
			((Player) e.getEntity()).setFoodLevel(20);
			((Player) e.getEntity()).updateInventory();
		}
	}
}
