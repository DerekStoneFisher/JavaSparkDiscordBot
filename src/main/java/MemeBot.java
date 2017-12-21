//import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
//import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
//import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
//import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
//import net.dv8tion.jda.core.AccountType;
//import net.dv8tion.jda.core.JDA;
//import net.dv8tion.jda.core.JDABuilder;
//import net.dv8tion.jda.core.entities.Guild;
//import net.dv8tion.jda.core.entities.TextChannel;
//import net.dv8tion.jda.core.entities.VoiceChannel;
//import net.dv8tion.jda.core.exceptions.RateLimitedException;
//import net.dv8tion.jda.core.managers.AudioManager;
//
//import javax.security.auth.login.LoginException;
//import java.io.File;
//
///**
// * Created by C17050 on 12/18/2017.
// */
//public class MemeBot {
//    public static String VOICE_CHANNEL_ID = "388179567510028302";
//    public static String GUILD_ID =         "388179566390411275";
//
//    private JDA jda;
//    private Guild guild;
//    private VoiceChannel voiceChannel;
//
//    private TextChannel textChannel;
//
//
//    private AudioManager audioManager;
//    private AudioPlayerManager audioPlayerManager;
//    AudioPlayer audioPlayer;
//    AudioPlayerSendHandler audioPlayerSendHandler; // needed for JDA integration
//
//
//    public static void main(String args[]) throws LoginException, InterruptedException, RateLimitedException {
//        MemeBot memeBot = new MemeBot();
//        memeBot.sendImageTest();
//    }
//
//
//    public MemeBot() throws LoginException, InterruptedException, RateLimitedException {
//        this.jda = new JDABuilder(AccountType.BOT).setToken("MzkxMDIzNjQ0OTQxMzUyOTgw.DRSzhA.j5VH3rEkjaNeXlFHGkLhjhD6uOc").addEventListener(new ReadyListener()).buildBlocking();
//        this.guild = jda.getGuildById(GUILD_ID);
//        this.textChannel = jda.getTextChannelById("389258313994469378");
//        sendImageTest();
//    }
//
//    public void  initializeAudioStuff(){
//        audioPlayerManager = new DefaultAudioPlayerManager();
//        AudioSourceManagers.registerLocalSource(audioPlayerManager);
//        audioPlayer = audioPlayerManager.createPlayer();
//        audioPlayerSendHandler = new AudioPlayerSendHandler(audioPlayer);
//
//        this.voiceChannel = this.jda.getVoiceChannelById(VOICE_CHANNEL_ID);
//        this.audioManager = guild.getAudioManager();
//    }
//
//
////    public void sendAudioTest(){
////        audioPlayer.play();
////        this.audioManager.openAudioConnection(this.voiceChannel);
////        AudioSendHandler audioSendHandler = new AudioPlayerSendHandler();
////        // TODO: close audio connection
////    }
//
//    public void sendImageTest(){
//        File meme = new File("D:\\DerekProjects\\RandomStuff\\Huge Meme Pack\\Huge Meme Pack\\Meme pack by LiquidIllusion\\alien.jpg");
//        textChannel.sendFile(meme, meme.getName()).queue();
//    }
//
//}
