package me.konkz.hubcommands;

import me.konkz.hubs.Messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CommandGameModes implements Listener {

	Messages ms = new Messages();

	public void gamemode(CommandSender sender, Command command, String alias,
			String[] args) {
		Player p = (Player) sender;
		if (args.length >= 1 && args.length <= 2) {
			if (args.length >= 1 && args.length < 3) {

				/** SURVIVAL **/

				if (args.length == 1 && args[0].equalsIgnoreCase("s")) {
					p.sendMessage(ms.pn + "Gamemode has been set to "
							+ ChatColor.GREEN + "SURVIVAL" + ChatColor.WHITE
							+ ".");
					p.setGameMode(GameMode.SURVIVAL);
					
				} else if (args.length == 1 && args[0].equalsIgnoreCase("s")) { //hub s [args0];
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						p.sendMessage(ms.pn
								+ ChatColor.RED
								+ "Error: "
								+ ChatColor.WHITE
								+ "The player was not found. Is the player online?");
					} else {
						p.sendMessage(ms.pn + "Gamemode " + ChatColor.GREEN
								+ "SURVIVAL" + ChatColor.WHITE
								+ " has been set for player " + ChatColor.GREEN
								+ target.getDisplayName());
						target.sendMessage(ms.pn + "You have been set to "
								+ ChatColor.GREEN + "SURVIVAL"
								+ ChatColor.WHITE + " by " + ChatColor.GREEN
								+ p.getDisplayName());
						target.setGameMode((GameMode.ADVENTURE));
					}
					/** CREATIVE **/

				} else if (args.length == 1 && args[0].equalsIgnoreCase("c")) { //hub s arg1 arg2
					p.sendMessage(ms.pn + "Gamemode has been set to "
							+ ChatColor.GREEN + "CREATIVE" + ChatColor.WHITE
							+ ".");
					p.setGameMode(GameMode.CREATIVE);
				} else if (args.length == 2 && args[0].equalsIgnoreCase("c")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						p.sendMessage(ms.pn
								+ ChatColor.RED
								+ "Error: "
								+ ChatColor.WHITE
								+ "The player was not found. Is the player online?");
					} else {
						p.sendMessage(ms.pn + "Gamemode " + ChatColor.GREEN
								+ "CREATIVE" + ChatColor.WHITE
								+ " has been set for player " + ChatColor.GREEN
								+ target.getDisplayName());
						target.sendMessage(ms.pn + "You have been set to "
								+ ChatColor.GREEN + "CREATIVE"
								+ ChatColor.WHITE + " by " + ChatColor.GREEN
								+ p.getDisplayName());
						target.setGameMode((GameMode.ADVENTURE));
					}

					/** ADVENTURE **/

				} else if (args.length == 2 && args[0].equalsIgnoreCase("a")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						p.sendMessage(ms.pn
								+ ChatColor.RED
								+ "Error: "
								+ ChatColor.WHITE
								+ "The player was not found. Is the player online?");
					} else {
						p.sendMessage(ms.pn + "Gamemode " + ChatColor.GREEN
								+ "ADVENTURE" + ChatColor.WHITE
								+ " has been set for player " + ChatColor.GREEN
								+ target.getDisplayName());
						target.sendMessage(ms.pn + "You have been set to "
								+ ChatColor.GREEN + "ADVENTURE"
								+ ChatColor.WHITE + " by " + ChatColor.GREEN
								+ p.getDisplayName());
						target.setGameMode((GameMode.ADVENTURE));
					}
				} else if (args.length >= 3) {
					p.sendMessage(ms.er);
				}
			}
		}
	}
}
