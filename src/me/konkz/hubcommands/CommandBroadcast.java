package me.konkz.hubcommands;

import me.konkz.hubs.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandBroadcast implements Listener {

	Messages ms = new Messages();

	public void broadcast(CommandSender sender, Command command, String alias,
			String[] args) {
		Player p = (Player) sender;
		if (args.length <= 1) {
			p.sendMessage(ms.er);
		} else if (args.length > 1) {
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 1; i < args.length; i++) {
				strBuilder.append(args[i]);
				strBuilder.append(" ");
			}
			String message = strBuilder.toString();
			Bukkit.broadcastMessage(ms.pn + message);
		}
	}
}
