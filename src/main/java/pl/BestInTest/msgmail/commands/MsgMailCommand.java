package pl.BestInTest.msgmail.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pl.BestInTest.msgmail.storage.Config;
import pl.BestInTest.msgmail.utils.ChatFix;

public class MsgMailCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                Config.reloadValues();
                sender.sendMessage(ChatFix.fixColor("&aPrzeładowano konfigurację pluginu"));
                return true;
            }
        }
        sender.sendMessage(ChatFix.fixColor("&cPoprawne użycie: /msgmail reload"));
        return false;
    }
}
