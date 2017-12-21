//package BotPackage;
//
//import net.dv8tion.jda.core.entities.MessageChannel;
//import net.dv8tion.jda.core.events.Event;
//import net.dv8tion.jda.core.events.channel.voice.GenericVoiceChannelEvent;
//import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
//import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
//import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
//import net.dv8tion.jda.core.hooks.EventListener;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by C17050 on 12/19/2017.
// */
//public class ReadyListener implements EventListener
//{
//    @Override
//    public void onEvent(Event event) {
//        System.out.println("received event:" + event.getClass() + "\t" + event.toString());
//
//        // MESSAGE SEND HANDLING
//        if (event instanceof GuildMessageReceivedEvent) {
//            GuildMessageReceivedEvent messageEvent = (GuildMessageReceivedEvent) event;
//            if (!messageEvent.getMessage().getAuthor().getName().equals("Biggie Cheese")) {
//                MessageChannel channel = messageEvent.getChannel();
//                String userMessageContent = messageEvent.getMessage().getContentStripped().toLowerCase();
//
//                List<Character> commandPrefixList = Arrays.asList('!', '/', '\\', '-');
//                if (userMessageContent.length() > 0 && commandPrefixList.contains(userMessageContent.charAt(0))){ // user sent a command
//                    userMessageContent = userMessageContent.substring(1); // strip the command prefix char
//                    // TODO: process user commands
//
//                    String[] split = userMessageContent.split(" ");
//                    if (split.length > 1){
//                        if (split[0].equals("play")){
//
//                        }
//                    }
//                }
//            }
//        }
//
//        // VOICE EVENTS
//        if (event instanceof GenericVoiceChannelEvent) {
//
//            // SOMEONE JOINED A VOICE CHANNEL
//            if (event instanceof GuildVoiceJoinEvent) {
//
//            }
//
//            // SOMEONE LEFT A VOICE CHANNEL
//            if (event instanceof GuildVoiceLeaveEvent){
//
//            }
//        }
//
//
//    }
//}