package es.angelillo15.minearte.vote40.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import es.angelillo15.minearte.vote40.config.ConfigLoader;
import es.angelillo15.minearte.vote40.config.Messages;
import es.angelillo15.minearte.vote40.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VotePlayer {
    private Player player;

    private Boolean voted;

    private Boolean rewarded;

    public VotePlayer(Player player){
        this.player = player;
        this.voted = false;
        this.rewarded = false;
    }

    public Player getPlayer(){
        return player;
    }

    public Boolean getVoted(){
        return voted;
    }

    public Boolean getRewarded(){
        return rewarded;
    }

    public boolean vote(){
        Gson gson = new Gson();
        Unirest.setTimeouts(0, 0);
        try {
            HttpResponse<String> response = Unirest.get("https://40servidoresmc.es/api2.php?clave=%key%&estadisticas=1".replace("%key%", ConfigLoader.getConfig().getConfig().getString("Config.key"))).asString();
            JsonObject object = JsonParser.parseString(response.getBody()).getAsJsonObject();
            JsonObject[] jsons = gson.fromJson(object.get("ultimos20votos"), JsonObject[].class);
            for (JsonObject json : jsons) {
                if(json.get("usuario").getAsString().equals(player.getName())){
                    if(json.get("recompensado").getAsInt() == 0) {
                        voted = true;
                        rewarded = true;
                        for(String command : new ArrayList<>(ConfigLoader.getConfig().getConfig().getStringList("Config.commands"))){
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("{player}", player.getName()));
                        }
                        player.sendMessage(TextUtils.colorize(Messages.voteMessage()));
                        return true;
                    }else{
                        player.sendMessage(TextUtils.colorize(Messages.alreadyVoted()));
                        voted = true;
                        rewarded = true;
                        return false;
                    }
                }else {
                    player.sendMessage(TextUtils.colorize(Messages.noVote()));
                    rewarded = false;
                    voted = false;
                    return false;
                }
            }

        } catch (UnirestException e) {
            player.sendMessage(TextUtils.colorize(Messages.getError()));
            throw new RuntimeException(e);
        }
        return false;
    }

}
