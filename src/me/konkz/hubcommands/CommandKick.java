package me.konkz.hubcommands;

import me.konkz.hubs.Messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandKick implements Listener {

	Messages ms = new Messages();

	public void kick(CommandSender sender, Command command, String alias,
			String[] args) {
		Player p = (Player) sender;

		if (args.length == 1 && args[0].equalsIgnoreCase("kick")) {
			p.sendMessage(ms.er);
		} else if (args.length >= 2 && args[0].equalsIgnoreCase("kick")) { //hub kick reason
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 2; i < args.length; i++) {
				strBuilder.append(args[i]);
				strBuilder.append("");
			}
			String reason = strBuilder.toString();
			Player kicked = Bukkit.getServer().getPlayer(args[1]);

			if (kicked == null) {
				sender.sendMessage(ms.pn + ChatColor.GOLD + args[1]
						+ " is not online.");
			}
			p.sendMessage(ms.pn + "You have kicked " + ChatColor.GREEN + args[1]
					+ ChatColor.WHITE + ".");
			kicked.kickPlayer("You have been kicked by '" + ChatColor.GREEN + p.getDisplayName()
					+ ChatColor.WHITE + "' for '" + ChatColor.GREEN + reason + ChatColor.WHITE + "'.");
		}
	}
}