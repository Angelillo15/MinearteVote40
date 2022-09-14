package es.angelillo15.minearte.vote40.config;

import es.angelillo15.minearte.vote40.MinearteVote40Manager;

public class ConfigLoader {
    private final MinearteVote40Manager plugin;
    private static ConfigManager config;
    private static ConfigManager messages;

    public ConfigLoader(){
        this.plugin = MinearteVote40Manager.getInstance();
    }

    public void load(){
        loadConfig();
        loadMessages();
    }

    void loadConfig(){
        config = new ConfigManager(plugin.getDataFolder().toPath(), "config.yml", "config.yml");
        config.registerConfig();
    }

    void loadMessages(){
        messages = new ConfigManager(plugin.getDataFolder().toPath(), "messages.yml", "messages.yml");
        messages.registerConfig();
    }

    public static ConfigManager getConfig(){
        return config;
    }

    public static ConfigManager getMessages(){
        return messages;
    }
}
