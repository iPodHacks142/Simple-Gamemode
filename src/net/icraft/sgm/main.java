package net.icraft.sgm;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin
{
  Logger log = Logger.getLogger("Minecraft");

  public void onDisable()
  {
    this.log.info("Simple Gamemode Disabled!");
  }

  public void onEnable()
  {
    this.log.info("Simple Gamemode Enabled!");
  }
  public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
    Player player = (Player)sender;
    Server server = player.getServer();

    if (player.hasPermission("sgm.change"))
    {
      if (cmd.getName().equalsIgnoreCase("gm")) {
        if (player.getGameMode() == GameMode.CREATIVE) {
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Survival" + ChatColor.GOLD + "!");
          return true;
        }
        if (player.getGameMode() == GameMode.SURVIVAL) {
          player.setGameMode(GameMode.CREATIVE);
          player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Creative" + ChatColor.GOLD + "!");
          return true;
        }
        if (player.getGameMode() == GameMode.ADVENTURE) {
        	player.setGameMode(GameMode.CREATIVE);
        	player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Creative" + ChatColor.GOLD + "!");
        	return true;
        }
      }
      if (cmd.getName().equalsIgnoreCase("s")) {
    	if (player.getGameMode() == GameMode.SURVIVAL) {
    		player.sendMessage(ChatColor.DARK_RED + "You are already in" + ChatColor.GOLD + " Survival" + ChatColor.DARK_RED + " mode!");
    		return true;
    	}
    	else {
    		player.setGameMode(GameMode.SURVIVAL);
    		player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Survival" + ChatColor.GOLD + "!");
    		return true;
    	}
      }
      if (cmd.getName().equalsIgnoreCase("c")) {
    	  if (player.getGameMode() == GameMode.CREATIVE) {
    		  player.sendMessage(ChatColor.DARK_RED + "You are already in" + ChatColor.GOLD + " Creative" + ChatColor.DARK_RED + " mode!");
    		  return true;
    	  }
    	  else {
    		  player.setGameMode(GameMode.CREATIVE);
    		  player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Creative" + ChatColor.GOLD + "!");
    		  return true;
    	  }
      }
      if (cmd.getName().equalsIgnoreCase("a")) {
    	  if (player.getGameMode() == GameMode.ADVENTURE) {
    		  player.sendMessage(ChatColor.DARK_RED + "You are already in" + ChatColor.GOLD + " Adventure" + ChatColor.DARK_RED + " mode!");
    		  return true;
    	  }
    	  else {
    		  player.setGameMode(GameMode.ADVENTURE);
    		  player.sendMessage(ChatColor.GOLD + "Changed your gamemode to" + ChatColor.DARK_RED + " Adventure" + ChatColor.GOLD + "!");
    		  return true;
    	  }
      }
    }
    else {
      player.sendMessage(ChatColor.DARK_RED + "You do not have permission to change your gamemode!");
      return true;
    }
    return false;
  }
}