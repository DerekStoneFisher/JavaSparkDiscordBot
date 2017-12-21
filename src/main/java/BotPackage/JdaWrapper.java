package BotPackage;

import BotPackage.AudioPackage.MusicMessageListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/**
 * This class has public variables for things like text channels, voice channels, the JDA, and other things that are shared between
 * It is a singleton
 */
public class JdaWrapper {
    public static JDA jda;
    public static Guild guild;

    public static TextChannel textChannelBoombastic;
    public static TextChannel textChannelGeneral;

    public static VoiceChannel voiceChannel;

    static {
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("MzkxMDIzNjQ0OTQxMzUyOTgw.DRSzhA.j5VH3rEkjaNeXlFHGkLhjhD6uOc").buildBlocking();
//            jda.addEventListener(new ReadyListener());
            jda.addEventListener(new MusicMessageListener());

            guild = jda.getGuildById(Const.GUILD_ID);
            textChannelBoombastic = jda.getTextChannelById(Const.BOOMBASTIC_TEXT_CHANNEL_ID);
            textChannelGeneral = jda.getTextChannelById(Const.GENERAL_TEXT_CHANNEL_ID);
            voiceChannel = jda.getVoiceChannelById(Const.VOICE_CHANNEL_ID);
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
            throw new RuntimeException("Fatal error: could not initialize JDA. See stack trace above for details.");
        }

    }


}

