package BotPackage.UtilPackage;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by C17050 on 12/19/2017.
 */
public class MessageUtils {
    public static boolean messageContainsOneOfListItems(String message, String... list){
        message = message.toLowerCase();
        for (String listItem : list){
            listItem = listItem.toLowerCase();
            if (message.contains(listItem)) return true;
        }
        return false;
    }

    public static Message getAsMessage(String message){
        return new MessageBuilder().append(message).build();
    }

    public static String getRandomXd(){
        return getRandomXd(40); // 40 is a good number of D's. no significance to the number
    }

    public static String getRandomXd(int maxCount){
        int randomIndex = ThreadLocalRandom.current().nextInt(0, maxCount+1); // bound = exclusive, so +1
        return getXd(randomIndex);
    }

    public static String getXd(int xdCount){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("XD");
        for (int i = 0; i < xdCount-1 ; i++){
            stringBuilder.append("D");
        }
        return stringBuilder.toString();
    }
}
