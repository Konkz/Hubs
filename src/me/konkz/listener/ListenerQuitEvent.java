package me.konkz.listener;

import me.konkz.hubs.Messages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ListenerQuitEvent implements Listener {
	
	Messages ms = new Messages();
	ListenerBuilding lb = new ListenerBuilding();
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		ListenerBuilding.buildtrue.remove(p);
	}

}
