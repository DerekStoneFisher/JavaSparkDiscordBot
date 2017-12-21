import BotPackage.Const;
import BotPackage.ImageBot;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by C17050 on 12/19/2017.
 */
public class RandomScriptStuff {
    @Test
    public void tryOutImageBot() throws FileNotFoundException {
        ImageBot imageBot = new ImageBot();
        imageBot.getBestMemeMatchForStringSlow("To be fair, you have to have a very high IQ to understand Rick and Morty. The humour is extremely subtle, and without a solid grasp of theoretical physics most of the jokes will go over a typical viewer’s head. There’s also Rick’s nihilistic outlook, which is deftly woven into his characterisation- his personal philosophy draws heavily from Narodnaya Volya literature, for instance. The fans understand this stuff; they have the intellectual capacity to truly appreciate the depths of these jokes, to realise that they’re not just funny- they say something deep about LIFE. As a consequence people who dislike Rick & Morty truly ARE idiots- of course they wouldn’t appreciate, for instance, the humour in Rick’s existential catchphrase “Wubba Lubba Dub Dub,” which itself is a cryptic reference to Turgenev’s Russian epic Fathers and Sons. I’m smirking right now just imagining one of those addlepated simpletons scratching their heads in confusion as Dan Harmon’s genius wit unfolds itself on their television screens. What fools.. how I pity them. \uD83D\uDE02\n" +
                "\n" + " sweet jesus eyes hanging out " +
                "And yes, by the way, i DO have a Rick & Morty tattoo. And no, you cannot see it. It’s for the ladies’ eyes only- and even then they have to demonstrate that they’re within 5 IQ points of my own (preferably lower) beforehand. Nothin personnel kid \uD83D\uDE0E", Const.memeDirectory.listFiles());
    }
}
