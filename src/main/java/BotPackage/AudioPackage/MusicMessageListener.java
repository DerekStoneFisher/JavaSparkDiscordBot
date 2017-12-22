package BotPackage.AudioPackage;
/**
 * stolen from https://github.com/sedmelluq/lavaplayer/blob/master/demo-jda/src/main/java/com/sedmelluq/discord/lavaplayer/demo/jda/
 */

import BotPackage.JdaWrapper;
import BotPackage.UtilPackage.MessageUtils;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public class MusicMessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        System.out.println("received event:" + event.getClass() + "\t" + event.toString());

        if (!event.getMessage().getAuthor().getName().equals("Biggie Cheese") && JdaWrapper.guild != null) {
            String message = event.getMessage().getContentStripped();

            if (message.contains("moo")) {
                MusicPlayer.play("moo");
            } else if (MessageUtils.messageContainsOneOfListItems(message, "XD", "lol", "burger", "aut")){
                MusicPlayer.playRandomTrackFromFolder("santa claus is coming home");
//                ImageBot.postRandomMemeToChannel(event.getTextChannel(), message);
            } else if (message.equals("!shutdown")){
                System.exit(0);
            }

            processCommand(message);

        }

        super.onMessageReceived(event);
    }

    public void processCommand(String userMessageContent) {
        List<Character> commandPrefixList = Arrays.asList('!', '/', '\\', '-');
        if (userMessageContent.length() > 0 && commandPrefixList.contains(userMessageContent.charAt(0))) { // user sent a command
            userMessageContent = userMessageContent.substring(1); // strip the command prefix char

            // USER COMMANDS PROCESSED HERE
            String[] split = userMessageContent.split(" ");
            if (split.length > 1) {
                if (split[0].equals("play")) {
                    MusicPlayer.play(userMessageContent.replaceAll("^play ", ""));
                } else if (split[0].equals("stop")) {
                    MusicPlayer.stop();
                }
            }

        }
    }
}