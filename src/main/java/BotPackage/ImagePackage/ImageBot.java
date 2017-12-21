package BotPackage.ImagePackage;

import BotPackage.Const;
import BotPackage.UtilPackage.MessageUtils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by C17050 on 12/19/2017.
 */
public class ImageBot {
    public static void postRandomMemeToChannel(TextChannel textChannel, String message){
        File randomMeme = getRandomMeme();
        Message customMessage = MessageUtils.getAsMessage(MessageUtils.getRandomXd());
        textChannel.sendFile(randomMeme, getRandomMeme().getName(), customMessage).queue();
    }

    private static File getRandomMeme(){
        File[] memeCollection = Const.memeDirectory.listFiles();
        int maxIndex = memeCollection.length-1; // account for 0 based index so -1
        int randomIndex = ThreadLocalRandom.current().nextInt(0, maxIndex+1); // bound = exclusive, so +1
        return memeCollection[randomIndex];
    }
}
