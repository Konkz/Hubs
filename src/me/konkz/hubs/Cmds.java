package me.konkz.hubs;

import me.konkz.hubcommands.CommandBroadcast;
import me.konkz.hubcommands.CommandBuild;
import me.konkz.hubcommands.CommandGameModes;
import me.konkz.hubcommands.CommandHelp;
import me.konkz.hubcommands.CommandKick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Cmds implements CommandExecutor, Listener {

	CommandGameModes gm = new CommandGameModes();
	CommandHelp hp = new CommandHelp();
	CommandKick kik = new CommandKick();
	CommandBroadcast brd = new CommandBroadcast();
	CommandBuild bld = new CommandBuild();

	Messages ms = new Messages();

	public boolean onCommand(CommandSender sender, Command command,
			String alias, String[] args) {
		Player p = (Player) sender;

		if (alias.equalsIgnoreCase("hub")) {
			if (args.length == 0) {
				p.sendMessage(ms.pn + "Command unknown.");
			}
			else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("a")) { //hub s/c/a
				gm.gamemode(sender, command, alias, args);
			}
			else if (args[0].equalsIgnoreCase("help")) { //hub help
				hp.help(sender, command, alias, args);
			}
			else if (args[0].equalsIgnoreCase("build")) { //hub build
				bld.builder(sender, command, alias, args);
			}
			else if (args[0].equalsIgnoreCase("kick")) { //hub kick
				kik.kick(sender, command, alias, args);
			} 
			else if (args[0].equalsIgnoreCase("broadcast")) { //hub broadcast
				brd.broadcast(sender, command, alias, args);
				
			}else{ // else
				p.sendMessage(ms.pn + "Command unkown.");
			}
		}
		return false;
	}
}
