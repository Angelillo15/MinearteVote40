package es.angelillo15.minearte.vote40;

import org.bukkit.plugin.java.JavaPlugin;

public class MinearteVote40Manager extends JavaPlugin {
    private static MinearteVote40Manager instance;

    public void setInstance(){
        instance = this;
    }

    public static MinearteVote40Manager getInstance(){
        return instance;
    }
}
