package es.angelillo15.minearte.vote40.config;

import org.simpleyaml.configuration.file.YamlFile;

public class Messages {
    public static YamlFile config = ConfigLoader.getMessages().getConfig();

    public static String getPrefix(){
        return config.getString("Messages.prefix");
    }

    public static String broadcastMessage(){
        return config.getString("Messages.broadcast");
    }

    public static String noPermission(){
        return config.getString("Messages.no-permission");
    }

    public static String noVote(){
        return config.getString("Messages.no-vote");
    }

    public static String voteMessage(){
        return config.getString("Messages.voteMessage");
    }

    public static String alreadyVoted(){
        return config.getString("Messages.already-voted");
    }

    public static String getError(){
        return config.getString("Messages.error");
    }

    public static String getHelp(){
        return config.getString("Messages.help");
    }
}
