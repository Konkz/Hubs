package me.konkz.hubs;

import java.util.logging.Logger;

import me.konkz.hubcommands.CommandBroadcast;
import me.konkz.hubcommands.CommandBuild;
import me.konkz.hubcommands.CommandGameModes;
import me.konkz.hubcommands.CommandHelp;
import me.konkz.hubcommands.CommandKick;
import me.konkz.listener.ListenerBossBar;
import me.konkz.listener.ListenerBuilding;
import me.konkz.listener.ListenerDoubleJump;
import me.konkz.listener.ListenerDropItem;
import me.konkz.listener.ListenerJoinEvent;
import me.konkz.listener.ListenerNoDmg;
import me.konkz.listener.ListenerQuitEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Hubs extends JavaPlugin implements Listener {

	static Plugin plugin = null;
	static Logger logger = Logger.getLogger("Minecraft");
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	public void onEnable() {
		registerEvents(this, new CommandGameModes(), new Cmds(), new CommandHelp(),
				new CommandKick(), new CommandBroadcast(), new ListenerDoubleJump(), new ListenerJoinEvent(),
				new ListenerBossBar(), new ListenerNoDmg(), new ListenerDropItem(),
				new CommandBuild(), new ListenerBuilding(), new ListenerQuitEvent(),
				new Messages());
		getCommand("hub").setExecutor(new Cmds());

		if (getServer().getPluginManager().getPlugin("BarAPI") == null) {
			console.sendMessage(ChatColor.RED + "Missing dependency:"
					+ ChatColor.GOLD
					+ " BarAPI. Disable boss bar or get BarAPI.");
			getServer().getPluginManager().disablePlugin(this);
		}
	}

	public void onDisable() {
		plugin = null;

	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin,
			Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager()
					.registerEvents(listener, plugin);
		}
	}

	public static Plugin getPlugin() {
		return plugin;
	}
}
