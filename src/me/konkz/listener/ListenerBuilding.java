package me.konkz.listener;

import java.util.ArrayList;

import me.konkz.hubs.Messages;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ListenerBuilding implements Listener {

	Messages ms = new Messages();
	public static ArrayList<String> buildtrue = new ArrayList<String>();

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (buildtrue.contains(p.getName())) {
			//
		} else {
			p.sendMessage(ms.pn + "You are not privelaged to touch the land of the mighty.");
			e.setCancelled(true);
			p.getPlayer().playSound(p.getPlayer().getLocation(),Sound.WOLF_BARK, 5.0F, 20.0F);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (!buildtrue.contains(p.getName())) {
			e.setCancelled(true);
			p.sendMessage(ms.pn + "You can't place blocks in the hub.");
		} else {

		}
	}

}
