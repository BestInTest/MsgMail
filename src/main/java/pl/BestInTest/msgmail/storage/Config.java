package pl.BestInTest.msgmail.storage;

import org.bukkit.configuration.file.FileConfiguration;
import pl.BestInTest.msgmail.Main;

public class Config {
    private static int fadeInTicks;
    private static int stayTicks;
    private static int fadeOutTicks;
    private static String title;
    private static String subTitle;
    private static boolean enableSound;
    private static String sound;
    private static double volume;
    private static double pitch;

    public static void reloadValues() {
        Main plugin = Main.getInstance();
        plugin.reloadConfig();
        FileConfiguration configuration = plugin.getConfig();
        try {
            fadeInTicks = configuration.getInt("settings.enter");
        } catch (Throwable throwable) {
            fadeInTicks = 10;
            plugin.getLogger().severe("Failed to load \"settings.enter\" value from configuration file!");
        }
        try {
            stayTicks = configuration.getInt("settings.show");
        } catch (Throwable throwable) {
            stayTicks = 40;
            plugin.getLogger().severe("Failed to load \"settings.show\" value from configuration file!");
        }
        try {
            fadeOutTicks = configuration.getInt("settings.out");
        } catch (Throwable throwable) {
            fadeOutTicks = 10;
            plugin.getLogger().severe("Failed to load \"settings.out\" value from configuration file!");
        }
        try {
            title = configuration.getString("settings.title");
        } catch (Throwable throwable) {
            title = "&e\u2709";
            plugin.getLogger().severe("Failed to load \"settings.title\" value from configuration file!");
        }
        try {
            subTitle = configuration.getString("settings.subtitle");
        } catch (Throwable throwable) {
            subTitle = "";
            plugin.getLogger().severe("Failed to load \"settings.subtitle\" value from configuration file!");
        }
        try {
            enableSound = configuration.getBoolean("settings.sound.enable");
        } catch (Throwable throwable) {
            enableSound = true;
            plugin.getLogger().severe("Failed to load \"settings.sound.enable\" value from configuration file!");
        }
        try {
            sound = configuration.getString("settings.sound.name");
        } catch (Throwable throwable) {
            sound = "";
            plugin.getLogger().severe("Failed to load \"settings.sound.name\" value from configuration file!");
        }
        try {
            volume = configuration.getDouble("settings.sound.volume");
        } catch (Throwable throwable) {
            volume = 1.0;
            plugin.getLogger().severe("Failed to load \"settings.sound.volume\" value from configuration file!");
        }
        try {
            pitch = configuration.getDouble("settings.sound.pitch");
        } catch (Throwable throwable) {
            pitch = 1.0;
            plugin.getLogger().severe("Failed to load \"settings.sound.pitch\" value from configuration file!");
        }
    }

    public static int getFadeInTicks() {
        return fadeInTicks;
    }

    public static int getStayTicks() {
        return stayTicks;
    }

    public static int getFadeOutTicks() {
        return fadeOutTicks;
    }

    public static String getTitle() {
        return title;
    }

    public static String getSubTitle() {
        return subTitle;
    }

    public static boolean isEnableSound() {
        return enableSound;
    }

    public static String getSound() {
        return sound;
    }

    public static double getVolume() {
        return volume;
    }

    public static double getPitch() {
        return pitch;
    }
}
