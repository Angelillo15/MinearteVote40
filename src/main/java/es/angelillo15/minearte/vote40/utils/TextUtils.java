package es.angelillo15.minearte.vote40.utils;

import es.angelillo15.minearte.vote40.config.Messages;
import net.md_5.bungee.api.ChatColor;

public class TextUtils {
    public static String colorize(String text){
        return parse(ChatColor.translateAlternateColorCodes('&', text));
    }

    public static String parse(String text){
        return text.replace("{prefix}", Messages.getPrefix());
    }
}
