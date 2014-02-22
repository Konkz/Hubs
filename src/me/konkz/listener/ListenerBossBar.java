package me.konkz.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

import me.confuser.barapi.BarAPI;
import me.konkz.hubs.Messages;

public class ListenerBossBar implements Listener {
	
	Messages ms = new Messages();
	
	public void bossbar() {
		BarAPI.setMessage(ChatColor.AQUA + "Edit me" + ChatColor.RED +  " in your " + ChatColor.GREEN + "config!", 100f);
	}
}
