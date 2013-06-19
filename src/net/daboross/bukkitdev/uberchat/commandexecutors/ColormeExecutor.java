/*
 * Author: Dabo Ross
 * Website: www.daboross.net
 * Email: daboross@daboross.net
 */
package net.daboross.bukkitdev.uberchat.commandexecutors;

import java.util.List;
import net.daboross.bukkitdev.uberchat.UberChat;
import net.daboross.bukkitdev.uberchat.UberChatStatics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

/**
 *
 * @author daboross
 */
public class ColormeExecutor implements CommandExecutor {

    private final UberChat uberChatMain;

    public ColormeExecutor(UberChat uberChatMain) {
        this.uberChatMain = uberChatMain;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Sorry, Players Only");
            return true;
        }
        Player p = (Player) sender;
        boolean on = false;
        if (p.hasMetadata(UberChatStatics.COLOR_MESSAGE_ON_METADATA_KEY)) {
            List<MetadataValue> meta = p.getMetadata(UberChatStatics.COLOR_MESSAGE_ON_METADATA_KEY);
            if (meta.size() >= 1 && (meta.get(0).asBoolean())) {
                on = true;
            }
        }
        if (on) {
            p.removeMetadata("isMessageColorOn", uberChatMain);
            sender.sendMessage(ChatColor.GREEN + "Your chat messages are no longer being colorized.");
        } else {
            p.setMetadata("isMessageColorOn", new FixedMetadataValue(uberChatMain, Boolean.TRUE));
            sender.sendMessage(ChatColor.GREEN + "Your future chat messages will now be colorized.");
        }
        return true;
    }
}