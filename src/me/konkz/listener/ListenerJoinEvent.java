package me.konkz.listener;

import me.konkz.hubs.Messages;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerJoinEvent implements Listener {
	
	Messages ms = new Messages();
	ListenerBossBar lbb = new ListenerBossBar();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		lbb.bossbar();
		p.teleport(new Location(Bukkit.getWorld("world"), 0, 65, 0));
	}
}
