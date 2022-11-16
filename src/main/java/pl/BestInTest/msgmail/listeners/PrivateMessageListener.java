package pl.BestInTest.msgmail.listeners;

import net.ess3.api.events.PrivateMessageSentEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.BestInTest.msgmail.Main;
import pl.BestInTest.msgmail.storage.Config;
import pl.BestInTest.msgmail.utils.ChatFix;

public class PrivateMessageListener implements Listener {
    @EventHandler
    public void onPrivateMessage(PrivateMessageSentEvent e) {
        if (!Bukkit.getConsoleSender().getName().equals(e.getRecipient().getName())) { // zabezpieczenie przed wysłaniem do konsoli
            Player p = Bukkit.getPlayer(e.getRecipient().getUUID());
            if (p != null && p.isOnline()) {
                if (!Main.getEssentials().getUser(e.getRecipient().getUUID()).isIgnoreMsg()) {
                    p.sendTitle(ChatFix.fixColor(Config.getTitle()), ChatFix.fixColor(Config.getSubTitle()), Config.getFadeInTicks(), Config.getStayTicks(), Config.getFadeOutTicks());
                    if (Config.isEnableSound()) {
                        p.playSound(p.getLocation(), Sound.valueOf(Config.getSound()), (float) Config.getVolume(), (float) Config.getPitch());
                    }
                }
            }
        }
    }
}
