package me.konkz.hubcommands;

import me.konkz.hubs.Messages;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandHelp implements Listener {

	Messages ms = new Messages();

	public void help(CommandSender sender, Command command, String alias,
			String[] args) {
		Player p = (Player) sender;

		if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
			if (p.isOp()) {
				p.sendMessage(ChatColor.GREEN + "-------- " + ChatColor.WHITE
						+ ChatColor.GOLD + "Hub Help " + ChatColor.RED
						+ "[Admin]" + ChatColor.GREEN + " --------");
				p.sendMessage( "'P' - " + ChatColor.ITALIC
						+ "stands for player.");
				p.sendMessage(ChatColor.GOLD + "/hub help" + ChatColor.WHITE // hub help
						+ " - " + ChatColor.ITALIC
						+ "Shows this.");
				p.sendMessage(ChatColor.GOLD + "/hub s p" + ChatColor.WHITE // hub s
						+ " - " + ChatColor.ITALIC
						+ "will set you to survival mode.");
				p.sendMessage(ChatColor.GOLD + "/hub a p" + ChatColor.WHITE // hub a
						+ " - " + ChatColor.ITALIC
						+ "will set you to adventure mode.");
				p.sendMessage(ChatColor.GOLD + "/hub c p" + ChatColor.WHITE // hub c
						+ " - " + ChatColor.ITALIC
						+ "will set you to creative mode.");
				p.sendMessage(ChatColor.GOLD + "/hub cmd" + ChatColor.WHITE
						+ " - " + ChatColor.ITALIC
						+ "desc");
				p.sendMessage(ChatColor.GOLD + "/hub cmd" + ChatColor.WHITE
						+ " - " + ChatColor.ITALIC
						+ "desc");
				p.sendMessage(ChatColor.GOLD + "/hub cmd" + ChatColor.WHITE
						+ " - " + ChatColor.ITALIC
						+ "desc");
				p.sendMessage(ChatColor.GREEN
						+ "-------------------------------");
			}
		}
	}
}
