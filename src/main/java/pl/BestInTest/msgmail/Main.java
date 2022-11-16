package pl.BestInTest.msgmail;

import com.earth2me.essentials.Essentials;
import org.bukkit.plugin.java.JavaPlugin;
import pl.BestInTest.msgmail.commands.MsgMailCommand;
import pl.BestInTest.msgmail.listeners.PrivateMessageListener;
import pl.BestInTest.msgmail.storage.Config;

public class Main extends JavaPlugin {

    private static Main instance;
    private static Essentials essentials;

    @Override
    public void onEnable() {
        instance = this;
        essentials = (Essentials) getServer().getPluginManager().getPlugin("Essentials");

        saveDefaultConfig();
        Config.reloadValues();

        getServer().getPluginManager().registerEvents(new PrivateMessageListener(), this);
        getCommand("msgmail").setExecutor(new MsgMailCommand());
    }

    public static Main getInstance() {
        return instance;
    }

    public static Essentials getEssentials() {
        return essentials;
    }
}
