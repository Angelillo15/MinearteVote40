package es.angelillo15.minearte.vote40;

import es.angelillo15.minearte.vote40.config.ConfigLoader;

public class MinearteVote40 extends MinearteVote40Manager {
    @Override
    public void onEnable() {
        setInstance();
        ConfigLoader configLoader = new ConfigLoader();
        configLoader.load();
    }

    @Override
    public void onDisable() {

    }

}
