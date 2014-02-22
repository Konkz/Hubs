package me.konkz.hubcommands;

import me.konkz.hubs.Messages;
import me.konkz.listener.ListenerBuilding;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandBuild implements Listener {

	Messages ms = new Messages();
	ListenerBuilding lb = new ListenerBuilding();

	public void builder(CommandSender sender, Command command, String alias,
			String[] args) {
		Player p = (Player) sender;

		if (args.length == 1 && args[0].equalsIgnoreCase("build")) {
			p.sendMessage(ms.er);
		} else if (args.length == 2) {
			if (args[1].equalsIgnoreCase("yes") || args[1].equalsIgnoreCase("no")) {
				boolean yes = args[1].equalsIgnoreCase("yes");
				String active = (yes ? "ENABLED" : "DISABLED");
				if (yes && !ListenerBuilding.buildtrue.contains(p.getName())) {
					ListenerBuilding.buildtrue.add(p.getName());
					p.sendMessage(ms.pn + "Building has been set to " + active);
				} else if (!yes && ListenerBuilding.buildtrue.contains(p.getName())) {
					ListenerBuilding.buildtrue.remove(p.getName());
					p.sendMessage(ms.pn + "Building has been set to " + active);
				}
			} else {
				p.sendMessage(ms.er);
			}
		} else {
			p.sendMessage(ms.er);
		}
	}
}

// hub == 0 args
// hub 1 == 1 args
// hub 1 2 == 2 args
// hub 1 2 3 == 3 args
