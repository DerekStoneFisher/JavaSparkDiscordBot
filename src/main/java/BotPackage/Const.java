package BotPackage;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by C17050 on 12/19/2017.
 */
public class Const {
    public static final String VOICE_CHANNEL_ID = "388179567510028302";
    public static final String GUILD_ID =         "388179566390411275";
    public static final String BOOMBASTIC_TEXT_CHANNEL_ID = "389258313994469378";
    public static final String GENERAL_TEXT_CHANNEL_ID = "388179567510028299";

    public static final File memeDirectory = new File("D:\\DerekProjects\\RandomStuff\\Huge Meme Pack\\Huge Meme Pack\\Meme pack by LiquidIllusion");
    public static Set<String> stopWordSet = new HashSet<>(Arrays.asList("a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours	ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves"));

    public static String RESOURCES_PATH = IOUtils.getPathOfResource("");

}
