package me.konkz.listener;

import me.konkz.hubs.Messages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ListenerDropItem implements Listener {

	Messages ms = new Messages();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		p.updateInventory();
		e.setCancelled(true);
	}
}
