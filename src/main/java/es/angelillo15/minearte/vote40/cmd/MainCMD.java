package es.angelillo15.minearte.vote40.cmd;

import es.angelillo15.minearte.vote40.api.VotePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            VotePlayer votePlayer = new VotePlayer((Player) sender);
            votePlayer.vote();
        }
        return false;
    }
}
