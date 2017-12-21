package BotPackage.AudioPackage;

/**
 * stolen from https://github.com/sedmelluq/lavaplayer/blob/master/demo-jda/src/main/java/com/sedmelluq/discord/lavaplayer/demo/jda/
 */

import BotPackage.Const;
import BotPackage.JdaWrapper;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.managers.AudioManager;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Holder for both the player and a track scheduler for one guild.
 * stolen from https://github.com/sedmelluq/lavaplayer/blob/master/demo-jda/src/main/java/com/sedmelluq/discord/lavaplayer/demo/jda/
 */
public class MusicPlayer {
    /**
     * Audio player for the guild.
     */
    private static final AudioPlayer player;
    private static final AudioPlayerManager playerManager;


    static {
        playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);
        AudioSourceManagers.registerLocalSource(playerManager);
        player = playerManager.createPlayer();
        JdaWrapper.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(player));
    }

    public static void playRandomTrackFromFolder(String folderName){
        File folderToPickTrackFrom;
        if (folderName == null || folderName.length() == 0){
            folderToPickTrackFrom = new File(Const.RESOURCES_PATH);
        } else {
            folderToPickTrackFrom = new File(Const.RESOURCES_PATH + File.separator + folderName);
            if (folderToPickTrackFrom.exists()){
                File[] files = folderToPickTrackFrom.listFiles();
                int randomIndex = ThreadLocalRandom.current().nextInt(0, files.length); // files.length = 1 based index, so -1. but bound = exclusive, so +1. they cancel so I don't put either
                play(files[randomIndex].getAbsolutePath());
            } else {
                System.out.println("can't play random song from non-existent folder: '" + folderToPickTrackFrom.getAbsolutePath() + "'"); // TODO: replace with logger.error
            }
        }
    }

    public static void play(String trackIdentifier) {
        trackIdentifier = parseTrackIdentifier(trackIdentifier);
        final String trackIdenifierForPrintStatement = trackIdentifier;

        playerManager.loadItem(trackIdentifier, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                    connectToFirstVoiceChannel();
//                connectToTestVoiceChanel();
                System.out.println("playing track: " + trackIdenifierForPrintStatement);
                player.startTrack(track, false);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                System.out.println("playlistLoaded() purposefully was not implemented - yet it was called.");
            }

            @Override
            public void noMatches() {

                System.out.println("no matches");
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                System.out.println("Could not play: " + exception.getMessage());
            }
        });

    }

    public static void stop() {
        player.stopTrack();
    }

    private static void connectToFirstVoiceChannel() {
        AudioManager audioManager = JdaWrapper.guild.getAudioManager();
        if (!audioManager.isConnected() && !audioManager.isAttemptingToConnect()) {
            for (VoiceChannel voiceChannel : audioManager.getGuild().getVoiceChannels()) {
                audioManager.openAudioConnection(voiceChannel);
                break;
            }
        }
    }

    private static void connectToTestVoiceChanel() {
        AudioManager audioManager = JdaWrapper.guild.getAudioManager();
        audioManager.openAudioConnection(JdaWrapper.guild.getVoiceChannelById("391740514723954688"));
    }

    private static String parseTrackIdentifier(String identifier) {
        if (identifier.startsWith("http") || identifier.contains("\\")) {
            return identifier;
        } else {
            identifier = Const.RESOURCES_PATH + File.separator + identifier;
            if (!identifier.endsWith(".mp3")) {
                identifier += ".mp3";
            }
            return identifier;
        }
    }

}