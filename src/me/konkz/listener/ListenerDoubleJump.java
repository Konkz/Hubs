package me.konkz.listener;

import me.konkz.hubs.Messages;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class ListenerDoubleJump implements Listener {

	Messages ms = new Messages();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onjump(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() == GameMode.CREATIVE)
			return;
		e.setCancelled(true);
		p.setAllowFlight(false);
		p.setFlying(false);
		p.getPlayer().playSound(p.getPlayer().getLocation(),Sound.ENDERDRAGON_WINGS, 5.0F, 20.0F);
		p.getPlayer().playEffect(p.getLocation(), Effect.SMOKE, 5);
		p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if ((p.getGameMode() != GameMode.CREATIVE)
				&& (p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR)
				&& (!p.isFlying())) {
			p.setAllowFlight(true);
		}
	}
}
